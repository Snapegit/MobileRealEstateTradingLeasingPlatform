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

import com.cl.entity.FangyuanchuzuEntity;
import com.cl.entity.view.FangyuanchuzuView;

import com.cl.service.FangyuanchuzuService;
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
 * 房源出租
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
@RestController
@RequestMapping("/fangyuanchuzu")
public class FangyuanchuzuController {
    @Autowired
    private FangyuanchuzuService fangyuanchuzuService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangyuanchuzuEntity fangyuanchuzu,
                @RequestParam(required = false) Double chuzujiagestart,
                @RequestParam(required = false) Double chuzujiageend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jingjiren")) {
			fangyuanchuzu.setJingjirenzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FangyuanchuzuEntity> ew = new EntityWrapper<FangyuanchuzuEntity>();
                if(chuzujiagestart!=null) ew.ge("chuzujiage", chuzujiagestart);
                if(chuzujiageend!=null) ew.le("chuzujiage", chuzujiageend);

		PageUtils page = fangyuanchuzuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangyuanchuzu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangyuanchuzuEntity fangyuanchuzu, 
                @RequestParam(required = false) Double chuzujiagestart,
                @RequestParam(required = false) Double chuzujiageend,
		HttpServletRequest request){
        EntityWrapper<FangyuanchuzuEntity> ew = new EntityWrapper<FangyuanchuzuEntity>();
                if(chuzujiagestart!=null) ew.ge("chuzujiage", chuzujiagestart);
                if(chuzujiageend!=null) ew.le("chuzujiage", chuzujiageend);

		PageUtils page = fangyuanchuzuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangyuanchuzu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangyuanchuzuEntity fangyuanchuzu){
       	EntityWrapper<FangyuanchuzuEntity> ew = new EntityWrapper<FangyuanchuzuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangyuanchuzu, "fangyuanchuzu")); 
        return R.ok().put("data", fangyuanchuzuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangyuanchuzuEntity fangyuanchuzu){
        EntityWrapper< FangyuanchuzuEntity> ew = new EntityWrapper< FangyuanchuzuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangyuanchuzu, "fangyuanchuzu")); 
		FangyuanchuzuView fangyuanchuzuView =  fangyuanchuzuService.selectView(ew);
		return R.ok("查询房源出租成功").put("data", fangyuanchuzuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangyuanchuzuEntity fangyuanchuzu = fangyuanchuzuService.selectById(id);
        return R.ok().put("data", fangyuanchuzu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangyuanchuzuEntity fangyuanchuzu = fangyuanchuzuService.selectById(id);
        return R.ok().put("data", fangyuanchuzu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FangyuanchuzuEntity fangyuanchuzu, HttpServletRequest request){
    	fangyuanchuzu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangyuanchuzu);
        fangyuanchuzuService.insert(fangyuanchuzu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FangyuanchuzuEntity fangyuanchuzu, HttpServletRequest request){
    	fangyuanchuzu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangyuanchuzu);
        fangyuanchuzuService.insert(fangyuanchuzu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FangyuanchuzuEntity fangyuanchuzu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangyuanchuzu);
        fangyuanchuzuService.updateById(fangyuanchuzu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fangyuanchuzuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
