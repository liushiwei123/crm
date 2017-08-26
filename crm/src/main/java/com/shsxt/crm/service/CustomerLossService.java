package com.shsxt.crm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shsxt.base.BaseService;
import com.shsxt.base.util.AssertUtil;
import com.shsxt.crm.constant.CrmConstant;
import com.shsxt.crm.dao.CustomerLossDao;
import com.shsxt.crm.vo.CustomerLoss;

@Service
public class CustomerLossService extends BaseService<CustomerLoss> {
	
	@Resource
	private CustomerLossDao customerLossDao;
	
	public void updateCustomerLoss(String reason,Integer id){
		AssertUtil.isTrue(customerLossDao.updateCustomerLoss(reason, id)<1, CrmConstant.OPTION_FAILED_MSG);
	}
	

}
