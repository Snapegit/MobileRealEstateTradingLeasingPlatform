package com.cl.entity.view;

import com.cl.entity.YuyuezufangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * 预约租房
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
@TableName("yuyuezufang")
public class YuyuezufangView  extends YuyuezufangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YuyuezufangView(){
	}
 
 	public YuyuezufangView(YuyuezufangEntity yuyuezufangEntity){
 	try {
			BeanUtils.copyProperties(this, yuyuezufangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}
