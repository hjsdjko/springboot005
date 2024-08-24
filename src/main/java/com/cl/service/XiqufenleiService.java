package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XiqufenleiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiqufenleiView;


/**
 * 戏曲分类
 *
 * @author 
 * @email 
 * @date 2024-04-12 10:59:58
 */
public interface XiqufenleiService extends IService<XiqufenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiqufenleiView> selectListView(Wrapper<XiqufenleiEntity> wrapper);
   	
   	XiqufenleiView selectView(@Param("ew") Wrapper<XiqufenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiqufenleiEntity> wrapper);
   	

}

