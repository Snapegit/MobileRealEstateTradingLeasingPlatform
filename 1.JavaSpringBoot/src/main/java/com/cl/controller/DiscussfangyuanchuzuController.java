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

import com.cl.entity.DiscussfangyuanchuzuEntity;
import com.cl.entity.view.DiscussfangyuanchuzuView;

import com.cl.service.DiscussfangyuanchuzuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 房源出租评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
@RestController
@RequestMapping("/discussfangyuanchuzu")
public class DiscussfangyuanchuzuController {
    @Autowired
    private DiscussfangyuanchuzuService discussfangyuanchuzuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussfangyuanchuzuEntity discussfangyuanchuzu,
		HttpServletRequest request){
        EntityWrapper<DiscussfangyuanchuzuEntity> ew = new EntityWrapper<DiscussfangyuanchuzuEntity>();

		PageUtils page = discussfangyuanchuzuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussfangyuanchuzu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussfangyuanchuzuEntity discussfangyuanchuzu, 
		HttpServletRequest request){
        EntityWrapper<DiscussfangyuanchuzuEntity> ew = new EntityWrapper<DiscussfangyuanchuzuEntity>();

		PageUtils page = discussfangyuanchuzuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussfangyuanchuzu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussfangyuanchuzuEntity discussfangyuanchuzu){
       	EntityWrapper<DiscussfangyuanchuzuEntity> ew = new EntityWrapper<DiscussfangyuanchuzuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussfangyuanchuzu, "discussfangyuanchuzu")); 
        return R.ok().put("data", discussfangyuanchuzuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussfangyuanchuzuEntity discussfangyuanchuzu){
        EntityWrapper< DiscussfangyuanchuzuEntity> ew = new EntityWrapper< DiscussfangyuanchuzuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussfangyuanchuzu, "discussfangyuanchuzu")); 
		DiscussfangyuanchuzuView discussfangyuanchuzuView =  discussfangyuanchuzuService.selectView(ew);
		return R.ok("查询房源出租评论表成功").put("data", discussfangyuanchuzuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussfangyuanchuzuEntity discussfangyuanchuzu = discussfangyuanchuzuService.selectById(id);
        return R.ok().put("data", discussfangyuanchuzu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussfangyuanchuzuEntity discussfangyuanchuzu = discussfangyuanchuzuService.selectById(id);
        return R.ok().put("data", discussfangyuanchuzu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussfangyuanchuzuEntity discussfangyuanchuzu, HttpServletRequest request){
    	discussfangyuanchuzu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussfangyuanchuzu);
        discussfangyuanchuzuService.insert(discussfangyuanchuzu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussfangyuanchuzuEntity discussfangyuanchuzu, HttpServletRequest request){
    	discussfangyuanchuzu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussfangyuanchuzu);
        discussfangyuanchuzuService.insert(discussfangyuanchuzu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussfangyuanchuzuEntity discussfangyuanchuzu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussfangyuanchuzu);
        discussfangyuanchuzuService.updateById(discussfangyuanchuzu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussfangyuanchuzuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussfangyuanchuzuEntity discussfangyuanchuzu, HttpServletRequest request,String pre){
        EntityWrapper<DiscussfangyuanchuzuEntity> ew = new EntityWrapper<DiscussfangyuanchuzuEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussfangyuanchuzuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussfangyuanchuzu), params), params));
        return R.ok().put("data", page);
    }








}
