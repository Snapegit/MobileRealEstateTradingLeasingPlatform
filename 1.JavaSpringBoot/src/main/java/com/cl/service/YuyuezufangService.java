package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YuyuezufangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuyuezufangView;


/**
 * 预约租房
 *
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
public interface YuyuezufangService extends IService<YuyuezufangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuyuezufangView> selectListView(Wrapper<YuyuezufangEntity> wrapper);
   	
   	YuyuezufangView selectView(@Param("ew") Wrapper<YuyuezufangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuyuezufangEntity> wrapper);
   	

}

