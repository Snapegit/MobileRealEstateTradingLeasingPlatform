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

import com.cl.entity.ZufangxinxiEntity;
import com.cl.entity.view.ZufangxinxiView;

import com.cl.service.ZufangxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 租房信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
@RestController
@RequestMapping("/zufangxinxi")
public class ZufangxinxiController {
    @Autowired
    private ZufangxinxiService zufangxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZufangxinxiEntity zufangxinxi,
                @RequestParam(required = false) Double chuzujiagestart,
                @RequestParam(required = false) Double chuzujiageend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jingjiren")) {
			zufangxinxi.setJingjirenzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			zufangxinxi.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZufangxinxiEntity> ew = new EntityWrapper<ZufangxinxiEntity>();
                if(chuzujiagestart!=null) ew.ge("chuzujiage", chuzujiagestart);
                if(chuzujiageend!=null) ew.le("chuzujiage", chuzujiageend);

		PageUtils page = zufangxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zufangxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZufangxinxiEntity zufangxinxi, 
                @RequestParam(required = false) Double chuzujiagestart,
                @RequestParam(required = false) Double chuzujiageend,
		HttpServletRequest request){
        EntityWrapper<ZufangxinxiEntity> ew = new EntityWrapper<ZufangxinxiEntity>();
                if(chuzujiagestart!=null) ew.ge("chuzujiage", chuzujiagestart);
                if(chuzujiageend!=null) ew.le("chuzujiage", chuzujiageend);

		PageUtils page = zufangxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zufangxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZufangxinxiEntity zufangxinxi){
       	EntityWrapper<ZufangxinxiEntity> ew = new EntityWrapper<ZufangxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zufangxinxi, "zufangxinxi")); 
        return R.ok().put("data", zufangxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZufangxinxiEntity zufangxinxi){
        EntityWrapper< ZufangxinxiEntity> ew = new EntityWrapper< ZufangxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zufangxinxi, "zufangxinxi")); 
		ZufangxinxiView zufangxinxiView =  zufangxinxiService.selectView(ew);
		return R.ok("查询租房信息成功").put("data", zufangxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZufangxinxiEntity zufangxinxi = zufangxinxiService.selectById(id);
        return R.ok().put("data", zufangxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZufangxinxiEntity zufangxinxi = zufangxinxiService.selectById(id);
        return R.ok().put("data", zufangxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZufangxinxiEntity zufangxinxi, HttpServletRequest request){
    	zufangxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zufangxinxi);
        zufangxinxiService.insert(zufangxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZufangxinxiEntity zufangxinxi, HttpServletRequest request){
    	zufangxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zufangxinxi);
        zufangxinxiService.insert(zufangxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZufangxinxiEntity zufangxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zufangxinxi);
        zufangxinxiService.updateById(zufangxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zufangxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
