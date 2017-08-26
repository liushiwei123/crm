package com.shsxt.crm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shsxt.base.BaseService;
import com.shsxt.crm.dao.DataDicDao;
import com.shsxt.crm.vo.DataDic;

@Service
public class DataDicService extends BaseService<DataDic> {
	@Resource
	private DataDicDao dataDicDao;
	
	public List<DataDic> queryDataDicInfoByDicName(String dicName){
		return dataDicDao.queryDataDicInfoByDicName(dicName);
	}

}
