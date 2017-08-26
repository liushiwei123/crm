package com.shsxt.crm.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.base.BaseController;
import com.shsxt.crm.dto.CustomerDto;
import com.shsxt.crm.query.ReportQuery;
import com.shsxt.crm.service.ReportService;

@Controller
@RequestMapping("report")
public class ReportController extends BaseController {
	@Resource
	private ReportService reportService;

	@RequestMapping("toReportPage")
	public String toReportPage(Integer flag){
		switch (flag) {
		case 1:
			return "customer_gx";
		case 2:
			return "customer_gc";
		case 3:
			return "customer_fw";
		case 4:
			return "customer_ls";
		default:
			return "error";
		}
	}

	@RequestMapping("queryCustomerGxData")
	@ResponseBody
	public Map<String, Object> queryCustomerGxData(ReportQuery reportQuery,@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="10")Integer rows){
		reportQuery.setPageNum(page);
		reportQuery.setPageSize(rows);
		return reportService.queryCustomerGxData(reportQuery);
	}
	
	@RequestMapping("queryCustomerGc")
	@ResponseBody
	public List<CustomerDto> queryCustomerGc(){
		return reportService.queryCustomerGc();
	}
	
	@RequestMapping("queryServeMakeUp")
	@ResponseBody
	public List<CustomerDto> queryServeMakeUp(){
		return reportService.queryServeMakeUp();
	}
	
	


}
