package com.shsxt.crm.interceptors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.shsxt.base.util.AssertUtil;
import com.shsxt.crm.constant.CrmConstant;
import com.shsxt.crm.service.UserService;
import com.shsxt.crm.utils.LoginUserUtil;
import com.shsxt.crm.vo.User;

public class LoginInterceptor implements HandlerInterceptor {
	
	@Resource
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		/**
		 * cookie  userIdStr
		 *       获取用户id 
		 *       用户记录存在 已登陆
		 *       不存在  未登录 抛异常 未登录
		 *       
		 */
		Integer userId= LoginUserUtil.releaseUserIdFromCookie(request);
		//AssertUtil.isTrue(null==userId||0==userId, CrmConstant.OPTION_LOGIN_FIRST);
		AssertUtil.isNotLogin(null==userId||0==userId, CrmConstant.OPTION_LOGIN_FIRST, CrmConstant.OPTION_NOT_LOGIN_CODE);
		User user=userService.queryById(userId);
		//AssertUtil.isTrue(null==user, CrmConstant.OPTION_LOGIN_FIRST);
		AssertUtil.isNotLogin(null==user, CrmConstant.OPTION_LOGIN_FIRST, CrmConstant.OPTION_NOT_LOGIN_CODE);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
