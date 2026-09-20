package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussfangyuanchuzuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussfangyuanchuzuView;


/**
 * 房源出租评论表
 *
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
public interface DiscussfangyuanchuzuService extends IService<DiscussfangyuanchuzuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussfangyuanchuzuView> selectListView(Wrapper<DiscussfangyuanchuzuEntity> wrapper);
   	
   	DiscussfangyuanchuzuView selectView(@Param("ew") Wrapper<DiscussfangyuanchuzuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussfangyuanchuzuEntity> wrapper);
   	

}

