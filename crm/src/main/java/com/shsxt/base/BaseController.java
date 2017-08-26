package com.shsxt.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;


public class BaseController {
	
	// 
	@ModelAttribute
	public void preMethod(HttpServletRequest request,Model model){
		model.addAttribute("ctx", request.getContextPath());
	}
	
	

}
