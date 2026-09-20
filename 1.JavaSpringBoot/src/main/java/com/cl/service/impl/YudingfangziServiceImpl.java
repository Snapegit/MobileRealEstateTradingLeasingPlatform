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


import com.cl.dao.YudingfangziDao;
import com.cl.entity.YudingfangziEntity;
import com.cl.service.YudingfangziService;
import com.cl.entity.view.YudingfangziView;

@Service("yudingfangziService")
public class YudingfangziServiceImpl extends ServiceImpl<YudingfangziDao, YudingfangziEntity> implements YudingfangziService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YudingfangziEntity> page = this.selectPage(
                new Query<YudingfangziEntity>(params).getPage(),
                new EntityWrapper<YudingfangziEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YudingfangziEntity> wrapper) {
		  Page<YudingfangziView> page =new Query<YudingfangziView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YudingfangziView> selectListView(Wrapper<YudingfangziEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YudingfangziView selectView(Wrapper<YudingfangziEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
