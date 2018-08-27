package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 牛璐璐
 * 时        间：2017年12月6日 上午10:13:56
 * 功能描述：
 */
@Component
@ConfigurationProperties(prefix = "girl")
public class GirlPriperties {
	private String cupSize;
	private Integer age;
	public String getCupSize() {
		return cupSize;
	}
	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
