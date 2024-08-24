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


import com.cl.dao.XiquqingtingDao;
import com.cl.entity.XiquqingtingEntity;
import com.cl.service.XiquqingtingService;
import com.cl.entity.view.XiquqingtingView;

@Service("xiquqingtingService")
public class XiquqingtingServiceImpl extends ServiceImpl<XiquqingtingDao, XiquqingtingEntity> implements XiquqingtingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiquqingtingEntity> page = this.selectPage(
                new Query<XiquqingtingEntity>(params).getPage(),
                new EntityWrapper<XiquqingtingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiquqingtingEntity> wrapper) {
		  Page<XiquqingtingView> page =new Query<XiquqingtingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XiquqingtingView> selectListView(Wrapper<XiquqingtingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiquqingtingView selectView(Wrapper<XiquqingtingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
