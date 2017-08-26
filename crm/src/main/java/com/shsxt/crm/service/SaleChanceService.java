package com.shsxt.crm.service;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.shsxt.base.BaseService;
import com.shsxt.base.util.AssertUtil;
import com.shsxt.crm.constant.CrmConstant;
import com.shsxt.crm.dao.SaleChanceDao;
import com.shsxt.crm.vo.SaleChance;

@Service
public class SaleChanceService extends BaseService<SaleChance> {
	
	
	@Resource
	private SaleChanceDao saleChanceDao;
	
	
	
	public void saveOrUpdateSaleChance(SaleChance saleChance){
		/**
		 * 参数非空校验
		 *  isValid 1
		 *  updateDate date
		 *  
		 *  分配人存在
		 *     state 1 已分配
		 *  分配人不存在
		 *     state  0  未分配
		 *  
		 *  
		 *  
		 *  id  null
		 *     添加  createDate  insert  
		 *      dev_result 0 未开发
		 *  id  not null
		 *       update  
		 */
		
		saleChance.setUpdateDate(new Date());
		
		if(StringUtils.isNoneBlank(saleChance.getAssignMan())){
			saleChance.setAssignTime(new Date());
			saleChance.setState(1);
		}else{
			saleChance.setState(0);
		}
		if(null==saleChance.getId()){
			saleChance.setCreateDate(new Date());
			saleChance.setIsValid(1);
			saleChance.setDevResult(0);
			AssertUtil.isTrue(insert(saleChance)<1, CrmConstant.OPTION_FAILED_MSG);
		}else{
			AssertUtil.isTrue(null==queryById(saleChance.getId()), "待更新的记录不存在!");
			AssertUtil.isTrue(update(saleChance)<1, "更新失败！");
		}
	}
	
	
	public void deleteSaleChanceBatch(Integer[] ids){
		AssertUtil.isTrue(deleteBatch(ids)<1, CrmConstant.OPTION_FAILED_MSG); 
	}


	public void updateDevResult(Integer sid, Integer devResult) {
		
		saleChanceDao.updateDevResult(sid,devResult);
		
	}
	

}
