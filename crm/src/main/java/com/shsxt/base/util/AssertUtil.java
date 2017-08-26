package com.shsxt.base.util;

import com.shsxt.base.exceptions.ParamsException;

public class AssertUtil {
	
	//int result=0  Result<1
	public static void isTrue(Boolean flag,String msg){
		if(flag){
			throw new ParamsException(msg);
		}
	}
	
	
	public static void isFalse(Boolean flag,String msg){
		if(!flag){
			throw new ParamsException(msg);
		}
	}
	
	
	
	public static void isNull(Object object,String msg){
		if(null==object){
			throw new ParamsException(msg);
		}
	}
	
	
	public static void isNotNull(Object object,String msg){
		if(null!=object){
			throw new ParamsException(msg);
		}
	}
	
	public static void isNotLogin(Boolean flag,String msg,Integer code) {
		if(flag){
			throw new ParamsException(msg, code);
		}
		
	}
	
	
	
	

}
