package com.diyo.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee em = new Employee();
		
		em.setName(rs.getString("name"));
		em.setAge(rs.getInt("age"));
		em.setId(rs.getInt("id"));
			
		return em;
	}
	
	
	
	

}
