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

import com.cl.entity.XiquqingtingEntity;
import com.cl.entity.view.XiquqingtingView;

import com.cl.service.XiquqingtingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 戏曲倾听
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-12 10:59:58
 */
@RestController
@RequestMapping("/xiquqingting")
public class XiquqingtingController {
    @Autowired
    private XiquqingtingService xiquqingtingService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiquqingtingEntity xiquqingting,
		HttpServletRequest request){
        EntityWrapper<XiquqingtingEntity> ew = new EntityWrapper<XiquqingtingEntity>();

		PageUtils page = xiquqingtingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiquqingting), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiquqingtingEntity xiquqingting, 
		HttpServletRequest request){
        EntityWrapper<XiquqingtingEntity> ew = new EntityWrapper<XiquqingtingEntity>();

		PageUtils page = xiquqingtingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiquqingting), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiquqingtingEntity xiquqingting){
       	EntityWrapper<XiquqingtingEntity> ew = new EntityWrapper<XiquqingtingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiquqingting, "xiquqingting")); 
        return R.ok().put("data", xiquqingtingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiquqingtingEntity xiquqingting){
        EntityWrapper< XiquqingtingEntity> ew = new EntityWrapper< XiquqingtingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiquqingting, "xiquqingting")); 
		XiquqingtingView xiquqingtingView =  xiquqingtingService.selectView(ew);
		return R.ok("查询戏曲倾听成功").put("data", xiquqingtingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiquqingtingEntity xiquqingting = xiquqingtingService.selectById(id);
		xiquqingting.setClicktime(new Date());
		xiquqingtingService.updateById(xiquqingting);
		xiquqingting = xiquqingtingService.selectView(new EntityWrapper<XiquqingtingEntity>().eq("id", id));
        return R.ok().put("data", xiquqingting);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiquqingtingEntity xiquqingting = xiquqingtingService.selectById(id);
		xiquqingting.setClicktime(new Date());
		xiquqingtingService.updateById(xiquqingting);
		xiquqingting = xiquqingtingService.selectView(new EntityWrapper<XiquqingtingEntity>().eq("id", id));
        return R.ok().put("data", xiquqingting);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        XiquqingtingEntity xiquqingting = xiquqingtingService.selectById(id);
        if(type.equals("1")) {
        	xiquqingting.setThumbsupnum(xiquqingting.getThumbsupnum()+1);
        } else {
        	xiquqingting.setCrazilynum(xiquqingting.getCrazilynum()+1);
        }
        xiquqingtingService.updateById(xiquqingting);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiquqingtingEntity xiquqingting, HttpServletRequest request){
    	xiquqingting.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiquqingting);
        xiquqingtingService.insert(xiquqingting);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiquqingtingEntity xiquqingting, HttpServletRequest request){
    	xiquqingting.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiquqingting);
        xiquqingtingService.insert(xiquqingting);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiquqingtingEntity xiquqingting, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiquqingting);
        xiquqingtingService.updateById(xiquqingting);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiquqingtingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,XiquqingtingEntity xiquqingting, HttpServletRequest request,String pre){
        EntityWrapper<XiquqingtingEntity> ew = new EntityWrapper<XiquqingtingEntity>();
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
		PageUtils page = xiquqingtingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiquqingting), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 按收藏推荐
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,XiquqingtingEntity xiquqingting, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "songname";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "xiquqingting").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<XiquqingtingEntity> xiquqingtingList = new ArrayList<XiquqingtingEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                xiquqingtingList.addAll(xiquqingtingService.selectList(new EntityWrapper<XiquqingtingEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<XiquqingtingEntity> ew = new EntityWrapper<XiquqingtingEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = xiquqingtingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiquqingting), params), params));
        List<XiquqingtingEntity> pageList = (List<XiquqingtingEntity>)page.getList();
        if(xiquqingtingList.size()<limit) {
            int toAddNum = (limit-xiquqingtingList.size())<=pageList.size()?(limit-xiquqingtingList.size()):pageList.size();
            for(XiquqingtingEntity o1 : pageList) {
                boolean addFlag = true;
                for(XiquqingtingEntity o2 : xiquqingtingList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    xiquqingtingList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(xiquqingtingList.size()>limit) {
            xiquqingtingList = xiquqingtingList.subList(0, limit);
        }
        page.setList(xiquqingtingList);
        return R.ok().put("data", page);
    }







}
