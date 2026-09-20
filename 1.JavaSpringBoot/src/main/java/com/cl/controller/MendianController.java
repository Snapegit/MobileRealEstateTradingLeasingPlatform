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

import com.cl.entity.MendianEntity;
import com.cl.entity.view.MendianView;

import com.cl.service.MendianService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 门店
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
@RestController
@RequestMapping("/mendian")
public class MendianController {
    @Autowired
    private MendianService mendianService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MendianEntity mendian,
		HttpServletRequest request){
        EntityWrapper<MendianEntity> ew = new EntityWrapper<MendianEntity>();

		PageUtils page = mendianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mendian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MendianEntity mendian, 
		HttpServletRequest request){
        EntityWrapper<MendianEntity> ew = new EntityWrapper<MendianEntity>();

		PageUtils page = mendianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mendian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MendianEntity mendian){
       	EntityWrapper<MendianEntity> ew = new EntityWrapper<MendianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( mendian, "mendian")); 
        return R.ok().put("data", mendianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MendianEntity mendian){
        EntityWrapper< MendianEntity> ew = new EntityWrapper< MendianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( mendian, "mendian")); 
		MendianView mendianView =  mendianService.selectView(ew);
		return R.ok("查询门店成功").put("data", mendianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MendianEntity mendian = mendianService.selectById(id);
        return R.ok().put("data", mendian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MendianEntity mendian = mendianService.selectById(id);
        return R.ok().put("data", mendian);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MendianEntity mendian, HttpServletRequest request){
    	mendian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(mendian);
        mendianService.insert(mendian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MendianEntity mendian, HttpServletRequest request){
    	mendian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(mendian);
        mendianService.insert(mendian);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MendianEntity mendian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(mendian);
        mendianService.updateById(mendian);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        mendianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
