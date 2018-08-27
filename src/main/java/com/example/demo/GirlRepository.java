package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Girl;

public interface GirlRepository extends JpaRepository<Girl, Integer>{
	
	//通过年龄来查询
	public List<Girl> findByAge(Integer age);

//	List<Girl> save(Girl girl);

}
