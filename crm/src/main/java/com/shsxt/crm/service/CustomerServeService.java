package com.shsxt.crm.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.shsxt.base.BaseService;
import com.shsxt.base.util.AssertUtil;
import com.shsxt.crm.constant.CrmConstant;
import com.shsxt.crm.vo.CustomerServe;
@Service
public class CustomerServeService extends BaseService<CustomerServe> {
	
	public void saveOrUpdateCustomerServe(CustomerServe customerService){
		// state  已创建 已分配  已处理 已反馈  已归档
		customerService.setUpdateDate(new Date());
		if(null==customerService.getId()){
			customerService.setCreateDate(new Date());
			customerService.setIsValid(1);
			customerService.setState(CrmConstant.CUSTOMER_SERVE_CREATED);
			AssertUtil.isTrue(insert(customerService)<1, CrmConstant.OPTION_FAILED_MSG);
		}else{
			AssertUtil.isTrue(null==queryById(customerService.getId()), "待更新记录不存在!");
			// 分配
			if(customerService.getState().equals(CrmConstant.CUSTOMER_SERVE_ASSIGNED)){
				customerService.setAssignTime(new Date());
			}
			// 已处理
			if(customerService.getState().equals(CrmConstant.CUSTOMER_SERVE_PROCED)){
				customerService.setServiceProceTime(new Date());
			}
			// 已反馈
			if(customerService.getState().equals(CrmConstant.CUSTOMER_SERVE_FEED_BACK)){
				customerService.setState(CrmConstant.CUSTOMER_SERVE_GD);
			}
			AssertUtil.isTrue(update(customerService)<1, CrmConstant.OPTION_FAILED_MSG);
		}
		
	}

}
