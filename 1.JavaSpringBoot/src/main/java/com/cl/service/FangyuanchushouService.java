package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FangyuanchushouEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangyuanchushouView;


/**
 * 房源出售
 *
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
public interface FangyuanchushouService extends IService<FangyuanchushouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangyuanchushouView> selectListView(Wrapper<FangyuanchushouEntity> wrapper);
   	
   	FangyuanchushouView selectView(@Param("ew") Wrapper<FangyuanchushouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangyuanchushouEntity> wrapper);
   	

}

