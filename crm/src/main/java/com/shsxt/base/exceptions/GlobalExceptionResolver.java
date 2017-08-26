package com.shsxt.base.exceptions;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.shsxt.crm.constant.CrmConstant;
import com.shsxt.crm.model.MessageModel;

/**
 * 全局异常同一处理
 * @author lp
 *
 */

public class GlobalExceptionResolver implements HandlerExceptionResolver {
	
	// 消息转换器  将对象转成json 输出
	private HttpMessageConverter<MessageModel> messageConverter;
	
	

	public void setMessageConverter(
			HttpMessageConverter<MessageModel> messageConverter) {
		this.messageConverter = messageConverter;
	}



	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		/**
		 * 响应类型：
		 *    视图
		 *    json
		 */
		ModelAndView mv=new ModelAndView();
		HandlerMethod handlerMethod=(HandlerMethod) handler;
		Method method= handlerMethod.getMethod();
		if(null==method){
			return null;
		}
		
		if(ex instanceof ParamsException){
			ParamsException paramsException=(ParamsException) ex;
			mv.addObject("errorMsg",paramsException.getMsg());
			mv.addObject("errorCode", paramsException.getCode());
			mv.addObject("ctx", request.getContextPath());
			mv.addObject("uri", request.getRequestURI());
			mv.setViewName("error");
			// 未登录状态识别标识
			if(paramsException.getCode()==CrmConstant.OPTION_NOT_LOGIN_CODE){
				return mv;
			}
			ResponseBody responseBody=AnnotationUtils.getAnnotation(method, ResponseBody.class);
			if(null!=responseBody){
				try {
					MessageModel messageModel=new MessageModel();
					messageModel.setResultCode(paramsException.getCode());
					messageModel.setMsg(paramsException.getMsg());
					HttpOutputMessage  outputMessage=new ServletServerHttpResponse(response);
					messageConverter.write(messageModel, MediaType.APPLICATION_JSON_UTF8, outputMessage);
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}else{
				return mv;
			}
		}
		
		
		
		
		// 获取ResponseBody 注解
		/*ResponseBody responseBody=AnnotationUtils.getAnnotation(method, ResponseBody.class);
		if(null==responseBody){
			if(ex instanceof ParamsException){
				ParamsException paramsException=(ParamsException) ex;
				mv.addObject("errorMsg",paramsException.getMsg());
				mv.addObject("errorCode", paramsException.getCode());
				mv.addObject("ctx", request.getContextPath());
				mv.addObject("uri", request.getRequestURI());
				mv.setViewName("error");
				return mv;
			}
		}else{
			// 响应类型为json
			MessageModel messageModel=new MessageModel();
			try {
				if(ex instanceof ParamsException){
					ParamsException paramsException=(ParamsException) ex;
					if(paramsException.getCode()==CrmConstant.OPTION_NOT_LOGIN_CODE){
						mv.addObject("errorMsg",paramsException.getMsg());
						mv.addObject("errorCode", paramsException.getCode());
						mv.addObject("ctx", request.getContextPath());
						mv.addObject("uri", request.getRequestURI());
						mv.setViewName("error");
						return mv;
					}
					
					messageModel.setResultCode(paramsException.getCode());
					messageModel.setMsg(paramsException.getMsg());
					HttpOutputMessage  outputMessage=new ServletServerHttpResponse(response);
					messageConverter.write(messageModel, MediaType.APPLICATION_JSON_UTF8, outputMessage);
				}
				return null;
			} catch (Exception e) {
				
			}
		}*/
		
		return null;
	}

}
