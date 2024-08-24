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


import com.cl.dao.XiquzhishiDao;
import com.cl.entity.XiquzhishiEntity;
import com.cl.service.XiquzhishiService;
import com.cl.entity.view.XiquzhishiView;

@Service("xiquzhishiService")
public class XiquzhishiServiceImpl extends ServiceImpl<XiquzhishiDao, XiquzhishiEntity> implements XiquzhishiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiquzhishiEntity> page = this.selectPage(
                new Query<XiquzhishiEntity>(params).getPage(),
                new EntityWrapper<XiquzhishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiquzhishiEntity> wrapper) {
		  Page<XiquzhishiView> page =new Query<XiquzhishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XiquzhishiView> selectListView(Wrapper<XiquzhishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiquzhishiView selectView(Wrapper<XiquzhishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
