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

import com.cl.entity.XiqufenleiEntity;
import com.cl.entity.view.XiqufenleiView;

import com.cl.service.XiqufenleiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 戏曲分类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-12 10:59:58
 */
@RestController
@RequestMapping("/xiqufenlei")
public class XiqufenleiController {
    @Autowired
    private XiqufenleiService xiqufenleiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiqufenleiEntity xiqufenlei,
		HttpServletRequest request){
        EntityWrapper<XiqufenleiEntity> ew = new EntityWrapper<XiqufenleiEntity>();

		PageUtils page = xiqufenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiqufenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiqufenleiEntity xiqufenlei, 
		HttpServletRequest request){
        EntityWrapper<XiqufenleiEntity> ew = new EntityWrapper<XiqufenleiEntity>();

		PageUtils page = xiqufenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiqufenlei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiqufenleiEntity xiqufenlei){
       	EntityWrapper<XiqufenleiEntity> ew = new EntityWrapper<XiqufenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiqufenlei, "xiqufenlei")); 
        return R.ok().put("data", xiqufenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiqufenleiEntity xiqufenlei){
        EntityWrapper< XiqufenleiEntity> ew = new EntityWrapper< XiqufenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiqufenlei, "xiqufenlei")); 
		XiqufenleiView xiqufenleiView =  xiqufenleiService.selectView(ew);
		return R.ok("查询戏曲分类成功").put("data", xiqufenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiqufenleiEntity xiqufenlei = xiqufenleiService.selectById(id);
		xiqufenlei = xiqufenleiService.selectView(new EntityWrapper<XiqufenleiEntity>().eq("id", id));
        return R.ok().put("data", xiqufenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiqufenleiEntity xiqufenlei = xiqufenleiService.selectById(id);
		xiqufenlei = xiqufenleiService.selectView(new EntityWrapper<XiqufenleiEntity>().eq("id", id));
        return R.ok().put("data", xiqufenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiqufenleiEntity xiqufenlei, HttpServletRequest request){
    	xiqufenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiqufenlei);
        xiqufenleiService.insert(xiqufenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiqufenleiEntity xiqufenlei, HttpServletRequest request){
    	xiqufenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiqufenlei);
        xiqufenleiService.insert(xiqufenlei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiqufenleiEntity xiqufenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiqufenlei);
        xiqufenleiService.updateById(xiqufenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiqufenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
