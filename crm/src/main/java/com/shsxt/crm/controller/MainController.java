package com.shsxt.crm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shsxt.base.BaseController;
import com.shsxt.crm.service.UserService;
import com.shsxt.crm.utils.LoginUserUtil;
import com.shsxt.crm.vo.User;
@Controller
public class MainController extends BaseController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("main")
	public String index(HttpServletRequest request){
		// 获取用户登录id
		int userId= LoginUserUtil.releaseUserIdFromCookie(request);
		User user= userService.queryById(userId);
		request.setAttribute("user", user);
		return "main";
	}
	
	

}
