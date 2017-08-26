package com.shsxt.crm.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.base.BaseController;
import com.shsxt.crm.query.CustomerOrderQuery;
import com.shsxt.crm.service.CustomerOrderService;
import com.shsxt.crm.vo.CustomerOrder;

@Controller
@RequestMapping("customerOrder")
public class CustomerOrderController extends BaseController {
	
	@Resource
	private CustomerOrderService customerOrderService;
	
	@RequestMapping("queryCustoemrOrderByCusId")
	@ResponseBody
	public Map<String, Object> queryCustoemrOrderByCusId(CustomerOrderQuery customerOrderQuery,@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="10")Integer rows){
		customerOrderQuery.setPageNum(page);
		customerOrderQuery.setPageSize(rows);
		return customerOrderService.queryForPageMap(customerOrderQuery);
	}
	
	@RequestMapping("queryOrderInfoById")
	@ResponseBody
	public CustomerOrder queryOrderInfoById(Integer oid){
		return customerOrderService.queryOrderInfoById(oid);
	}
	

}
