package com.shsxt.crm.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.base.BaseController;
import com.shsxt.crm.query.OrderDetailsQuery;
import com.shsxt.crm.service.OrderDetailsService;

@Controller
@RequestMapping("orderDetails")
public class OrderDetailsController extends BaseController {
	
	@Resource
	private OrderDetailsService orderDetailsService;
	
	@RequestMapping("queryOrderDetailsByOid")
	@ResponseBody
	public Map<String, Object> queryOrderDetailsByOid(OrderDetailsQuery orderDetailsQuery,@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="10")Integer rows){
		orderDetailsQuery.setPageNum(page);
		orderDetailsQuery.setPageSize(rows);
		return orderDetailsService.queryForPageMap(orderDetailsQuery);
	}

}
