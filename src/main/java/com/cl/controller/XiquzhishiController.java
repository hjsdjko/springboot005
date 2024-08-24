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

import com.cl.entity.XiquzhishiEntity;
import com.cl.entity.view.XiquzhishiView;

import com.cl.service.XiquzhishiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 戏曲知识
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-12 10:59:58
 */
@RestController
@RequestMapping("/xiquzhishi")
public class XiquzhishiController {
    @Autowired
    private XiquzhishiService xiquzhishiService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiquzhishiEntity xiquzhishi,
		HttpServletRequest request){
        EntityWrapper<XiquzhishiEntity> ew = new EntityWrapper<XiquzhishiEntity>();

		PageUtils page = xiquzhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiquzhishi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiquzhishiEntity xiquzhishi, 
		HttpServletRequest request){
        EntityWrapper<XiquzhishiEntity> ew = new EntityWrapper<XiquzhishiEntity>();

		PageUtils page = xiquzhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiquzhishi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiquzhishiEntity xiquzhishi){
       	EntityWrapper<XiquzhishiEntity> ew = new EntityWrapper<XiquzhishiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiquzhishi, "xiquzhishi")); 
        return R.ok().put("data", xiquzhishiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiquzhishiEntity xiquzhishi){
        EntityWrapper< XiquzhishiEntity> ew = new EntityWrapper< XiquzhishiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiquzhishi, "xiquzhishi")); 
		XiquzhishiView xiquzhishiView =  xiquzhishiService.selectView(ew);
		return R.ok("查询戏曲知识成功").put("data", xiquzhishiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiquzhishiEntity xiquzhishi = xiquzhishiService.selectById(id);
		xiquzhishi.setClicktime(new Date());
		xiquzhishiService.updateById(xiquzhishi);
		xiquzhishi = xiquzhishiService.selectView(new EntityWrapper<XiquzhishiEntity>().eq("id", id));
        return R.ok().put("data", xiquzhishi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiquzhishiEntity xiquzhishi = xiquzhishiService.selectById(id);
		xiquzhishi.setClicktime(new Date());
		xiquzhishiService.updateById(xiquzhishi);
		xiquzhishi = xiquzhishiService.selectView(new EntityWrapper<XiquzhishiEntity>().eq("id", id));
        return R.ok().put("data", xiquzhishi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        XiquzhishiEntity xiquzhishi = xiquzhishiService.selectById(id);
        if(type.equals("1")) {
        	xiquzhishi.setThumbsupnum(xiquzhishi.getThumbsupnum()+1);
        } else {
        	xiquzhishi.setCrazilynum(xiquzhishi.getCrazilynum()+1);
        }
        xiquzhishiService.updateById(xiquzhishi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiquzhishiEntity xiquzhishi, HttpServletRequest request){
    	xiquzhishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiquzhishi);
        xiquzhishiService.insert(xiquzhishi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiquzhishiEntity xiquzhishi, HttpServletRequest request){
    	xiquzhishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiquzhishi);
        xiquzhishiService.insert(xiquzhishi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiquzhishiEntity xiquzhishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiquzhishi);
        xiquzhishiService.updateById(xiquzhishi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiquzhishiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,XiquzhishiEntity xiquzhishi, HttpServletRequest request,String pre){
        EntityWrapper<XiquzhishiEntity> ew = new EntityWrapper<XiquzhishiEntity>();
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
		PageUtils page = xiquzhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiquzhishi), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 按收藏推荐
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,XiquzhishiEntity xiquzhishi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "biaoti";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "xiquzhishi").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<XiquzhishiEntity> xiquzhishiList = new ArrayList<XiquzhishiEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                xiquzhishiList.addAll(xiquzhishiService.selectList(new EntityWrapper<XiquzhishiEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<XiquzhishiEntity> ew = new EntityWrapper<XiquzhishiEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = xiquzhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiquzhishi), params), params));
        List<XiquzhishiEntity> pageList = (List<XiquzhishiEntity>)page.getList();
        if(xiquzhishiList.size()<limit) {
            int toAddNum = (limit-xiquzhishiList.size())<=pageList.size()?(limit-xiquzhishiList.size()):pageList.size();
            for(XiquzhishiEntity o1 : pageList) {
                boolean addFlag = true;
                for(XiquzhishiEntity o2 : xiquzhishiList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    xiquzhishiList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(xiquzhishiList.size()>limit) {
            xiquzhishiList = xiquzhishiList.subList(0, limit);
        }
        page.setList(xiquzhishiList);
        return R.ok().put("data", page);
    }







}
