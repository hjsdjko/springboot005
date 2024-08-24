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


import com.cl.dao.DiscussxiquqingtingDao;
import com.cl.entity.DiscussxiquqingtingEntity;
import com.cl.service.DiscussxiquqingtingService;
import com.cl.entity.view.DiscussxiquqingtingView;

@Service("discussxiquqingtingService")
public class DiscussxiquqingtingServiceImpl extends ServiceImpl<DiscussxiquqingtingDao, DiscussxiquqingtingEntity> implements DiscussxiquqingtingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxiquqingtingEntity> page = this.selectPage(
                new Query<DiscussxiquqingtingEntity>(params).getPage(),
                new EntityWrapper<DiscussxiquqingtingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxiquqingtingEntity> wrapper) {
		  Page<DiscussxiquqingtingView> page =new Query<DiscussxiquqingtingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussxiquqingtingView> selectListView(Wrapper<DiscussxiquqingtingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussxiquqingtingView selectView(Wrapper<DiscussxiquqingtingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
