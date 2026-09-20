package com.cl.entity.view;

import com.cl.entity.JingjirenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * 经纪人
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
@TableName("jingjiren")
public class JingjirenView  extends JingjirenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JingjirenView(){
	}
 
 	public JingjirenView(JingjirenEntity jingjirenEntity){
 	try {
			BeanUtils.copyProperties(this, jingjirenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}
