package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.DiscussxiqujumuEntity;
import com.cl.entity.view.DiscussxiqujumuView;

import com.cl.service.DiscussxiqujumuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 戏曲剧目评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-12 10:59:59
 */
@RestController
@RequestMapping("/discussxiqujumu")
public class DiscussxiqujumuController {
    @Autowired
    private DiscussxiqujumuService discussxiqujumuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussxiqujumuEntity discussxiqujumu,
		HttpServletRequest request){
        EntityWrapper<DiscussxiqujumuEntity> ew = new EntityWrapper<DiscussxiqujumuEntity>();

		PageUtils page = discussxiqujumuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxiqujumu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussxiqujumuEntity discussxiqujumu, 
		HttpServletRequest request){
        EntityWrapper<DiscussxiqujumuEntity> ew = new EntityWrapper<DiscussxiqujumuEntity>();

		PageUtils page = discussxiqujumuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxiqujumu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussxiqujumuEntity discussxiqujumu){
       	EntityWrapper<DiscussxiqujumuEntity> ew = new EntityWrapper<DiscussxiqujumuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussxiqujumu, "discussxiqujumu")); 
        return R.ok().put("data", discussxiqujumuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussxiqujumuEntity discussxiqujumu){
        EntityWrapper< DiscussxiqujumuEntity> ew = new EntityWrapper< DiscussxiqujumuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussxiqujumu, "discussxiqujumu")); 
		DiscussxiqujumuView discussxiqujumuView =  discussxiqujumuService.selectView(ew);
		return R.ok("查询戏曲剧目评论表成功").put("data", discussxiqujumuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussxiqujumuEntity discussxiqujumu = discussxiqujumuService.selectById(id);
		discussxiqujumu = discussxiqujumuService.selectView(new EntityWrapper<DiscussxiqujumuEntity>().eq("id", id));
        return R.ok().put("data", discussxiqujumu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussxiqujumuEntity discussxiqujumu = discussxiqujumuService.selectById(id);
		discussxiqujumu = discussxiqujumuService.selectView(new EntityWrapper<DiscussxiqujumuEntity>().eq("id", id));
        return R.ok().put("data", discussxiqujumu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussxiqujumuEntity discussxiqujumu, HttpServletRequest request){
    	discussxiqujumu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussxiqujumu);
        discussxiqujumuService.insert(discussxiqujumu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussxiqujumuEntity discussxiqujumu, HttpServletRequest request){
    	discussxiqujumu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussxiqujumu);
        discussxiqujumuService.insert(discussxiqujumu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussxiqujumuEntity discussxiqujumu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussxiqujumu);
        discussxiqujumuService.updateById(discussxiqujumu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussxiqujumuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussxiqujumuEntity discussxiqujumu, HttpServletRequest request,String pre){
        EntityWrapper<DiscussxiqujumuEntity> ew = new EntityWrapper<DiscussxiqujumuEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussxiqujumuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxiqujumu), params), params));
        return R.ok().put("data", page);
    }








}
