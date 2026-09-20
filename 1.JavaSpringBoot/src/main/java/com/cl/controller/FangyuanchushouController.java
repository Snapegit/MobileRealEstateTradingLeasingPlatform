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

import com.cl.entity.FangyuanchushouEntity;
import com.cl.entity.view.FangyuanchushouView;

import com.cl.service.FangyuanchushouService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 房源出售
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
@RestController
@RequestMapping("/fangyuanchushou")
public class FangyuanchushouController {
    @Autowired
    private FangyuanchushouService fangyuanchushouService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangyuanchushouEntity fangyuanchushou,
                @RequestParam(required = false) Double xiaoshoujiagestart,
                @RequestParam(required = false) Double xiaoshoujiageend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jingjiren")) {
			fangyuanchushou.setJingjirenzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FangyuanchushouEntity> ew = new EntityWrapper<FangyuanchushouEntity>();
                if(xiaoshoujiagestart!=null) ew.ge("xiaoshoujiage", xiaoshoujiagestart);
                if(xiaoshoujiageend!=null) ew.le("xiaoshoujiage", xiaoshoujiageend);

		PageUtils page = fangyuanchushouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangyuanchushou), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangyuanchushouEntity fangyuanchushou, 
                @RequestParam(required = false) Double xiaoshoujiagestart,
                @RequestParam(required = false) Double xiaoshoujiageend,
		HttpServletRequest request){
        EntityWrapper<FangyuanchushouEntity> ew = new EntityWrapper<FangyuanchushouEntity>();
                if(xiaoshoujiagestart!=null) ew.ge("xiaoshoujiage", xiaoshoujiagestart);
                if(xiaoshoujiageend!=null) ew.le("xiaoshoujiage", xiaoshoujiageend);

		PageUtils page = fangyuanchushouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangyuanchushou), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangyuanchushouEntity fangyuanchushou){
       	EntityWrapper<FangyuanchushouEntity> ew = new EntityWrapper<FangyuanchushouEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangyuanchushou, "fangyuanchushou")); 
        return R.ok().put("data", fangyuanchushouService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangyuanchushouEntity fangyuanchushou){
        EntityWrapper< FangyuanchushouEntity> ew = new EntityWrapper< FangyuanchushouEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangyuanchushou, "fangyuanchushou")); 
		FangyuanchushouView fangyuanchushouView =  fangyuanchushouService.selectView(ew);
		return R.ok("查询房源出售成功").put("data", fangyuanchushouView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangyuanchushouEntity fangyuanchushou = fangyuanchushouService.selectById(id);
        return R.ok().put("data", fangyuanchushou);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangyuanchushouEntity fangyuanchushou = fangyuanchushouService.selectById(id);
        return R.ok().put("data", fangyuanchushou);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FangyuanchushouEntity fangyuanchushou, HttpServletRequest request){
    	fangyuanchushou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangyuanchushou);
        fangyuanchushouService.insert(fangyuanchushou);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FangyuanchushouEntity fangyuanchushou, HttpServletRequest request){
    	fangyuanchushou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangyuanchushou);
        fangyuanchushouService.insert(fangyuanchushou);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FangyuanchushouEntity fangyuanchushou, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangyuanchushou);
        fangyuanchushouService.updateById(fangyuanchushou);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fangyuanchushouService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
