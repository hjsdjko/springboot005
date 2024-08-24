package com.cl.dao;

import com.cl.entity.XiquqingtingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiquqingtingView;


/**
 * 戏曲倾听
 * 
 * @author 
 * @email 
 * @date 2024-04-12 10:59:58
 */
public interface XiquqingtingDao extends BaseMapper<XiquqingtingEntity> {
	
	List<XiquqingtingView> selectListView(@Param("ew") Wrapper<XiquqingtingEntity> wrapper);

	List<XiquqingtingView> selectListView(Pagination page,@Param("ew") Wrapper<XiquqingtingEntity> wrapper);
	
	XiquqingtingView selectView(@Param("ew") Wrapper<XiquqingtingEntity> wrapper);
	

}
