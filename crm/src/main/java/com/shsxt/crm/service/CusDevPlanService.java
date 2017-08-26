package com.shsxt.crm.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.shsxt.base.BaseService;
import com.shsxt.base.util.AssertUtil;
import com.shsxt.crm.constant.CrmConstant;
import com.shsxt.crm.vo.CusDevPlan;

@Service
public class CusDevPlanService extends BaseService<CusDevPlan> {
	
	
	public void saveOrUpdateCusDevPlan(CusDevPlan cusDevPlan){
		
		cusDevPlan.setUpdateDate(new Date());
		if(null==cusDevPlan.getId()){
			cusDevPlan.setCreateDate(new Date());
			cusDevPlan.setIsValid(1);
			AssertUtil.isTrue(insert(cusDevPlan)<1, CrmConstant.OPTION_FAILED_MSG);
		}else{
			AssertUtil.isTrue(null==queryById(cusDevPlan.getId()), "待更新的记录不存在!");
			AssertUtil.isTrue(update(cusDevPlan)<1, CrmConstant.OPTION_FAILED_MSG);
		}
	}
	
	public void deleteCusDevPlan(Integer id){
		AssertUtil.isTrue(delete(id)<1,CrmConstant.OPTION_FAILED_MSG);
	}
	
	

}
