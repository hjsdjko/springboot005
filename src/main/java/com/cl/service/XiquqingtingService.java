package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XiquqingtingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiquqingtingView;


/**
 * 戏曲倾听
 *
 * @author 
 * @email 
 * @date 2024-04-12 10:59:58
 */
public interface XiquqingtingService extends IService<XiquqingtingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiquqingtingView> selectListView(Wrapper<XiquqingtingEntity> wrapper);
   	
   	XiquqingtingView selectView(@Param("ew") Wrapper<XiquqingtingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiquqingtingEntity> wrapper);
   	

}

