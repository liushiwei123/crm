package com.shsxt.crm.dao;

import org.apache.ibatis.annotations.Param;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.vo.CustomerLoss;

public interface CustomerLossDao extends BaseDao<CustomerLoss> {
	
	int updateCustomerLoss(@Param("reason")String reason,@Param("id")Integer id);
   
}