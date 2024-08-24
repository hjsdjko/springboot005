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


import com.cl.dao.XiqujumuDao;
import com.cl.entity.XiqujumuEntity;
import com.cl.service.XiqujumuService;
import com.cl.entity.view.XiqujumuView;

@Service("xiqujumuService")
public class XiqujumuServiceImpl extends ServiceImpl<XiqujumuDao, XiqujumuEntity> implements XiqujumuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiqujumuEntity> page = this.selectPage(
                new Query<XiqujumuEntity>(params).getPage(),
                new EntityWrapper<XiqujumuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiqujumuEntity> wrapper) {
		  Page<XiqujumuView> page =new Query<XiqujumuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XiqujumuView> selectListView(Wrapper<XiqujumuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiqujumuView selectView(Wrapper<XiqujumuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
