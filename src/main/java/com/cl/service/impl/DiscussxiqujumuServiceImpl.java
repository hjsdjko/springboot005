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


import com.cl.dao.DiscussxiqujumuDao;
import com.cl.entity.DiscussxiqujumuEntity;
import com.cl.service.DiscussxiqujumuService;
import com.cl.entity.view.DiscussxiqujumuView;

@Service("discussxiqujumuService")
public class DiscussxiqujumuServiceImpl extends ServiceImpl<DiscussxiqujumuDao, DiscussxiqujumuEntity> implements DiscussxiqujumuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxiqujumuEntity> page = this.selectPage(
                new Query<DiscussxiqujumuEntity>(params).getPage(),
                new EntityWrapper<DiscussxiqujumuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxiqujumuEntity> wrapper) {
		  Page<DiscussxiqujumuView> page =new Query<DiscussxiqujumuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussxiqujumuView> selectListView(Wrapper<DiscussxiqujumuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussxiqujumuView selectView(Wrapper<DiscussxiqujumuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
