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


import com.cl.dao.MendianDao;
import com.cl.entity.MendianEntity;
import com.cl.service.MendianService;
import com.cl.entity.view.MendianView;

@Service("mendianService")
public class MendianServiceImpl extends ServiceImpl<MendianDao, MendianEntity> implements MendianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MendianEntity> page = this.selectPage(
                new Query<MendianEntity>(params).getPage(),
                new EntityWrapper<MendianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MendianEntity> wrapper) {
		  Page<MendianView> page =new Query<MendianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<MendianView> selectListView(Wrapper<MendianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MendianView selectView(Wrapper<MendianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
