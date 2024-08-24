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


import com.cl.dao.DiscussxiquzhishiDao;
import com.cl.entity.DiscussxiquzhishiEntity;
import com.cl.service.DiscussxiquzhishiService;
import com.cl.entity.view.DiscussxiquzhishiView;

@Service("discussxiquzhishiService")
public class DiscussxiquzhishiServiceImpl extends ServiceImpl<DiscussxiquzhishiDao, DiscussxiquzhishiEntity> implements DiscussxiquzhishiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxiquzhishiEntity> page = this.selectPage(
                new Query<DiscussxiquzhishiEntity>(params).getPage(),
                new EntityWrapper<DiscussxiquzhishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxiquzhishiEntity> wrapper) {
		  Page<DiscussxiquzhishiView> page =new Query<DiscussxiquzhishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussxiquzhishiView> selectListView(Wrapper<DiscussxiquzhishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussxiquzhishiView selectView(Wrapper<DiscussxiquzhishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
