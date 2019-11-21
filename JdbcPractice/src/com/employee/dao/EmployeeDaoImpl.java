package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.employee.bean.Employee;
import com.employee.clinet.EmployeeClient;
import com.employee.query.QueryConstants;
import com.employee.utill.ConnectionManager;

public class EmployeeDaoImpl implements EmployeeDao {
	Scanner sc=new Scanner(System.in);

	@Override
	public void addEmployeeDetails() {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(QueryConstants.INSERT_QUERY);
			System.out.println("employee no");
			int eno=sc.nextInt();
			System.out.println("enter employee name");
			String ename=sc.next();
			System.out.println("enter employee address");
			String eaddr=sc.next();
			ps.setInt(1, eno);
			ps.setString(2, ename);
			ps.setString(3, eaddr);
			int count=ps.executeUpdate();
			if(count!=0)
			{
				System.out.println("Data inserted sucessfully");
			}
			else
			{
				System.out.println("Data is not inserted sucesfully");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try {
				ConnectionManager.relaese(con,ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		

	}

	@Override
	public List<Employee> viewEmployeeDetails() {
		// TODO Auto-generated method stub
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<Employee>addRecords=new ArrayList<Employee>();
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
				bean.setEaddr(rs.getString(3));
				addRecords.add(bean);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try {
				ConnectionManager.release(rs, con, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return addRecords;
	}

	@Override
	public void viewSpecificEmployeeDetail() {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Employee bean=null;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(QueryConstants.SELECT_SPEFICQUERY);
			System.out.println("enter employee no");
			int eno=sc.nextInt();
			ps.setInt(1,eno);
			rs=ps.executeQuery();
			while(rs.next())
			{
				bean=new Employee();
				bean.setEno(rs.getInt(1));
				bean.setEname(rs.getString(2));
				bean.setEaddr(rs.getString(3));
			}
			System.out.println(bean);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try {
				ConnectionManager.release(rs, con, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void updateEmployeeDetails() {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		String UPDATE_QUERY="update employee set ename=? where eno=?";
		String UPDATE_QUERY1="update employee set eadd=? where eno=?";
		
		Employee bean=null;
		try {
			con=ConnectionManager.getConnection();
			System.out.println("which reocrd u want to update 1)name 2)addr 3)cancel");
			System.out.println("enter your choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				ps=con.prepareStatement(UPDATE_QUERY);
				System.out.println("enter employee number");
				int eno=sc.nextInt();
				System.out.println("enter employee name");
				String ename=sc.next();
				ps.setString(1, ename);
				ps.setInt(2, eno);
				int count=ps.executeUpdate();
				if(count!=0)
				{
					System.out.println("record name is updated");
				}
				else
				{
					System.out.println("record name is not updated");
				}
			case 2:
				ps=con.prepareStatement(UPDATE_QUERY1);
				System.out.println("enter employee number");
				int eno1=sc.nextInt();
				
				System.out.println("enter employee address");
				String eaddr=sc.next();
				ps.setString(1,eaddr);
				ps.setInt(2,eno1);
				int count1=ps.executeUpdate();
				if(count1!=0)
				{
					System.out.println("record address is upadted");
				}
				else
				{
					System.out.println("record address is not updated");
				}
			case 3:
				EmployeeClient.main(null);
				break;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
		  try {
			ConnectionManager.relaese(con, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	}

	@Override
	public void DeleteEmployeeDetials() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Connection con=null;
		PreparedStatement ps=null;
		Employee bean=null;
		
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(QueryConstants.DELETE_QUERY);
			System.out.println("enter employee no to delete record");
			int eno=sc.nextInt();
			ps.setInt(1,eno);	
			int count=ps.executeUpdate();
			if(count!=0)
			{
				System.out.println("reocrd is deleted");
			}
			else
			{
				System.out.println("record is not  deleted");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ConnectionManager.relaese(con, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
