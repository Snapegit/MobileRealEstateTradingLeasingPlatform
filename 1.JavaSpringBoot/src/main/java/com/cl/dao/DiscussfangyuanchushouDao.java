package com.cl.dao;

import com.cl.entity.DiscussfangyuanchushouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussfangyuanchushouView;


/**
 * 房源出售评论表
 * 
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
public interface DiscussfangyuanchushouDao extends BaseMapper<DiscussfangyuanchushouEntity> {
	
	List<DiscussfangyuanchushouView> selectListView(@Param("ew") Wrapper<DiscussfangyuanchushouEntity> wrapper);

	List<DiscussfangyuanchushouView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussfangyuanchushouEntity> wrapper);
	
	DiscussfangyuanchushouView selectView(@Param("ew") Wrapper<DiscussfangyuanchushouEntity> wrapper);
	

}
