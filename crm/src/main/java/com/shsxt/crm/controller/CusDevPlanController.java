package com.shsxt.crm.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.base.BaseController;
import com.shsxt.crm.model.MessageModel;
import com.shsxt.crm.query.CusDevPlanQuery;
import com.shsxt.crm.service.CusDevPlanService;
import com.shsxt.crm.vo.CusDevPlan;

@Controller
@RequestMapping("cusDevPlan")
public class CusDevPlanController extends BaseController {
	
	@Resource
	private CusDevPlanService cusDevPlanService;
	@RequestMapping("index")
	public String index(){
		return "cus_dev_plan";
	}
	
	
	@RequestMapping("queryCusDevPlanBySid")
	@ResponseBody
	public Map<String, Object> queryCusDevPlanBySid(CusDevPlanQuery cusDevPlanQuery,@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="10")Integer rows){
		cusDevPlanQuery.setPageNum(page);
		cusDevPlanQuery.setPageSize(rows);
		return cusDevPlanService.queryForPageMap(cusDevPlanQuery);
	}
	
	@RequestMapping("saveOrUpdateCusDevPlan")
	@ResponseBody
	public MessageModel saveOrUpdateCusDevPlan(CusDevPlan cusDevPlan){
		MessageModel messageModel=new MessageModel();
		cusDevPlanService.saveOrUpdateCusDevPlan(cusDevPlan);
		return messageModel;
		
	}
	@RequestMapping("deleteCusDevPlan")
	@ResponseBody
	public MessageModel deleteCusDevPlan(Integer id){
		MessageModel messageModel=new MessageModel();
		cusDevPlanService.delete(id);
		return messageModel;
	}

}
