package com.shsxt.crm.dao;

import org.apache.ibatis.annotations.Param;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.vo.RoleMenu;

public interface RoleMenuDao extends BaseDao<RoleMenu> {
   
	
	Integer deleteByRid(@Param("rid")Integer rid);
	
	Integer queryRoleMenusByRid(@Param("rid") Integer rid);
}