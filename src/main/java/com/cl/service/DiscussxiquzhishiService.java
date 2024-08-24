package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussxiquzhishiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussxiquzhishiView;


/**
 * 戏曲知识评论表
 *
 * @author 
 * @email 
 * @date 2024-04-12 10:59:59
 */
public interface DiscussxiquzhishiService extends IService<DiscussxiquzhishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussxiquzhishiView> selectListView(Wrapper<DiscussxiquzhishiEntity> wrapper);
   	
   	DiscussxiquzhishiView selectView(@Param("ew") Wrapper<DiscussxiquzhishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussxiquzhishiEntity> wrapper);
   	

}

