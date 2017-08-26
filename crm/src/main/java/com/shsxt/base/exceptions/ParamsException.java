package com.shsxt.base.exceptions;

public class ParamsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5252844916620478699L;
	
	
	private String msg;//异常消息
	private Integer code=300;//异常状态码
	
	
	
	
	public ParamsException(String msg, Integer code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	
	
	public ParamsException(String msg) {
		super(msg);
		this.msg = msg;
	}


	public ParamsException() {
		super();
	}


	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	
	
	

}
