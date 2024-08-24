package com.cl.dao;

import com.cl.entity.DiscussxiquqingtingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussxiquqingtingView;


/**
 * 戏曲倾听评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-12 10:59:59
 */
public interface DiscussxiquqingtingDao extends BaseMapper<DiscussxiquqingtingEntity> {
	
	List<DiscussxiquqingtingView> selectListView(@Param("ew") Wrapper<DiscussxiquqingtingEntity> wrapper);

	List<DiscussxiquqingtingView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussxiquqingtingEntity> wrapper);
	
	DiscussxiquqingtingView selectView(@Param("ew") Wrapper<DiscussxiquqingtingEntity> wrapper);
	

}
