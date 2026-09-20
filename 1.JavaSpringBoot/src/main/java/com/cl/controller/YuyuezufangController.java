package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.YuyuezufangEntity;
import com.cl.entity.view.YuyuezufangView;

import com.cl.service.YuyuezufangService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 预约租房
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
@RestController
@RequestMapping("/yuyuezufang")
public class YuyuezufangController {
    @Autowired
    private YuyuezufangService yuyuezufangService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuyuezufangEntity yuyuezufang,
                @RequestParam(required = false) Double chuzujiagestart,
                @RequestParam(required = false) Double chuzujiageend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jingjiren")) {
			yuyuezufang.setJingjirenzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			yuyuezufang.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuyuezufangEntity> ew = new EntityWrapper<YuyuezufangEntity>();
                if(chuzujiagestart!=null) ew.ge("chuzujiage", chuzujiagestart);
                if(chuzujiageend!=null) ew.le("chuzujiage", chuzujiageend);

		PageUtils page = yuyuezufangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuezufang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuyuezufangEntity yuyuezufang, 
                @RequestParam(required = false) Double chuzujiagestart,
                @RequestParam(required = false) Double chuzujiageend,
		HttpServletRequest request){
        EntityWrapper<YuyuezufangEntity> ew = new EntityWrapper<YuyuezufangEntity>();
                if(chuzujiagestart!=null) ew.ge("chuzujiage", chuzujiagestart);
                if(chuzujiageend!=null) ew.le("chuzujiage", chuzujiageend);

		PageUtils page = yuyuezufangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuezufang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuyuezufangEntity yuyuezufang){
       	EntityWrapper<YuyuezufangEntity> ew = new EntityWrapper<YuyuezufangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuyuezufang, "yuyuezufang")); 
        return R.ok().put("data", yuyuezufangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuyuezufangEntity yuyuezufang){
        EntityWrapper< YuyuezufangEntity> ew = new EntityWrapper< YuyuezufangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuyuezufang, "yuyuezufang")); 
		YuyuezufangView yuyuezufangView =  yuyuezufangService.selectView(ew);
		return R.ok("查询预约租房成功").put("data", yuyuezufangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuyuezufangEntity yuyuezufang = yuyuezufangService.selectById(id);
        return R.ok().put("data", yuyuezufang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuyuezufangEntity yuyuezufang = yuyuezufangService.selectById(id);
        return R.ok().put("data", yuyuezufang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuyuezufangEntity yuyuezufang, HttpServletRequest request){
    	yuyuezufang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuyuezufang);
        yuyuezufangService.insert(yuyuezufang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuyuezufangEntity yuyuezufang, HttpServletRequest request){
    	yuyuezufang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuyuezufang);
        yuyuezufangService.insert(yuyuezufang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuyuezufangEntity yuyuezufang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuyuezufang);
        yuyuezufangService.updateById(yuyuezufang);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<YuyuezufangEntity> list = new ArrayList<YuyuezufangEntity>();
        for(Long id : ids) {
            YuyuezufangEntity yuyuezufang = yuyuezufangService.selectById(id);
            yuyuezufang.setSfsh(sfsh);
            yuyuezufang.setShhf(shhf);
            list.add(yuyuezufang);
        }
        yuyuezufangService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuyuezufangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
