package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussxiqujumuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussxiqujumuView;


/**
 * 戏曲剧目评论表
 *
 * @author 
 * @email 
 * @date 2024-04-12 10:59:59
 */
public interface DiscussxiqujumuService extends IService<DiscussxiqujumuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussxiqujumuView> selectListView(Wrapper<DiscussxiqujumuEntity> wrapper);
   	
   	DiscussxiqujumuView selectView(@Param("ew") Wrapper<DiscussxiqujumuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussxiqujumuEntity> wrapper);
   	

}

