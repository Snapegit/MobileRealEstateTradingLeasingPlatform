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

import com.cl.entity.YudingfangziEntity;
import com.cl.entity.view.YudingfangziView;

import com.cl.service.YudingfangziService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 预定房子
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
@RestController
@RequestMapping("/yudingfangzi")
public class YudingfangziController {
    @Autowired
    private YudingfangziService yudingfangziService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YudingfangziEntity yudingfangzi,
                @RequestParam(required = false) Double dingjinstart,
                @RequestParam(required = false) Double dingjinend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jingjiren")) {
			yudingfangzi.setJingjirenzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			yudingfangzi.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YudingfangziEntity> ew = new EntityWrapper<YudingfangziEntity>();
                if(dingjinstart!=null) ew.ge("dingjin", dingjinstart);
                if(dingjinend!=null) ew.le("dingjin", dingjinend);

		PageUtils page = yudingfangziService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yudingfangzi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YudingfangziEntity yudingfangzi, 
                @RequestParam(required = false) Double dingjinstart,
                @RequestParam(required = false) Double dingjinend,
		HttpServletRequest request){
        EntityWrapper<YudingfangziEntity> ew = new EntityWrapper<YudingfangziEntity>();
                if(dingjinstart!=null) ew.ge("dingjin", dingjinstart);
                if(dingjinend!=null) ew.le("dingjin", dingjinend);

		PageUtils page = yudingfangziService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yudingfangzi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YudingfangziEntity yudingfangzi){
       	EntityWrapper<YudingfangziEntity> ew = new EntityWrapper<YudingfangziEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yudingfangzi, "yudingfangzi")); 
        return R.ok().put("data", yudingfangziService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YudingfangziEntity yudingfangzi){
        EntityWrapper< YudingfangziEntity> ew = new EntityWrapper< YudingfangziEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yudingfangzi, "yudingfangzi")); 
		YudingfangziView yudingfangziView =  yudingfangziService.selectView(ew);
		return R.ok("查询预定房子成功").put("data", yudingfangziView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YudingfangziEntity yudingfangzi = yudingfangziService.selectById(id);
        return R.ok().put("data", yudingfangzi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YudingfangziEntity yudingfangzi = yudingfangziService.selectById(id);
        return R.ok().put("data", yudingfangzi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YudingfangziEntity yudingfangzi, HttpServletRequest request){
    	yudingfangzi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yudingfangzi);
        yudingfangziService.insert(yudingfangzi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YudingfangziEntity yudingfangzi, HttpServletRequest request){
    	yudingfangzi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yudingfangzi);
        yudingfangziService.insert(yudingfangzi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YudingfangziEntity yudingfangzi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yudingfangzi);
        yudingfangziService.updateById(yudingfangzi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yudingfangziService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
