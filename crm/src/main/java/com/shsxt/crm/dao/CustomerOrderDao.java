package com.shsxt.crm.dao;

import org.apache.ibatis.annotations.Param;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.vo.CustomerOrder;

public interface CustomerOrderDao extends BaseDao<CustomerOrder> {
	
	public CustomerOrder queryOrderInfoById(@Param("oid")Integer oid);
	
	
	// 查询客户最后一次下单记录
	CustomerOrder queryLastOrderByCusId(@Param("cusId") Integer cusId);
  
}