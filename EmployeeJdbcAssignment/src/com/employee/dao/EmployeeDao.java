package com.employee.dao;

import java.util.List;

import com.employee.bean.Employee;

public interface EmployeeDao {

	void addEmployeeRecords();
	List<Employee>viewEmployeeRecords();
	Employee viewEmpRecord(int eno);
	void updateEmployeeRecord(int eno);
	void deleteEmployeeRecord(int eno);
}
