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
import com.shsxt.crm.query.CustomerQuery;
import com.shsxt.crm.service.CustomerService;
import com.shsxt.crm.vo.Customer;

@Controller
@RequestMapping("customer")
public class CustomerController extends BaseController {
	
	@Resource
	private CustomerService customerService;
	
	
	@RequestMapping("index")
	public String index(){
		return "customer";
	}
	
	
	@RequestMapping("toOtherInfoPage")
	public String toOtherInfoPage(String state,Integer cid,Model model){
		Customer customer=customerService.queryById(cid);
		model.addAttribute("customer", customer);
		switch (state) {
		case "1":
			return "customer_linkman";
		case "2":
			return "customer_history";
		case "3":
			return "customer_order";
		default:
			return  "error";
		}
	}
	
	
	
	@RequestMapping("queryCustomerInfoByParams")
	@ResponseBody
	public Map<String, Object> queryCustomerInfoByParams(CustomerQuery customerQuery,@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="10")Integer rows){
		customerQuery.setPageNum(page);
		customerQuery.setPageSize(rows);
		return customerService.queryForPageMap(customerQuery);
	}
	
	@RequestMapping("saveOrUpdateCustomer")
	@ResponseBody
	public MessageModel saveOrUpdateCustomer(Customer customer){
		MessageModel messageModel=new MessageModel();
		customerService.saveOrUpdateCustomer(customer);
		return messageModel;
	}
	
	@RequestMapping("deleteCustomerBatch")
	@ResponseBody
	public MessageModel deleteCustomerBatch(Integer[] ids){
		MessageModel messageModel=new MessageModel();
		customerService.deleteCustomerBatch(ids);
		return messageModel;
	}
	
	
}
