package com.cl.entity.view;

import com.cl.entity.DiscussxiquqingtingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 戏曲倾听评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-12 10:59:59
 */
@TableName("discussxiquqingting")
public class DiscussxiquqingtingView  extends DiscussxiquqingtingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussxiquqingtingView(){
	}
 
 	public DiscussxiquqingtingView(DiscussxiquqingtingEntity discussxiquqingtingEntity){
 	try {
			BeanUtils.copyProperties(this, discussxiquqingtingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
