package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YudingfangziEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YudingfangziView;


/**
 * 预定房子
 *
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
public interface YudingfangziService extends IService<YudingfangziEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YudingfangziView> selectListView(Wrapper<YudingfangziEntity> wrapper);
   	
   	YudingfangziView selectView(@Param("ew") Wrapper<YudingfangziEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YudingfangziEntity> wrapper);
   	

}

