package com.employee.dao;

import java.util.List;

import com.employee.bean.Employee;

public interface EmployeeDao {
	
	void addEmployeeDetails();
	List<Employee>viewEmployeeDetails();
	void viewSpecificEmployeeDetail();
	void updateEmployeeDetails();
	void DeleteEmployeeDetials();
	

}
