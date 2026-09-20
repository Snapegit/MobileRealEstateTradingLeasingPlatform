package com.cl.dao;

import com.cl.entity.DiscussfangyuanchuzuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussfangyuanchuzuView;


/**
 * 房源出租评论表
 * 
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
public interface DiscussfangyuanchuzuDao extends BaseMapper<DiscussfangyuanchuzuEntity> {
	
	List<DiscussfangyuanchuzuView> selectListView(@Param("ew") Wrapper<DiscussfangyuanchuzuEntity> wrapper);

	List<DiscussfangyuanchuzuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussfangyuanchuzuEntity> wrapper);
	
	DiscussfangyuanchuzuView selectView(@Param("ew") Wrapper<DiscussfangyuanchuzuEntity> wrapper);
	

}
