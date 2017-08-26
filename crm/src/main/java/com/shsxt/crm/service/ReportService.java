package com.shsxt.crm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.base.BaseService;
import com.shsxt.crm.dao.ReportDao;
import com.shsxt.crm.dto.CustomerDto;
import com.shsxt.crm.query.ReportQuery;

@Service
public class ReportService {
	
	@Resource
	private ReportDao reportDao;
	
	public Map<String, Object> queryCustomerGxData(ReportQuery reportQuery){
		Map<String, Object> map=new HashMap<String, Object>();
		PageHelper.startPage(reportQuery.getPageNum(),reportQuery.getPageSize());
		List<CustomerDto> list=reportDao.queryCustomerGxData(reportQuery);
		PageInfo<CustomerDto> pageInfo=new PageInfo<CustomerDto>(list);
		map.put("total", pageInfo.getTotal());
		map.put("rows",list);
		return map;
	}
	
	
	
	public List<CustomerDto> queryCustomerGc(){
		return reportDao.queryCustomerGc();
	}
	
	
	public List<CustomerDto> queryServeMakeUp(){
		return reportDao.queryServeMakeUp();
	}

} 
