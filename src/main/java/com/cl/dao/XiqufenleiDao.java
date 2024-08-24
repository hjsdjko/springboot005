package com.cl.dao;

import com.cl.entity.XiqufenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiqufenleiView;


/**
 * 戏曲分类
 * 
 * @author 
 * @email 
 * @date 2024-04-12 10:59:58
 */
public interface XiqufenleiDao extends BaseMapper<XiqufenleiEntity> {
	
	List<XiqufenleiView> selectListView(@Param("ew") Wrapper<XiqufenleiEntity> wrapper);

	List<XiqufenleiView> selectListView(Pagination page,@Param("ew") Wrapper<XiqufenleiEntity> wrapper);
	
	XiqufenleiView selectView(@Param("ew") Wrapper<XiqufenleiEntity> wrapper);
	

}
