package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.employee.bean.Employee;
import com.employee.client.EmployeClient;
import com.employee.query.QueryConstants;
import com.employee.util.ConnectionManager;

public class EmployeeDbImpl implements EmployeeDao {
Scanner sc=new Scanner(System.in);
	//implements methods
	@Override
	public void addEmployeeRecords() 
	{
			// TODO Auto-generated method stub
Connection con=null;
PreparedStatement ps=null;
		try {
//Register a Driver
			//Establish connection with database s/w
	con=ConnectionManager.getConnection();
	ps=con.prepareStatement(QueryConstants.INSERT_QUERY);
System.out.println("Enter Employee Number");
int eno=sc.nextInt();
System.out.println("Enter Employee Name");
String ename=sc.next();
System.out.println("Enter Employee Address");
String eadd=sc.next();
ps.setInt(1,eno);
ps.setString(2,ename);
ps.setString(3,eadd);
int count=ps.executeUpdate();
	if(count!=0)
		System.out.println("Data Inserted SuccessFully");
	else
		System.out.println("Data Not Inserted Check Once");

		}
		catch (ClassNotFoundException e) 
		{
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ConnectionManager.release(con,ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public List<Employee> viewEmployeeRecords() {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Employee> addRecords=new ArrayList<Employee>();
		Employee bean=null;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(QueryConstants.SELECT_QUERY);
			rs=ps.executeQuery();
			while(rs.next())
			{
				bean=new Employee();
				bean.setEno(rs.getInt(1));
				bean.setEname(rs.getString(2));
				bean.setEadd(rs.getString(3));
				addRecords.add(bean);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ConnectionManager.release(rs,ps,con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return addRecords;
	}

	@Override
	public Employee viewEmpRecord(int eno) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Employee bean=null;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(QueryConstants.SELECT_SPECIFICQUERY);
			ps.setInt(1,eno);
			rs=ps.executeQuery();
			if(rs.next())
			{
				bean=new Employee();
				bean.setEno(rs.getInt(1));
				bean.setEname(rs.getString(2));
				bean.setEadd(rs.getString(3));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ConnectionManager.release(rs,ps,con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return bean;
	}

	@Override
	public void updateEmployeeRecord(int eno) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		final String UPDATE_QUERY="update employee set ename=? where eno=?";
		final String UPDATE_QUERY1="update employee set eadd=? where eno=?";

		Employee bean=null;
		try {
			con=ConnectionManager.getConnection();
	System.out.println("Which Record U want to Update 1)Name 2)Address 3)Cancel");
	System.out.println("Enter a Choice");
	int choice=sc.nextInt();
	switch(choice)
	{
	case 1:
		ps=con.prepareStatement(UPDATE_QUERY);
		System.out.println("Enter Employee Name");
		String ename=sc.next();
		ps.setString(1,ename);
		ps.setInt(2,eno);
	int count=	ps.executeUpdate();
	if(count!=0)
		System.out.println("Given Name is Updated");
	else
		System.out.println("Given Name is not Updated Check Once");
	break;
	case 2:
		ps=con.prepareStatement(UPDATE_QUERY1);
		System.out.println("Enter Employee Address");
		String eadd=sc.next();
		ps.setString(1,eadd);
		ps.setInt(2,eno);
	int count1=	ps.executeUpdate();
	if(count1!=0)
		System.out.println("Given Address is Updated");
	else
		System.out.println("Given Address is not Updated Check Once");
	break;
	case 3:
		EmployeClient.main(null);
		break;
	default:
		System.out.println("Choose 1 to 2 only");
		
	}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ConnectionManager.release(con,ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void deleteEmployeeRecord(int eno) {
		// TODO Auto-generated method stub
		
		Connection con=null;
		PreparedStatement ps=null;
		
		Employee bean=null;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(QueryConstants.DELETE_QUERY);
			ps.setInt(1,eno);
		int count=ps.executeUpdate();
		if(count!=0)
			System.out.println("Given Record deleted");
		else
			System.out.println("Given Record not Avilable Check Once");

			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ConnectionManager.release(con,ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		

	}

}
