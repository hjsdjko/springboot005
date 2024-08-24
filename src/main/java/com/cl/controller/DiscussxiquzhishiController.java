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

import com.cl.entity.DiscussxiquzhishiEntity;
import com.cl.entity.view.DiscussxiquzhishiView;

import com.cl.service.DiscussxiquzhishiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 戏曲知识评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-12 10:59:59
 */
@RestController
@RequestMapping("/discussxiquzhishi")
public class DiscussxiquzhishiController {
    @Autowired
    private DiscussxiquzhishiService discussxiquzhishiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussxiquzhishiEntity discussxiquzhishi,
		HttpServletRequest request){
        EntityWrapper<DiscussxiquzhishiEntity> ew = new EntityWrapper<DiscussxiquzhishiEntity>();

		PageUtils page = discussxiquzhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxiquzhishi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussxiquzhishiEntity discussxiquzhishi, 
		HttpServletRequest request){
        EntityWrapper<DiscussxiquzhishiEntity> ew = new EntityWrapper<DiscussxiquzhishiEntity>();

		PageUtils page = discussxiquzhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxiquzhishi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussxiquzhishiEntity discussxiquzhishi){
       	EntityWrapper<DiscussxiquzhishiEntity> ew = new EntityWrapper<DiscussxiquzhishiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussxiquzhishi, "discussxiquzhishi")); 
        return R.ok().put("data", discussxiquzhishiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussxiquzhishiEntity discussxiquzhishi){
        EntityWrapper< DiscussxiquzhishiEntity> ew = new EntityWrapper< DiscussxiquzhishiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussxiquzhishi, "discussxiquzhishi")); 
		DiscussxiquzhishiView discussxiquzhishiView =  discussxiquzhishiService.selectView(ew);
		return R.ok("查询戏曲知识评论表成功").put("data", discussxiquzhishiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussxiquzhishiEntity discussxiquzhishi = discussxiquzhishiService.selectById(id);
		discussxiquzhishi = discussxiquzhishiService.selectView(new EntityWrapper<DiscussxiquzhishiEntity>().eq("id", id));
        return R.ok().put("data", discussxiquzhishi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussxiquzhishiEntity discussxiquzhishi = discussxiquzhishiService.selectById(id);
		discussxiquzhishi = discussxiquzhishiService.selectView(new EntityWrapper<DiscussxiquzhishiEntity>().eq("id", id));
        return R.ok().put("data", discussxiquzhishi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussxiquzhishiEntity discussxiquzhishi, HttpServletRequest request){
    	discussxiquzhishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussxiquzhishi);
        discussxiquzhishiService.insert(discussxiquzhishi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussxiquzhishiEntity discussxiquzhishi, HttpServletRequest request){
    	discussxiquzhishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussxiquzhishi);
        discussxiquzhishiService.insert(discussxiquzhishi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussxiquzhishiEntity discussxiquzhishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussxiquzhishi);
        discussxiquzhishiService.updateById(discussxiquzhishi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussxiquzhishiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussxiquzhishiEntity discussxiquzhishi, HttpServletRequest request,String pre){
        EntityWrapper<DiscussxiquzhishiEntity> ew = new EntityWrapper<DiscussxiquzhishiEntity>();
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
		PageUtils page = discussxiquzhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxiquzhishi), params), params));
        return R.ok().put("data", page);
    }








}
