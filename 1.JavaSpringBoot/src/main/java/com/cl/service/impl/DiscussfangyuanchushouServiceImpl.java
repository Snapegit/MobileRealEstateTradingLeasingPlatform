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


import com.cl.dao.DiscussfangyuanchushouDao;
import com.cl.entity.DiscussfangyuanchushouEntity;
import com.cl.service.DiscussfangyuanchushouService;
import com.cl.entity.view.DiscussfangyuanchushouView;

@Service("discussfangyuanchushouService")
public class DiscussfangyuanchushouServiceImpl extends ServiceImpl<DiscussfangyuanchushouDao, DiscussfangyuanchushouEntity> implements DiscussfangyuanchushouService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussfangyuanchushouEntity> page = this.selectPage(
                new Query<DiscussfangyuanchushouEntity>(params).getPage(),
                new EntityWrapper<DiscussfangyuanchushouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussfangyuanchushouEntity> wrapper) {
		  Page<DiscussfangyuanchushouView> page =new Query<DiscussfangyuanchushouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussfangyuanchushouView> selectListView(Wrapper<DiscussfangyuanchushouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussfangyuanchushouView selectView(Wrapper<DiscussfangyuanchushouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
