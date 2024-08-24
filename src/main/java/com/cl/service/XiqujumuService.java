package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XiqujumuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiqujumuView;


/**
 * 戏曲剧目
 *
 * @author 
 * @email 
 * @date 2024-04-12 10:59:58
 */
public interface XiqujumuService extends IService<XiqujumuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiqujumuView> selectListView(Wrapper<XiqujumuEntity> wrapper);
   	
   	XiqujumuView selectView(@Param("ew") Wrapper<XiqujumuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiqujumuEntity> wrapper);
   	

}

