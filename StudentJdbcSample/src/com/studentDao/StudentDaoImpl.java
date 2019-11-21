package com.studentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.student.query.QueryConstants;
import com.student.utll.ConnectionManager;
import com.studentbean.StudentBean;

public class StudentDaoImpl implements StudentDao {
	Scanner sc=new Scanner(System.in);
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	StudentBean bean=null;

	@Override
	public void AddStudent() {
		// TODO Auto-generated method stub
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(QueryConstants.INSERT_QUERY);
			System.out.println("enter student number");
			int sno=sc.nextInt();
			System.out.println("enter student name");
			String sname=sc.next();
			System.out.println("enter student address");
			String saddr=sc.next();
			ps.setInt(1, sno);
			ps.setString(2, sname);
			ps.setString(3, saddr);
			int count=ps.executeUpdate();
			if(count!=0)
			{
				System.out.println("data inserted sucessfully");
			}
			else
			{
				System.out.println("data is not inserted sucessfully");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ConnectionManager.release(con, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<StudentBean> viewStudent() {
		// TODO Auto-generated method stub
		List<StudentBean>addRecords=new ArrayList<StudentBean>();
		StudentBean bean=null;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(QueryConstants.SELECT_QUERY);
			rs=ps.executeQuery();
			while(rs.next())
			{
				bean=new StudentBean();
				bean.setSno(rs.getInt(1));
				bean.setSname(rs.getString(2));
				bean.setSaddr(rs.getString(3));
				addRecords.add(bean);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ConnectionManager.release(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				return addRecords;
	}

	@Override
	public void viewStudent(int sno) {
		// TODO Auto-generated method stub
		StudentBean bean=null;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(QueryConstants.SELECT_SPECIFICQUERY);
			ps.setInt(1, sno);
			rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ConnectionManager.release(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

	@Override
	public void UpdateStudent(int sno) {
		// TODO Auto-generated method stub
		final String UPDATE_QUERY="update student set sname=? where sno=?";
		final String UPDATE_QUERY1="update student set saddr=? where sno=?";
		try {
			con=ConnectionManager.getConnection();
			System.out.println("whiwch record you want to update 1)Name 2)address");
			System.out.println("enter your choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				ps=con.prepareStatement(UPDATE_QUERY);
				System.out.println("enter updated student name");
				String sname=sc.next();
				ps.setString(1, sname);
				ps.setInt(2, sno);
				int count=ps.executeUpdate();
				if(count!=0)
				{
					System.out.println("record is updated");
				}
				else
				{
					System.out.println("record is not updated");
				}
				break;
			case 2:
				ps=con.prepareStatement(UPDATE_QUERY1);
				System.out.println("enter updated address");
				String saddr=sc.next();
				ps.setString(1, saddr);
				ps.setInt(2, sno);
				int count1=ps.executeUpdate();
				if(count1!=0)
				{
					System.out.println("record is updated");
				}
				else
				{
					System.out.println("record is not updated");
				}
				break;
				default:
					System.out.println("enter your choice from 1 to 2");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ConnectionManager.release(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

	@Override
	public void DeleteStudent(int sno) {
		// TODO Auto-generated method stub
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(QueryConstants.DELETE_QUERY);
			ps.setInt(1, sno);
			int count=ps.executeUpdate();
			if(count!=0)
			{
				System.out.println("record is deleted");
			}
			else
			{
				System.out.println("record is not deleted");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ConnectionManager.release(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
