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


import com.cl.dao.DiscussfangyuanchuzuDao;
import com.cl.entity.DiscussfangyuanchuzuEntity;
import com.cl.service.DiscussfangyuanchuzuService;
import com.cl.entity.view.DiscussfangyuanchuzuView;

@Service("discussfangyuanchuzuService")
public class DiscussfangyuanchuzuServiceImpl extends ServiceImpl<DiscussfangyuanchuzuDao, DiscussfangyuanchuzuEntity> implements DiscussfangyuanchuzuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussfangyuanchuzuEntity> page = this.selectPage(
                new Query<DiscussfangyuanchuzuEntity>(params).getPage(),
                new EntityWrapper<DiscussfangyuanchuzuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussfangyuanchuzuEntity> wrapper) {
		  Page<DiscussfangyuanchuzuView> page =new Query<DiscussfangyuanchuzuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussfangyuanchuzuView> selectListView(Wrapper<DiscussfangyuanchuzuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussfangyuanchuzuView selectView(Wrapper<DiscussfangyuanchuzuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
