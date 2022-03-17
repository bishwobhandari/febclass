package com.diyo.entity;




//models in MVC terms -> MVC means model view and controller
//entity
//also called POJO -> plain old java object
public class Employee {
	
	int id;
	
	String name;
	
	int age;
	
	
	
	
	
	//default constructor
	public Employee() {
		
	}



	//constructor with parameters or all arguments constructor
	public Employee(int id, String name, int age) {

		this.id = id;
		this.name = name;
		this.age = age;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public int getAge() {
		return age;
	}




	public void setAge(int age) {
		this.age = age;
	}




	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
	

}
