package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZufangxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZufangxinxiView;


/**
 * 租房信息
 *
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
public interface ZufangxinxiService extends IService<ZufangxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZufangxinxiView> selectListView(Wrapper<ZufangxinxiEntity> wrapper);
   	
   	ZufangxinxiView selectView(@Param("ew") Wrapper<ZufangxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZufangxinxiEntity> wrapper);
   	

}

