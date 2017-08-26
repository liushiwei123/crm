package com.shsxt.crm.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.base.BaseController;
import com.shsxt.crm.model.MessageModel;
import com.shsxt.crm.query.SaleChanceQuery;
import com.shsxt.crm.service.SaleChanceService;
import com.shsxt.crm.service.UserService;
import com.shsxt.crm.utils.LoginUserUtil;
import com.shsxt.crm.vo.SaleChance;
import com.shsxt.crm.vo.User;
@Controller
@RequestMapping("saleChance")
public class SaleChanceController extends BaseController {
	@Resource
	private SaleChanceService saleChanceService;
	@Resource
	private UserService userService;
	@RequestMapping("index")
	public String index(){
		return "sale_chance";
	}
	
	@RequestMapping("querySaleChanceByParams")
	@ResponseBody
	public Map<String, Object> querySaleChanceByParams(SaleChanceQuery saleChanceQuery,@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="10")Integer rows){
		saleChanceQuery.setPageNum(page);
		saleChanceQuery.setPageSize(rows);
		return saleChanceService.queryForPageMap(saleChanceQuery);
	}
	
	@RequestMapping("saveOrUpdateSaleChance")
	@ResponseBody
	public MessageModel saveOrUpdateSaleChance(HttpServletRequest request,SaleChance saleChance){
		MessageModel messageModel=new MessageModel();
		Integer userId=LoginUserUtil.releaseUserIdFromCookie(request);
		User user=userService.queryById(userId);
		saleChance.setCreateMan(user.getTrueName());
		saleChanceService.saveOrUpdateSaleChance(saleChance);
		return messageModel;
	}
	
	@RequestMapping("deleteSaleChanceBatch")
	@ResponseBody
	public MessageModel deleteSaleChanceBatch(Integer[] ids){
		MessageModel messageModel=new MessageModel();
		saleChanceService.deleteSaleChanceBatch(ids);
		return messageModel;
	}
	
	@RequestMapping("querySaleChanceById")
	public String  querySaleChanceById(Integer sid,Model model){
		SaleChance  saleChance=saleChanceService.queryById(sid);
		model.addAttribute("saleChance", saleChance);
		return "cus_dev_plan_detail";
	}
	
	@RequestMapping("updateDevResult")
	@ResponseBody
	public MessageModel updateDevResult(Integer sid,Integer devResult){
		MessageModel messageModel=new MessageModel();
		saleChanceService.updateDevResult(sid,devResult);
		
		return messageModel;
		
	}
	
}
