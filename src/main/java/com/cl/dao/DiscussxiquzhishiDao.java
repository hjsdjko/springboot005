package com.cl.dao;

import com.cl.entity.DiscussxiquzhishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussxiquzhishiView;


/**
 * 戏曲知识评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-12 10:59:59
 */
public interface DiscussxiquzhishiDao extends BaseMapper<DiscussxiquzhishiEntity> {
	
	List<DiscussxiquzhishiView> selectListView(@Param("ew") Wrapper<DiscussxiquzhishiEntity> wrapper);

	List<DiscussxiquzhishiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussxiquzhishiEntity> wrapper);
	
	DiscussxiquzhishiView selectView(@Param("ew") Wrapper<DiscussxiquzhishiEntity> wrapper);
	

}
