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
 * 戏曲倾听
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-12 10:59:58
 */
@TableName("xiquqingting")
public class XiquqingtingEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XiquqingtingEntity() {
		
	}
	
	public XiquqingtingEntity(T t) {
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
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 戏曲名称
	 */
					
	private String songname;
	
	/**
	 * 戏曲文件
	 */
					
	private String songfile;
	
	/**
	 * 艺术家
	 */
					
	private String singer;
	
	/**
	 * 戏曲介绍
	 */
					
	private String xiqujieshao;
	
	/**
	 * 上传时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date shangchuanshijian;
	
	/**
	 * 赞
	 */
					
	private Integer thumbsupnum;
	
	/**
	 * 踩
	 */
					
	private Integer crazilynum;
	
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
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：戏曲名称
	 */
	public void setSongname(String songname) {
		this.songname = songname;
	}
	/**
	 * 获取：戏曲名称
	 */
	public String getSongname() {
		return songname;
	}
	/**
	 * 设置：戏曲文件
	 */
	public void setSongfile(String songfile) {
		this.songfile = songfile;
	}
	/**
	 * 获取：戏曲文件
	 */
	public String getSongfile() {
		return songfile;
	}
	/**
	 * 设置：艺术家
	 */
	public void setSinger(String singer) {
		this.singer = singer;
	}
	/**
	 * 获取：艺术家
	 */
	public String getSinger() {
		return singer;
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
	 * 设置：上传时间
	 */
	public void setShangchuanshijian(Date shangchuanshijian) {
		this.shangchuanshijian = shangchuanshijian;
	}
	/**
	 * 获取：上传时间
	 */
	public Date getShangchuanshijian() {
		return shangchuanshijian;
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

}
