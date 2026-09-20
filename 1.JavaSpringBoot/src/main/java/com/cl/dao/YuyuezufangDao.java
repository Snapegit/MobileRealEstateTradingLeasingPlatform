package com.cl.dao;

import com.cl.entity.YuyuezufangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuyuezufangView;


/**
 * 预约租房
 * 
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
public interface YuyuezufangDao extends BaseMapper<YuyuezufangEntity> {
	
	List<YuyuezufangView> selectListView(@Param("ew") Wrapper<YuyuezufangEntity> wrapper);

	List<YuyuezufangView> selectListView(Pagination page,@Param("ew") Wrapper<YuyuezufangEntity> wrapper);
	
	YuyuezufangView selectView(@Param("ew") Wrapper<YuyuezufangEntity> wrapper);
	

}
