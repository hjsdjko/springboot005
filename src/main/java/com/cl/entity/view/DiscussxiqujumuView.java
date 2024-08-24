package com.cl.entity.view;

import com.cl.entity.DiscussxiqujumuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 戏曲剧目评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-12 10:59:59
 */
@TableName("discussxiqujumu")
public class DiscussxiqujumuView  extends DiscussxiqujumuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussxiqujumuView(){
	}
 
 	public DiscussxiqujumuView(DiscussxiqujumuEntity discussxiqujumuEntity){
 	try {
			BeanUtils.copyProperties(this, discussxiqujumuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
