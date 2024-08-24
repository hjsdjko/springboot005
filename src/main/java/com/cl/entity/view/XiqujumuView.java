package com.cl.entity.view;

import com.cl.entity.XiqujumuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 戏曲剧目
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-12 10:59:58
 */
@TableName("xiqujumu")
public class XiqujumuView  extends XiqujumuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XiqujumuView(){
	}
 
 	public XiqujumuView(XiqujumuEntity xiqujumuEntity){
 	try {
			BeanUtils.copyProperties(this, xiqujumuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
