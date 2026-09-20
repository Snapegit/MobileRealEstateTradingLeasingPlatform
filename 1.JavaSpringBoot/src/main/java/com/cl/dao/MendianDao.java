package com.cl.dao;

import com.cl.entity.MendianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MendianView;


/**
 * 门店
 * 
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
public interface MendianDao extends BaseMapper<MendianEntity> {
	
	List<MendianView> selectListView(@Param("ew") Wrapper<MendianEntity> wrapper);

	List<MendianView> selectListView(Pagination page,@Param("ew") Wrapper<MendianEntity> wrapper);
	
	MendianView selectView(@Param("ew") Wrapper<MendianEntity> wrapper);
	

}
