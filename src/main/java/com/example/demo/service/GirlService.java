package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.GirlRepository;
import com.example.demo.entity.Girl;

@Service
public class GirlService {
	
	@Autowired
	private GirlRepository girlRepository;
	
	@Transactional
	public void insertTwo(){
		Girl girlA = new Girl();
		girlA.setCupSize("A");
		girlA.setAge(18);
		girlRepository.save(girlA);
		
		Girl girlB = new Girl();
		girlB.setCupSize("B");
		girlB.setAge(20);
		girlRepository.save(girlB);
	}
	
	public void getAge(Integer id) throws Exception{
		Girl girl = girlRepository.getOne(id);
		Integer age = girl.getAge();
		if(age < 10){
			//返回“你还在上小学吧” code=100
			throw new Exception("你还在上小学吧");
		}else if(age > 10 && age < 16){
			//返回“你可能在上初中“ code=101
			throw new Exception("你可能在上初中");
		}
		
	}
}
