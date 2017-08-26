package com.shsxt.crm.dao;

import org.apache.ibatis.annotations.Param;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.vo.SaleChance;

public interface SaleChanceDao extends BaseDao<SaleChance> {

	int updateDevResult(@Param("sid")Integer sid, @Param("devResult")Integer devResult);
    
}