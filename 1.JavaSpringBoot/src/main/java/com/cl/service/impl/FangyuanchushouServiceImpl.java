package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.FangyuanchushouDao;
import com.cl.entity.FangyuanchushouEntity;
import com.cl.service.FangyuanchushouService;
import com.cl.entity.view.FangyuanchushouView;

@Service("fangyuanchushouService")
public class FangyuanchushouServiceImpl extends ServiceImpl<FangyuanchushouDao, FangyuanchushouEntity> implements FangyuanchushouService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangyuanchushouEntity> page = this.selectPage(
                new Query<FangyuanchushouEntity>(params).getPage(),
                new EntityWrapper<FangyuanchushouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FangyuanchushouEntity> wrapper) {
		  Page<FangyuanchushouView> page =new Query<FangyuanchushouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<FangyuanchushouView> selectListView(Wrapper<FangyuanchushouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangyuanchushouView selectView(Wrapper<FangyuanchushouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
