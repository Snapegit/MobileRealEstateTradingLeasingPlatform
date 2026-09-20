package com.cl.dao;

import com.cl.entity.FangyuanchushouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangyuanchushouView;


/**
 * 房源出售
 * 
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
public interface FangyuanchushouDao extends BaseMapper<FangyuanchushouEntity> {
	
	List<FangyuanchushouView> selectListView(@Param("ew") Wrapper<FangyuanchushouEntity> wrapper);

	List<FangyuanchushouView> selectListView(Pagination page,@Param("ew") Wrapper<FangyuanchushouEntity> wrapper);
	
	FangyuanchushouView selectView(@Param("ew") Wrapper<FangyuanchushouEntity> wrapper);
	

}
