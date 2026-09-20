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


import com.cl.dao.YuyuezufangDao;
import com.cl.entity.YuyuezufangEntity;
import com.cl.service.YuyuezufangService;
import com.cl.entity.view.YuyuezufangView;

@Service("yuyuezufangService")
public class YuyuezufangServiceImpl extends ServiceImpl<YuyuezufangDao, YuyuezufangEntity> implements YuyuezufangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuyuezufangEntity> page = this.selectPage(
                new Query<YuyuezufangEntity>(params).getPage(),
                new EntityWrapper<YuyuezufangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuyuezufangEntity> wrapper) {
		  Page<YuyuezufangView> page =new Query<YuyuezufangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YuyuezufangView> selectListView(Wrapper<YuyuezufangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuyuezufangView selectView(Wrapper<YuyuezufangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
