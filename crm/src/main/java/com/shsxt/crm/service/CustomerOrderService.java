package com.shsxt.crm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shsxt.base.BaseService;
import com.shsxt.crm.dao.CustomerOrderDao;
import com.shsxt.crm.vo.CustomerOrder;

@Service
public class CustomerOrderService extends BaseService<CustomerOrder> {
	
	@Resource
	private CustomerOrderDao customerOrderDao;

	
	public CustomerOrder queryOrderInfoById(Integer oid){
		return customerOrderDao.queryOrderInfoById(oid);
	}
}
