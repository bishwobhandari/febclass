package com.diyo.controller;

import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diyo.entity.Employee;
import com.diyo.entity.EmployeeMapper;

@RestController
public class HomeController {
	
	
	
	//what is bean in spring?
	//in simple words as it is as a java class
	//since java class creation, deletion of the class,  are maintained by spring , 
	
	//in particular, there is a IOC container, that manages the bean 
	
	//in spring mvc, we use xml configuration 
	//in servlet.xml file lets create a bean for our database connection 
	
	//first , we have to get driver class
	//second, from that driver class we had to get connection-> we had to provide, url, username, password
	
	//spring will manage connecting to db, but we have to define as a bean
	
	//requirement: get me all the employee from employee table 
	
	//what does the method return? -> list of employees
	
	//in spring jdbc connection are done with jdbcTemplate
	
	//my HomeController class is not dependent on JdbcTemplate 
	
	private JdbcTemplate jdbcTemplate ;
	private DataSource dataSource;
	
	//Datasource dataSource = new DataSource(); this is taken care of by spring IOC container. 
	
	
	//create a setter method
	
	//for dependeencies injection there are two ways. 
	//1. constructor based
	//2. setter based
	
	//setter based dependency injection
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate  = new JdbcTemplate(dataSource);
	}
	

	
	//hosted on facebook.com  http://facebook.com/get-all-employee
	@GetMapping(value="get-all-employee", produces="application/json")
	public List<Employee> getAllEmployee(){
		
	
		String sql = "select * from employee";
		//EmployeeMapper em = new EmployeeMapper();
		
		List<Employee> empList  = jdbcTemplate.query(sql, new EmployeeMapper());
		
		return empList;
		
	}
	
	
	//get employee by id
	//create an api to get employee by id
	
	//use @PathVariable to send an id to this method
	
	@GetMapping(value="employee-by-id/{id}", produces="application/json")  //uri
	public Employee getEmployeeById(@PathVariable int id) { //@Pathvariable means i am sending a int id in path of the url
		
		System.out.println("the path variable sent in the method is " + id);
		
		String query = "select * from employee where id = ?";
		
		Employee em = jdbcTemplate.queryForObject(query, new Object[] {id},new EmployeeMapper() );
		
		//Employee em = new Employee();  //creating an object for Employee class
		
		return em;
		
	}
	
	//create an api where you delete an employee by id
	
	@DeleteMapping(value="/delete/{id}")
	public String deleteEmployeeById(@PathVariable int id) {
		String query = "delete from employee where id = ? ";
		
		int result = jdbcTemplate.update(query,new Object[] {id} );
		
		
		System.out.println(result);
		return  "successfully deleted";
	}
	
	//update any record in the database
	
	
	//Rest api has a method for update @PUT
	
	
	
	//@PutMapping -- if we need to update any record in the db
	//design an api that will take two parameters as path variable first one is id, second is age
	//write method that will update employee with that id for that age.
	//delete/{id}/{age}
	
	
	@PutMapping(value="/update/{id}/{age}", produces="application/json")
	public Employee updateEmployeeById(@PathVariable int id, @PathVariable int age) {

		
		System.out.println("id is"+id);
		
		System.out.println("age is"+age);
		
		Integer id1 = id;
		Integer age1 = age;
		
		String sql = "update employee set age =" + age + " where id = "+id;
		
		

		int result = jdbcTemplate.update(sql);
		
		String query="select * from employee where id =?";
		
		Employee em = jdbcTemplate.queryForObject(query, new Object[] {id},new EmployeeMapper() );
		
		
		System.out.println("id is"+result);
		
		
		return  em;
	}
	


}
