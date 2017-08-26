package com.shsxt.crm.dao;

import java.util.List;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.dto.CustomerDto;
import com.shsxt.crm.query.CustomerQuery;
import com.shsxt.crm.query.ReportQuery;

public interface ReportDao  {
	List<CustomerDto> queryCustomerGxData(ReportQuery reportQuery);
	
	
	List<CustomerDto> queryCustomerGc();

	
	List<CustomerDto> queryServeMakeUp();
}
