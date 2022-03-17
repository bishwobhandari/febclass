package com.diyo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.diyo.entity.Employee;


//annotation rest controller that mean spring will store this as a controller 
//this controller is controller in MVC pattern 
@RestController
public class MyController {
	
	
	//api application program interface
	
	
	// rest api
	//url for the app will look like 
	
	
	

	//localhost:8080/springdemo/
	//this is a api
	//@RequestMapping
	//value is url for api
	
	
	//@RequestMapping(value="/name", method=RequestMethod.GET) //by default this is get request
	
	
	@GetMapping(value="/name")
	public String hello() {
		return "hello good morning this is hello controller";
	}
	
	
	//GET -> to get something from database
	//POST -> if you need to pass some parameters you need to use POST 
	
	
	
	
	@PostMapping(value="/save")
	public String saveEmployee(@RequestBody String name) {
		
		
		System.out.println(name);
		
		//write some logic here to connect to database and post or create employee or insert employee
		
		return "success";
	}
	
	
	
	
	
	
	
	
	//hashmap has key and value
	//json format is also key value
	
	//to be able to access this method (hello) we have to deploy the application
	//to deploy the web application, we have to create something called WAR file. WAR web application resource. 
	//maven is just a build tool
	//to build WAR file using maven 
	// after you build WAR file, maven will store that war file in target folder 
	//we will use mvn clean and we will use mvn install 
	//mvn clean will delete the war file if exist in target folder
	//mvn install will build a new war file. 
	
	//CRUD operations in database
	//create 
	//read
	//update
	//delete 
	
	
	//frontend app that is in angular - worker 1 
	//backend app that is in spring  - worker 2
	// worker 2 already finished his work
	//job was to build an api that will some parameters like username passsword
	
	
	//try to post json object that (employee)
	
	
	//design an api that will take a employee as parameter
	
	//post request is used when you need to insert datat into database
	
	// get request is used when you need to fetch data from database. 
	
	
	//problem here is to post data into database 
	//for example we need to create a employee
	
	//type of object coming in parameters if you want to post employee 
	
	@PostMapping(value="/post-empoyee" , consumes="application/json")
	public Employee  postEmployee(@RequestBody Employee em ) {
		
		
		System.out.println("sending request from postman in postEmployee method");
		System.out.println(em.toString());
		
		
		//
		em.setAge(em.getAge()*2);
		
		return em;
		

	}
	
	
	//these are Rest web services
	
	
	

}
