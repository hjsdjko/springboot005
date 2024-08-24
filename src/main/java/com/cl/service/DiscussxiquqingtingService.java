package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussxiquqingtingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussxiquqingtingView;


/**
 * 戏曲倾听评论表
 *
 * @author 
 * @email 
 * @date 2024-04-12 10:59:59
 */
public interface DiscussxiquqingtingService extends IService<DiscussxiquqingtingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussxiquqingtingView> selectListView(Wrapper<DiscussxiquqingtingEntity> wrapper);
   	
   	DiscussxiquqingtingView selectView(@Param("ew") Wrapper<DiscussxiquqingtingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussxiquqingtingEntity> wrapper);
   	

}

