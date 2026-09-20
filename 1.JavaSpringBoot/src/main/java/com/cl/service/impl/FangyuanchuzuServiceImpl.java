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


import com.cl.dao.FangyuanchuzuDao;
import com.cl.entity.FangyuanchuzuEntity;
import com.cl.service.FangyuanchuzuService;
import com.cl.entity.view.FangyuanchuzuView;

@Service("fangyuanchuzuService")
public class FangyuanchuzuServiceImpl extends ServiceImpl<FangyuanchuzuDao, FangyuanchuzuEntity> implements FangyuanchuzuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangyuanchuzuEntity> page = this.selectPage(
                new Query<FangyuanchuzuEntity>(params).getPage(),
                new EntityWrapper<FangyuanchuzuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FangyuanchuzuEntity> wrapper) {
		  Page<FangyuanchuzuView> page =new Query<FangyuanchuzuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<FangyuanchuzuView> selectListView(Wrapper<FangyuanchuzuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangyuanchuzuView selectView(Wrapper<FangyuanchuzuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
