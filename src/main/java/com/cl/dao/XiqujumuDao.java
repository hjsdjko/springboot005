package com.cl.dao;

import com.cl.entity.XiqujumuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiqujumuView;


/**
 * 戏曲剧目
 * 
 * @author 
 * @email 
 * @date 2024-04-12 10:59:58
 */
public interface XiqujumuDao extends BaseMapper<XiqujumuEntity> {
	
	List<XiqujumuView> selectListView(@Param("ew") Wrapper<XiqujumuEntity> wrapper);

	List<XiqujumuView> selectListView(Pagination page,@Param("ew") Wrapper<XiqujumuEntity> wrapper);
	
	XiqujumuView selectView(@Param("ew") Wrapper<XiqujumuEntity> wrapper);
	

}
