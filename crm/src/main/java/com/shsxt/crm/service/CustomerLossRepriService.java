package com.shsxt.crm.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.shsxt.base.BaseService;
import com.shsxt.base.util.AssertUtil;
import com.shsxt.crm.constant.CrmConstant;
import com.shsxt.crm.vo.CustomerReprieve;

@Service
public class CustomerLossRepriService extends BaseService<CustomerReprieve> {
	
	
	public void saveOrUpdateCustomerLossRepri(CustomerReprieve customerReprieve){
		
		customerReprieve.setUpdateDate(new Date());
		
		if(null==customerReprieve.getId()){
			customerReprieve.setCreateDate(new Date());
			AssertUtil.isTrue(insert(customerReprieve)<1, CrmConstant.OPTION_FAILED_MSG);
		}else {
			AssertUtil.isTrue(null==queryById(customerReprieve.getId()), "待更新记录不存在！");
			AssertUtil.isTrue(update(customerReprieve)<1,CrmConstant.OPTION_FAILED_MSG);
		}
		
	}
	
	public void deleteCustomerRepri(Integer[] ids){
		AssertUtil.isTrue(deleteBatch(ids)<1, CrmConstant.OPTION_FAILED_MSG);
	}
	

}
