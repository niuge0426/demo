package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.GirlRepository;
import com.example.demo.entity.Girl;
import com.example.demo.entity.Result;
import com.example.demo.service.GirlService;
import com.example.demo.utils.ResultUtil;

/**
 * @author 牛璐璐
 * 时        间：2017年12月6日 下午4:32:57
 * 功能描述：
 */
@RestController
public class GirlController {
	
	@Autowired
	private GirlRepository girlRepository;
	
	@Autowired
	private GirlService girlService;
	
	/**
	 * @author 牛璐璐
	 * 时        间：2017年12月6日 下午4:48:44
	 * 功能描述：查询所有女生列表
	 */
	@GetMapping(value = "/girls")
	public List<Girl> girlList(){
		return girlRepository.findAll();
	}
	
	/**
	 * @author 牛璐璐
	 * 时        间：2017年12月6日 下午4:55:18
	 * 功能描述：添加一个女生
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/addGirl")
	public Result<Girl> addGirl(@Valid Girl girl,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
		girl.setCupSize(girl.getCupSize());
		girl.setAge(girl.getAge());
		return ResultUtil.success(girlRepository.save(girl));
	}
	
	/**
	 * @author 牛璐璐
	 * 时        间：2017年12月6日 下午5:32:20
	 * 功能描述：通过ID查询一个女生
	 */
	@GetMapping(value = "/girlById/{id}")
	public Girl girlById(@PathVariable("id") Integer id){
		return girlRepository.findOne(id);
	}
	
	/**
	 * @author 牛璐璐
	 * 时        间：2017年12月6日 下午5:38:06
	 * 功能描述：通过ID更新一个女生
	 */
	@PutMapping(value = "/upGirl/{id}")
	public Girl upGirl(@PathVariable("id") Integer id,
					   @RequestParam("cupSize") String cupSize,
					   @RequestParam("age") Integer age){
		Girl girl = new Girl();
		girl.setId(id);
		girl.setCupSize(cupSize);
		girl.setAge(age);
		return girlRepository.save(girl);
		
	}
	
	/**
	 * @author 牛璐璐
	 * 时        间：2017年12月6日 下午5:34:19
	 * 功能描述：删除一个女生
	 */
	@DeleteMapping(value = "/deGirl/{id}")
	public void deGirl(@PathVariable("id") Integer id){
		girlRepository.delete(id);
	}
	
	/**
	 * @author 牛璐璐
	 * 时        间：2017年12月6日 下午6:06:07
	 * 功能描述：通过一个年龄查询女生
	 */
	@GetMapping(value = "/findByAge/age/{age}")
	public List<Girl> findByAge(@PathVariable("age") Integer age){
		return girlRepository.findByAge(age);
	}
	
	
	/**
	 * @author 牛璐璐
	 * 时        间：2017年12月7日 下午2:25:29
	 * 功能描述：事务绑定
	 */
	@PostMapping(value = "/girls/two")
	public void girlTwo(){
		girlService.insertTwo(); 
	}
	
	@GetMapping(value="girls/getAge/{id}")
	public void getAge(@PathVariable("id") Integer id) throws Exception{
		girlService.getAge(id);
	}
}
