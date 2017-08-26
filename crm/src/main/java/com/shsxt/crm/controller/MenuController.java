
package com.shsxt.crm.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.swing.MenuSelectionManager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.base.BaseController;
import com.shsxt.crm.dto.TreeDto;
import com.shsxt.crm.model.MessageModel;
import com.shsxt.crm.query.MenuQuery;
import com.shsxt.crm.service.MenuService;
import com.shsxt.crm.vo.Menu;

@Controller
@RequestMapping("menu")
public class MenuController extends BaseController {
	
	
	@Resource
	private MenuService menuService;
	
	@RequestMapping("index")
	public String toMenuPage(Integer flag,Integer mid,Model model){
		switch (flag) {
		case 1:
			return "par_menu";
		case 2:
			model.addAttribute("mid", mid);
			return "sub_menu";
		default:
			return "error";
		}
	}
	
	
	
	
	@RequestMapping("queryMenuByParams")
	@ResponseBody
	public Map<String, Object> queryMenuByParams(MenuQuery menuQuery,@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="10") Integer rows){
		menuQuery.setPageNum(page);
		menuQuery.setPageSize(rows);
		return menuService.queryForPageMap(menuQuery);
	}
	
	
	@RequestMapping("saveOrUpdateMenu")
	@ResponseBody
	public MessageModel saveOrUpdateMenu(Menu menu){
		MessageModel messageModel=new MessageModel();
		menuService.saveOrUpdateMenu(menu);
		return messageModel;
	}
	
	
	
	@RequestMapping("queryMenuByMenuNameAndPid")
	@ResponseBody
	public MessageModel queryMenuByMenuNameAndPid(String menuName,Integer pid){
		MessageModel messageModel=new MessageModel();
		menuService.queryMenuByMenuNameAndPid(menuName,pid);
		return messageModel;
	}
	@RequestMapping("deleteMenu")
	@ResponseBody
	public MessageModel deleteMenu(Integer[] ids){
		MessageModel messageModel=new MessageModel();
		menuService.deleteMenuBatch(ids[0]);
		return messageModel;
	}
	
	@RequestMapping("queryAllMenus")
	@ResponseBody
	public List<TreeDto> queryAllMenus(){
		return menuService.queryAllMenus();
	}
	
	
	@RequestMapping("queryAllMenus02")
	@ResponseBody
	public List<TreeDto> queryAllMenus02(Integer rid){
		return menuService.queryAllMenus02(rid);
	}
	
	@RequestMapping("queryRoleHasMenus")
	@ResponseBody
	public List<TreeDto> queryRoleHasMenus(Integer rid){
		return menuService.queryRoleHasMenus(rid);
	}


}
