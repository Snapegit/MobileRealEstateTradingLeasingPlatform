package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussfangyuanchushouEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussfangyuanchushouView;


/**
 * 房源出售评论表
 *
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
public interface DiscussfangyuanchushouService extends IService<DiscussfangyuanchushouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussfangyuanchushouView> selectListView(Wrapper<DiscussfangyuanchushouEntity> wrapper);
   	
   	DiscussfangyuanchushouView selectView(@Param("ew") Wrapper<DiscussfangyuanchushouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussfangyuanchushouEntity> wrapper);
   	

}

