package com.shsxt.crm.dao;

import java.util.List;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.vo.DataDic;

public interface DataDicDao extends BaseDao<DataDic>{
    List<DataDic> queryDataDicInfoByDicName(String dicName);
}