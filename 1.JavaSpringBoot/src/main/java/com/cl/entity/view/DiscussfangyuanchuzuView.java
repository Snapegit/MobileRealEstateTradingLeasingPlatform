package com.cl.entity.view;

import com.cl.entity.DiscussfangyuanchuzuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
 

/**
 * 房源出租评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-01-04 18:34:58
 */
@TableName("discussfangyuanchuzu")
public class DiscussfangyuanchuzuView  extends DiscussfangyuanchuzuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussfangyuanchuzuView(){
	}
 
 	public DiscussfangyuanchuzuView(DiscussfangyuanchuzuEntity discussfangyuanchuzuEntity){
 	try {
			BeanUtils.copyProperties(this, discussfangyuanchuzuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

}
