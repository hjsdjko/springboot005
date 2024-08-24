package com.cl.entity.view;

import com.cl.entity.XiqufenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 戏曲分类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-12 10:59:58
 */
@TableName("xiqufenlei")
public class XiqufenleiView  extends XiqufenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XiqufenleiView(){
	}
 
 	public XiqufenleiView(XiqufenleiEntity xiqufenleiEntity){
 	try {
			BeanUtils.copyProperties(this, xiqufenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
