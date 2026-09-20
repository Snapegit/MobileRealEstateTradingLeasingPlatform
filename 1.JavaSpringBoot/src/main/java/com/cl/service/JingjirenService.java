package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JingjirenEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JingjirenView;


/**
 * 经纪人
 *
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
public interface JingjirenService extends IService<JingjirenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JingjirenView> selectListView(Wrapper<JingjirenEntity> wrapper);
   	
   	JingjirenView selectView(@Param("ew") Wrapper<JingjirenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JingjirenEntity> wrapper);
   	

}

