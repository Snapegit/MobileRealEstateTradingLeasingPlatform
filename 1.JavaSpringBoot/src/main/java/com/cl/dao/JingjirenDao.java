package com.cl.dao;

import com.cl.entity.JingjirenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JingjirenView;


/**
 * 经纪人
 * 
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
public interface JingjirenDao extends BaseMapper<JingjirenEntity> {
	
	List<JingjirenView> selectListView(@Param("ew") Wrapper<JingjirenEntity> wrapper);

	List<JingjirenView> selectListView(Pagination page,@Param("ew") Wrapper<JingjirenEntity> wrapper);
	
	JingjirenView selectView(@Param("ew") Wrapper<JingjirenEntity> wrapper);
	

}
