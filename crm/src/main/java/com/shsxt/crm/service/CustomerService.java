package com.shsxt.crm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shsxt.base.BaseService;
import com.shsxt.base.util.AssertUtil;
import com.shsxt.crm.constant.CrmConstant;
import com.shsxt.crm.dao.CustomerDao;
import com.shsxt.crm.dao.CustomerLossDao;
import com.shsxt.crm.dao.CustomerOrderDao;
import com.shsxt.crm.utils.MathUtil;
import com.shsxt.crm.vo.Customer;
import com.shsxt.crm.vo.CustomerLoss;
import com.shsxt.crm.vo.CustomerOrder;


@Service
@SuppressWarnings("all")
public class CustomerService extends BaseService<Customer> {
	
	@Resource
	private CustomerDao customerDao;
	
	
	
	@Resource
	private CustomerLossDao customerLossDao;
	
	@Resource
	private CustomerOrderDao customerOrderDao;
	
	public void saveOrUpdateCustomer(Customer customer){
		
		/**
		 * 非空参数校验
		 * state 0-未流失  1-流失
		 * is_valid  -- 与state 值  在添加指定
		 * createDate 在添加指定
		 * updateDate  添加与更新前设置
		 * khno---添加时生成客户编号
		 */
		customer.setUpdateDate(new Date());
		if(null==customer.getId()){
			// 添加
			customer.setState(0);
			customer.setIsValid(1);
			customer.setCreateDate(new Date());
			customer.setKhno(MathUtil.genereateKhCode());
			
			AssertUtil.isTrue(insert(customer)<1, CrmConstant.OPTION_FAILED_MSG);
		}else{
			// 更新
			AssertUtil.isTrue(null==queryById(customer.getId()), "待更新记录不存在!");
			AssertUtil.isTrue(update(customer)<1, CrmConstant.OPTION_FAILED_MSG);
		}
	}
	
	
	public void deleteCustomerBatch(Integer[] ids ){
		AssertUtil.isTrue(deleteBatch(ids)<1, CrmConstant.OPTION_FAILED_MSG);
	}
	
	
	
	
	public void updateCustomerLossData(){
		List<Customer> customers=customerDao.queryLossCustomer();
		List<CustomerLoss> customerLosses=null;
		Integer[] ids=null;
		// 数据转储操作
		// customerLoss 
		if(null!=customers&&customers.size()>0){
			customerLosses=new ArrayList<CustomerLoss>();
			ids=new Integer[customers.size()];
			for(int i=0;i<customers.size();i++){
				Customer customer= customers.get(i);
				CustomerLoss customerLoss=new CustomerLoss();
				customerLoss.setCreateDate(new Date());
				customerLoss.setCusManager(customer.getCusManager());
				customerLoss.setCusName(customer.getName());
				customerLoss.setCusNo(customer.getKhno());
				customerLoss.setIsValid(1);
				CustomerOrder customerOrder= customerOrderDao.queryLastOrderByCusId(customer.getId());
				if(null!=customerOrder){
					customerLoss.setLastOrderTime(customerOrder.getOrderDate());
				}
				customerLoss.setState(0);
				customerLoss.setUpdateDate(new Date());
				customerLosses.add(customerLoss);
				ids[i]=customer.getId();
			}
		}
		// 执行批量添加  List<CustomerLoss>
		// 批量更新customer  state integer[] ids
		if(null!=customerLosses&&customerLosses.size()>0){
			Map map=new HashMap<>();
			map.put("ids", ids);
			AssertUtil.isTrue(customerLossDao.insertBatch(customerLosses)<1||customerDao.updateBatch(map)<1, CrmConstant.OPTION_FAILED_MSG);
		}
	}
}
