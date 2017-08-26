package com.shsxt.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.vo.User;

public interface UserDao extends BaseDao<User> {
	
	
	public User queryUserByUserNameAndRoleId(@Param("userName")String userName,@Param("roleId")Integer roleId);

	public List<User> queryCustomerManager();
   
	
	public User queryUserByUserName(@Param("userName")String userName);
}