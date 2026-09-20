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


import com.cl.dao.JingjirenDao;
import com.cl.entity.JingjirenEntity;
import com.cl.service.JingjirenService;
import com.cl.entity.view.JingjirenView;

@Service("jingjirenService")
public class JingjirenServiceImpl extends ServiceImpl<JingjirenDao, JingjirenEntity> implements JingjirenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JingjirenEntity> page = this.selectPage(
                new Query<JingjirenEntity>(params).getPage(),
                new EntityWrapper<JingjirenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JingjirenEntity> wrapper) {
		  Page<JingjirenView> page =new Query<JingjirenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JingjirenView> selectListView(Wrapper<JingjirenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JingjirenView selectView(Wrapper<JingjirenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
