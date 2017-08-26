package com.shsxt.crm.task;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.shsxt.crm.service.CustomerService;

@Component
public class CustomerLossJob {
	
	@Resource
	private CustomerService customerService;
	
	//@Scheduled(cron="0/5 * * * *  ?")
	public void executeLossData(){
		System.err.println("流失数据定时任务处理。。。");
		customerService.updateCustomerLossData();
	}

}
