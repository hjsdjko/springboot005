package com.cl.dao;

import com.cl.entity.DiscussxiqujumuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussxiqujumuView;


/**
 * 戏曲剧目评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-12 10:59:59
 */
public interface DiscussxiqujumuDao extends BaseMapper<DiscussxiqujumuEntity> {
	
	List<DiscussxiqujumuView> selectListView(@Param("ew") Wrapper<DiscussxiqujumuEntity> wrapper);

	List<DiscussxiqujumuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussxiqujumuEntity> wrapper);
	
	DiscussxiqujumuView selectView(@Param("ew") Wrapper<DiscussxiqujumuEntity> wrapper);
	

}
