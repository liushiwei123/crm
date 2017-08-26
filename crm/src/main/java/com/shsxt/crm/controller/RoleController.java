package com.shsxt.crm.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.base.BaseController;
import com.shsxt.crm.model.MessageModel;
import com.shsxt.crm.query.RoleQuery;
import com.shsxt.crm.service.RoleService;
import com.shsxt.crm.vo.Role;

@RequestMapping("role")
@Controller
public class RoleController extends BaseController {
	@Resource
	private RoleService roleService;
	
	@RequestMapping("queryRoles")
	@ResponseBody
	public List<Role> queryRoles(){
		return roleService.queryRoles();
	}
	
	@RequestMapping("index")
	public String index(){
		return "role";
	}
	
	
	@RequestMapping("queryRolesByParms")
	@ResponseBody
	public Map<String, Object> queryRolesByParms(RoleQuery roleQuery,@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="10")Integer rows){
		roleQuery.setPageNum(page);
		roleQuery.setPageSize(rows);
		return roleService.queryForPageMap(roleQuery);
	}

	
	@RequestMapping("queryRoleByRoleName")
	@ResponseBody
	public MessageModel queryRoleByRoleName(String roleName){
		MessageModel messageModel=new MessageModel();
		roleService.queryRoleByRoleName(roleName);
		return messageModel;
	}
	
	@RequestMapping("saveOrUpdateRole")
	@ResponseBody
	public MessageModel saveOrUpdateRole(Role role){
		MessageModel messageModel=new MessageModel();
		roleService.saveOrUpdateRole(role);
		return messageModel;
	}
	@RequestMapping("deleteRole")
	@ResponseBody
	public MessageModel deleteRole(Integer[] ids){
		MessageModel messageModel=new MessageModel();
		roleService.deleteRoleBatch(ids);
		return messageModel;
	}
	
	
	@RequestMapping("updateRoleHasGrant")
	@ResponseBody
	public MessageModel updateRoleHasGrant(Integer rid,Integer[] mIds){
		MessageModel messageModel=new MessageModel();
		roleService.updateRoleHasGrant(rid, mIds);
		return messageModel;
	}
}
