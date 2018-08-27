package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.GirlPriperties;

/**
 * @author 牛璐璐
 * 时        间：2017年12月6日 上午11:33:12
 * 功能描述：
 */
@RestController
public class HelloController {
	
	@Autowired
	private GirlPriperties girlPriperties;
	
//	@RequestMapping(value = "/say", method = RequestMethod.GET)
	@GetMapping(value = "/say")
	public String say(@RequestParam(value = "id", required = false,defaultValue = "0") Integer id){
		return "id: " + id;
//		return girlPriperties.getCupSize();
	}
}
