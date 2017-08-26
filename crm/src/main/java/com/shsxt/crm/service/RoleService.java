package com.shsxt.crm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.shsxt.base.BaseService;
import com.shsxt.base.util.AssertUtil;
import com.shsxt.crm.constant.CrmConstant;
import com.shsxt.crm.dao.RoleDao;
import com.shsxt.crm.dao.RoleMenuDao;
import com.shsxt.crm.dto.TreeDto;
import com.shsxt.crm.vo.Role;
import com.shsxt.crm.vo.RoleMenu;

@Service
public class RoleService extends BaseService<Role> {
	@Resource
	private RoleDao roleDao;
	
	
	@Resource
	private RoleMenuDao roleMenuDao;
	
	public List<Role> queryRoles(){
		  return roleDao.queryRoles();
	}
	
	
	
	public void saveOrUpdateRole(Role role){
		role.setUpdateDate(new Date());
		if(null==role.getId()){
			role.setIsValid(1);
			role.setCreateDate(new Date());
			AssertUtil.isTrue(insert(role)<1,CrmConstant.OPTION_FAILED_MSG);
		}else {
			AssertUtil.isTrue(update(role)<1, CrmConstant.OPTION_FAILED_MSG);
		};
	}
	
	public void queryRoleByRoleName(String roleName){
		AssertUtil.isTrue(StringUtils.isBlank(roleName),"角色名称不能为空!");
		AssertUtil.isTrue(null!=roleDao.queryRoleByRoleName(roleName), "角色已存在!");
	}
	
	public void deleteRoleBatch(Integer[] ids){
		AssertUtil.isTrue(deleteBatch(ids)<1, CrmConstant.OPTION_FAILED_MSG);
	}
	
	
	
	public void updateRoleHasGrant(Integer rid,Integer[] mIds){
		AssertUtil.isTrue(null==rid||0==rid||null==queryById(rid), "角色记录不存在!");
		AssertUtil.isTrue(null==mIds||mIds.length==0, "请选择菜单!");
		//mIds={0,1,3,5,6,7,8,9}
		// 执行删除操作
		
		if(roleMenuDao.queryRoleMenusByRid(rid)>=1){
			AssertUtil.isTrue(roleMenuDao.deleteByRid(rid)<1, CrmConstant.OPTION_FAILED_MSG);
		}
		// 重新添加菜单权限记录
		List<RoleMenu> roleMenus=new ArrayList<RoleMenu>();
		for(Integer i=0;i<mIds.length;i++){
			RoleMenu roleMenu=new RoleMenu();
			roleMenu.setRoleId(rid);
			roleMenu.setMenuId(mIds[i]);
			roleMenus.add(roleMenu);
		}
		AssertUtil.isTrue(roleMenuDao.insertBatch(roleMenus)<1, CrmConstant.OPTION_FAILED_MSG);
		
	}
	
	
	
	
	
	

}
