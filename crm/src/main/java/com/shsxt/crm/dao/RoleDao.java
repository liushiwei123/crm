package com.shsxt.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.dto.TreeDto;
import com.shsxt.crm.vo.Role;

public interface RoleDao extends BaseDao<Role> {
	
	
	public List<Role> queryRoles();
    
	
	Role queryRoleByRoleName(@Param("roleName")String roleName);
	
	List<Integer> queryRoleHasMenuIds(@Param("rid")Integer rid);
	
	
	
}