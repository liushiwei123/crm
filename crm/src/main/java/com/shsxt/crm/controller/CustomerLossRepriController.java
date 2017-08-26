package com.shsxt.crm.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.base.BaseController;
import com.shsxt.crm.model.MessageModel;
import com.shsxt.crm.query.CustomerLossRepriQuery;
import com.shsxt.crm.service.CustomerLossRepriService;
import com.shsxt.crm.vo.CustomerReprieve;

@Controller
@RequestMapping("customerLossRepri")
public class CustomerLossRepriController extends BaseController {
	
	@Resource
	private CustomerLossRepriService customerLossRepriService;
	
	@RequestMapping("queryCustomerLossRepriByLossId")
	@ResponseBody
	public Map<String, Object> queryCustomerLossRepriByLossId(CustomerLossRepriQuery customerLossRepriQuery,@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="10")Integer rows){
		customerLossRepriQuery.setPageNum(page);
		customerLossRepriQuery.setPageSize(rows);
		return customerLossRepriService.queryForPageMap(customerLossRepriQuery);
	}
	
	@RequestMapping("saveOrUpdateCustomerRepri")
	@ResponseBody
	public MessageModel saveOrUpdateCustomerRepri(CustomerReprieve customerReprieve){
		MessageModel messageModel=new MessageModel();
		customerLossRepriService.saveOrUpdateCustomerLossRepri(customerReprieve);
		return messageModel;
	}
	
	@RequestMapping("deleteCustomerRepri")
	@ResponseBody
	public MessageModel deleteCustomerRepri(Integer[] ids){
		MessageModel messageModel=new MessageModel();
		customerLossRepriService.deleteCustomerRepri(ids);
		return messageModel;
	}

}
