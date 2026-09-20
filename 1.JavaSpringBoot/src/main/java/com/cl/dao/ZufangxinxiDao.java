package com.cl.dao;

import com.cl.entity.ZufangxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZufangxinxiView;


/**
 * 租房信息
 * 
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
public interface ZufangxinxiDao extends BaseMapper<ZufangxinxiEntity> {
	
	List<ZufangxinxiView> selectListView(@Param("ew") Wrapper<ZufangxinxiEntity> wrapper);

	List<ZufangxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ZufangxinxiEntity> wrapper);
	
	ZufangxinxiView selectView(@Param("ew") Wrapper<ZufangxinxiEntity> wrapper);
	

}
