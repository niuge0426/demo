package com.example.demo.exception;

/**
 * @author 牛璐璐
 * 时        间：2017年12月29日 上午10:47:30
 * 功能描述：
 */
public class GirlException extends RuntimeException{
	private Integer code;
	
	public GirlException(Integer code,String message){
		super(message);
		this.code = code;
	}

}
