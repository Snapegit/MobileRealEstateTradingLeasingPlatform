package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FangyuanchuzuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangyuanchuzuView;


/**
 * 房源出租
 *
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
public interface FangyuanchuzuService extends IService<FangyuanchuzuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangyuanchuzuView> selectListView(Wrapper<FangyuanchuzuEntity> wrapper);
   	
   	FangyuanchuzuView selectView(@Param("ew") Wrapper<FangyuanchuzuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangyuanchuzuEntity> wrapper);
   	

}

