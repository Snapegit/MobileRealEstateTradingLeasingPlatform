package com.cl.dao;

import com.cl.entity.FangyuanchuzuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangyuanchuzuView;


/**
 * 房源出租
 * 
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
public interface FangyuanchuzuDao extends BaseMapper<FangyuanchuzuEntity> {
	
	List<FangyuanchuzuView> selectListView(@Param("ew") Wrapper<FangyuanchuzuEntity> wrapper);

	List<FangyuanchuzuView> selectListView(Pagination page,@Param("ew") Wrapper<FangyuanchuzuEntity> wrapper);
	
	FangyuanchuzuView selectView(@Param("ew") Wrapper<FangyuanchuzuEntity> wrapper);
	

}
