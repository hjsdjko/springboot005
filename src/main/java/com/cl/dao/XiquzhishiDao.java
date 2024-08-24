package com.cl.dao;

import com.cl.entity.XiquzhishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiquzhishiView;


/**
 * 戏曲知识
 * 
 * @author 
 * @email 
 * @date 2024-04-12 10:59:58
 */
public interface XiquzhishiDao extends BaseMapper<XiquzhishiEntity> {
	
	List<XiquzhishiView> selectListView(@Param("ew") Wrapper<XiquzhishiEntity> wrapper);

	List<XiquzhishiView> selectListView(Pagination page,@Param("ew") Wrapper<XiquzhishiEntity> wrapper);
	
	XiquzhishiView selectView(@Param("ew") Wrapper<XiquzhishiEntity> wrapper);
	

}
