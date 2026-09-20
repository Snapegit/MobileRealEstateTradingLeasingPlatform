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


import com.cl.dao.ZufangxinxiDao;
import com.cl.entity.ZufangxinxiEntity;
import com.cl.service.ZufangxinxiService;
import com.cl.entity.view.ZufangxinxiView;

@Service("zufangxinxiService")
public class ZufangxinxiServiceImpl extends ServiceImpl<ZufangxinxiDao, ZufangxinxiEntity> implements ZufangxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZufangxinxiEntity> page = this.selectPage(
                new Query<ZufangxinxiEntity>(params).getPage(),
                new EntityWrapper<ZufangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZufangxinxiEntity> wrapper) {
		  Page<ZufangxinxiView> page =new Query<ZufangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZufangxinxiView> selectListView(Wrapper<ZufangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZufangxinxiView selectView(Wrapper<ZufangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
