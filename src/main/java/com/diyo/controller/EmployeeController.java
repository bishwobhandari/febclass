package com.diyo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diyo.dao.EmployeeDao;

@RestController
public class EmployeeController {
	
	//we need to inejct EmployeeDao class into EmployeeController
	
	//we need to get the EmployeeDao object here
	//we need dependency injection
	//i need to inject EmployeeDao into EmployeeController
	
	//constructor based DI
	
	//EmployeeDao employeeDao;
	
	//constructor baed DI
	
//	public EmployeeController(EmployeeDao emDao) {
//		this.employeeDao= emDao;
//		
//		
//	}
	
	//what is the importance?
	//if we do EmployeeDao emDao = new EmployeeDao(); create object ourself, the object will not be destroyed when are done with the program
	
	//doing DI, spring will create the object whenever needed and destroy after its done
	
	EmployeeDao emDao;
	
	//setter based DI
	//create setter method for the property
	
	public void setEmDao(EmployeeDao emDao) {
		this.emDao=emDao;
	}
	
	
	
	
	
	
	
	@GetMapping(value="get-hello")
	public String getHello() {
//		EmployeeDao emDao = new EmployeeDao();
//		
//		return emDao.getHello();
		
		return emDao.getHello();
		
	}

}
