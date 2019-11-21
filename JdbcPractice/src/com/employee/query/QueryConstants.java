package com.employee.query;

public interface QueryConstants {
	
	String INSERT_QUERY="insert into employee values(?,?,?)";
	String SELECT_QUERY="select * from employee";
	String SELECT_SPEFICQUERY="select * from employee where eno=?";
	
	String DELETE_QUERY="delete employee where eno=?";

}
