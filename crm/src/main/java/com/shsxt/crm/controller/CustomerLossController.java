package com.shsxt.crm.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.base.BaseController;
import com.shsxt.crm.model.MessageModel;
import com.shsxt.crm.query.CustomerLossQuery;
import com.shsxt.crm.service.CustomerLossService;
import com.shsxt.crm.vo.CustomerLoss;
@Controller
@RequestMapping("customerLoss")
public class CustomerLossController extends BaseController {
	
	@Resource
	private CustomerLossService customerLossService;
	@RequestMapping("index")
	public String index(){
		return "customer_loss";
	}
	
	
	@RequestMapping("queryCustomerLossByParams")
	@ResponseBody
	public Map<String, Object> queryCustomerLossByParams(CustomerLossQuery customerLossQuery,@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="10")Integer rows){
		customerLossQuery.setPageNum(page);
		customerLossQuery.setPageSize(rows);
		return customerLossService.queryForPageMap(customerLossQuery);
	}
	
	
	@RequestMapping("queryCustomerLossById")
	public String queryCustomerLossById(Integer id,Model model){
		CustomerLoss customerLoss= customerLossService.queryById(id);
		model.addAttribute("customerLoss", customerLoss);
		return "customer_loss_repri";
	}
	
	@RequestMapping("updateCustomerLoss")
	@ResponseBody
	public MessageModel updateCustomerLoss(String reason,Integer id){
		MessageModel messageModel=new MessageModel();
		customerLossService.updateCustomerLoss(reason, id);
		return messageModel;
	}

}
