package com.shsxt.crm.dao;

import java.util.List;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.vo.Customer;

public interface CustomerDao extends BaseDao<Customer> {
	
	List<Customer> queryLossCustomer();
    
}