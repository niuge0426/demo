package com.example.demo.entity;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author 牛璐璐
 * 时        间：2017年12月29日 上午9:51:08
 * 功能描述：http请求返回的最外层对象
 */
public class Result<T> {
	/**错误码*/
	private Integer code;
	/**提示信息*/
	private String msg;
	/**具体的内容*/
	private T data;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
