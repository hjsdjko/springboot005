package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 戏曲剧目
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-12 10:59:58
 */
@TableName("xiqujumu")
public class XiqujumuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XiqujumuEntity() {
		
	}
	
	public XiqujumuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 戏曲名称
	 */
					
	private String xiqumingcheng;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 戏曲分类
	 */
					
	private String xiqufenlei;
	
	/**
	 * 艺术家
	 */
					
	private String yishujia;
	
	/**
	 * 戏曲介绍
	 */
					
	private String xiqujieshao;
	
	/**
	 * 视频
	 */
					
	private String shipin;
	
	/**
	 * 收藏数量
	 */
					
	private Integer storeupnum;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	/**
	 * 赞
	 */
					
	private Integer thumbsupnum;
	
	/**
	 * 踩
	 */
					
	private Integer crazilynum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：戏曲名称
	 */
	public void setXiqumingcheng(String xiqumingcheng) {
		this.xiqumingcheng = xiqumingcheng;
	}
	/**
	 * 获取：戏曲名称
	 */
	public String getXiqumingcheng() {
		return xiqumingcheng;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：戏曲分类
	 */
	public void setXiqufenlei(String xiqufenlei) {
		this.xiqufenlei = xiqufenlei;
	}
	/**
	 * 获取：戏曲分类
	 */
	public String getXiqufenlei() {
		return xiqufenlei;
	}
	/**
	 * 设置：艺术家
	 */
	public void setYishujia(String yishujia) {
		this.yishujia = yishujia;
	}
	/**
	 * 获取：艺术家
	 */
	public String getYishujia() {
		return yishujia;
	}
	/**
	 * 设置：戏曲介绍
	 */
	public void setXiqujieshao(String xiqujieshao) {
		this.xiqujieshao = xiqujieshao;
	}
	/**
	 * 获取：戏曲介绍
	 */
	public String getXiqujieshao() {
		return xiqujieshao;
	}
	/**
	 * 设置：视频
	 */
	public void setShipin(String shipin) {
		this.shipin = shipin;
	}
	/**
	 * 获取：视频
	 */
	public String getShipin() {
		return shipin;
	}
	/**
	 * 设置：收藏数量
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数量
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
	/**
	 * 设置：赞
	 */
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
	/**
	 * 设置：踩
	 */
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}

}
