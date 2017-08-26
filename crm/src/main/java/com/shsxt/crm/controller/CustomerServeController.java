package com.shsxt.crm.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.base.BaseController;
import com.shsxt.crm.model.MessageModel;
import com.shsxt.crm.query.CustomerServeQuery;
import com.shsxt.crm.service.CustomerServeService;
import com.shsxt.crm.vo.CustomerServe;

@Controller
@RequestMapping("customerServe")
public class CustomerServeController extends BaseController {
	@Resource
	private CustomerServeService customerServeService;
	
	@RequestMapping("index")
    public String toCustomerServePage(Integer state){
		switch (state) {
		case 1:
			return "customer_serve_create";
		case 2:
			return "customer_serve_assign";	
		case 3:
			return "customer_serve_proce";	
		case 4:
			return "customer_serve_fb";	
		case 5:
			return "customer_serve_gd";	
		default:
			return "error";
		}
    }	
	
	
	
	@RequestMapping("saveOrUpdateCustomerServe")
	@ResponseBody
	public MessageModel saveOrUpdateCustomerServe(CustomerServe customerServe){
		MessageModel messageModel=new MessageModel();
		customerServeService.saveOrUpdateCustomerServe(customerServe);
		return messageModel;
	}
	
	
	@RequestMapping("queryCustomerServeByState")
	@ResponseBody
	public Map<String,Object> queryCustomerServeByState(CustomerServeQuery customerServeQuery,@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="10")Integer rows){
		customerServeQuery.setPageNum(page);
		customerServeQuery.setPageSize(rows);
		return customerServeService.queryForPageMap(customerServeQuery);
	}
	
 
}
