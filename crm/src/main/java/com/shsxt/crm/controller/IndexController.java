package com.shsxt.crm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shsxt.base.BaseController;

@Controller
public class IndexController extends BaseController{
	/*@RequestMapping("index")
	public String index(HttpServletRequest request,Model model){
		model.addAttribute("ctx", request.getContextPath());
		return "index";
	}*/
	
	@RequestMapping("index")
	public String index(){
		return "index";
	}
	

}
