package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.XiqufenleiDao;
import com.cl.entity.XiqufenleiEntity;
import com.cl.service.XiqufenleiService;
import com.cl.entity.view.XiqufenleiView;

@Service("xiqufenleiService")
public class XiqufenleiServiceImpl extends ServiceImpl<XiqufenleiDao, XiqufenleiEntity> implements XiqufenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiqufenleiEntity> page = this.selectPage(
                new Query<XiqufenleiEntity>(params).getPage(),
                new EntityWrapper<XiqufenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiqufenleiEntity> wrapper) {
		  Page<XiqufenleiView> page =new Query<XiqufenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XiqufenleiView> selectListView(Wrapper<XiqufenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiqufenleiView selectView(Wrapper<XiqufenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
