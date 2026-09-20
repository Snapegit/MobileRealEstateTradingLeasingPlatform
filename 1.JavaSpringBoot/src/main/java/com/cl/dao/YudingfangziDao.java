package com.cl.dao;

import com.cl.entity.YudingfangziEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YudingfangziView;


/**
 * 预定房子
 * 
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
public interface YudingfangziDao extends BaseMapper<YudingfangziEntity> {
	
	List<YudingfangziView> selectListView(@Param("ew") Wrapper<YudingfangziEntity> wrapper);

	List<YudingfangziView> selectListView(Pagination page,@Param("ew") Wrapper<YudingfangziEntity> wrapper);
	
	YudingfangziView selectView(@Param("ew") Wrapper<YudingfangziEntity> wrapper);
	

}
