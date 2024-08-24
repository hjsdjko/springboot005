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

import com.cl.entity.XiqujumuEntity;
import com.cl.entity.view.XiqujumuView;

import com.cl.service.XiqujumuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 戏曲剧目
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-12 10:59:58
 */
@RestController
@RequestMapping("/xiqujumu")
public class XiqujumuController {
    @Autowired
    private XiqujumuService xiqujumuService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiqujumuEntity xiqujumu,
		HttpServletRequest request){
        EntityWrapper<XiqujumuEntity> ew = new EntityWrapper<XiqujumuEntity>();

		PageUtils page = xiqujumuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiqujumu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiqujumuEntity xiqujumu, 
		HttpServletRequest request){
        EntityWrapper<XiqujumuEntity> ew = new EntityWrapper<XiqujumuEntity>();

		PageUtils page = xiqujumuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiqujumu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiqujumuEntity xiqujumu){
       	EntityWrapper<XiqujumuEntity> ew = new EntityWrapper<XiqujumuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiqujumu, "xiqujumu")); 
        return R.ok().put("data", xiqujumuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiqujumuEntity xiqujumu){
        EntityWrapper< XiqujumuEntity> ew = new EntityWrapper< XiqujumuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiqujumu, "xiqujumu")); 
		XiqujumuView xiqujumuView =  xiqujumuService.selectView(ew);
		return R.ok("查询戏曲剧目成功").put("data", xiqujumuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiqujumuEntity xiqujumu = xiqujumuService.selectById(id);
		xiqujumu.setClicktime(new Date());
		xiqujumuService.updateById(xiqujumu);
		xiqujumu = xiqujumuService.selectView(new EntityWrapper<XiqujumuEntity>().eq("id", id));
        return R.ok().put("data", xiqujumu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiqujumuEntity xiqujumu = xiqujumuService.selectById(id);
		xiqujumu.setClicktime(new Date());
		xiqujumuService.updateById(xiqujumu);
		xiqujumu = xiqujumuService.selectView(new EntityWrapper<XiqujumuEntity>().eq("id", id));
        return R.ok().put("data", xiqujumu);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        XiqujumuEntity xiqujumu = xiqujumuService.selectById(id);
        if(type.equals("1")) {
        	xiqujumu.setThumbsupnum(xiqujumu.getThumbsupnum()+1);
        } else {
        	xiqujumu.setCrazilynum(xiqujumu.getCrazilynum()+1);
        }
        xiqujumuService.updateById(xiqujumu);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiqujumuEntity xiqujumu, HttpServletRequest request){
    	xiqujumu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiqujumu);
        xiqujumuService.insert(xiqujumu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiqujumuEntity xiqujumu, HttpServletRequest request){
    	xiqujumu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiqujumu);
        xiqujumuService.insert(xiqujumu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiqujumuEntity xiqujumu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiqujumu);
        xiqujumuService.updateById(xiqujumu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiqujumuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,XiqujumuEntity xiqujumu, HttpServletRequest request,String pre){
        EntityWrapper<XiqujumuEntity> ew = new EntityWrapper<XiqujumuEntity>();
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
		PageUtils page = xiqujumuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiqujumu), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 按收藏推荐
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,XiqujumuEntity xiqujumu, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "xiqumingcheng";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "xiqujumu").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<XiqujumuEntity> xiqujumuList = new ArrayList<XiqujumuEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                xiqujumuList.addAll(xiqujumuService.selectList(new EntityWrapper<XiqujumuEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<XiqujumuEntity> ew = new EntityWrapper<XiqujumuEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = xiqujumuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiqujumu), params), params));
        List<XiqujumuEntity> pageList = (List<XiqujumuEntity>)page.getList();
        if(xiqujumuList.size()<limit) {
            int toAddNum = (limit-xiqujumuList.size())<=pageList.size()?(limit-xiqujumuList.size()):pageList.size();
            for(XiqujumuEntity o1 : pageList) {
                boolean addFlag = true;
                for(XiqujumuEntity o2 : xiqujumuList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    xiqujumuList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(xiqujumuList.size()>limit) {
            xiqujumuList = xiqujumuList.subList(0, limit);
        }
        page.setList(xiqujumuList);
        return R.ok().put("data", page);
    }







}
