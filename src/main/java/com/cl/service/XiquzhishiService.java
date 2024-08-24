package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XiquzhishiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiquzhishiView;


/**
 * 戏曲知识
 *
 * @author 
 * @email 
 * @date 2024-04-12 10:59:58
 */
public interface XiquzhishiService extends IService<XiquzhishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiquzhishiView> selectListView(Wrapper<XiquzhishiEntity> wrapper);
   	
   	XiquzhishiView selectView(@Param("ew") Wrapper<XiquzhishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiquzhishiEntity> wrapper);
   	

}

