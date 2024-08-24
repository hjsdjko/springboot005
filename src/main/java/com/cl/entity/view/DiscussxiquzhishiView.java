package com.cl.entity.view;

import com.cl.entity.DiscussxiquzhishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 戏曲知识评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-12 10:59:59
 */
@TableName("discussxiquzhishi")
public class DiscussxiquzhishiView  extends DiscussxiquzhishiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussxiquzhishiView(){
	}
 
 	public DiscussxiquzhishiView(DiscussxiquzhishiEntity discussxiquzhishiEntity){
 	try {
			BeanUtils.copyProperties(this, discussxiquzhishiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
