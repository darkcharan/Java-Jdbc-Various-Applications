package com.product.bean.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import com.product.bean.Product;
import com.product.query.QueryConstants;
import com.product.utill.ConnectionManager;

public class ProductDaoImpl implements ProductDao {
	Scanner sc=new Scanner(System.in);
	

	@Override
	public void addProductDetails() {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(QueryConstants.INSERT_QUERY);
			System.out.println("enter product number");
			int pno=sc.nextInt();
			System.out.println("enter product name");
			String pname=sc.next();
			System.out.println("enter product price");
			double pprice=sc.nextDouble();
			System.out.println("enter product quantity");
			int pqty=sc.nextInt();
			ps.setInt(1,pno);
			ps.setString(2,pname);
			ps.setDouble(3,pprice);
			ps.setInt(4,pqty);
			
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
	public List<Product> addRecordsviewProductDetails() {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<Product>addRecords=new ArrayList<Product>();
		Product bean=null;
		
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(QueryConstants.SELECT_QUERY);
			rs=ps.executeQuery();
			while(rs.next())
			{
				bean=new Product();
				bean.setPid(rs.getInt(1));
				bean.setPname(rs.getString(2));
				bean.setPprice(rs.getDouble(3));
				bean.setPqty(rs.getInt(4));
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
				ConnectionManager.release(rs, con, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return addRecords;
	}

	@Override
	public Product viewSpecificProductDetials(int pno) {
		// TODO Auto-generated method stub
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Product bean=null;
		
		{
			try {
				con=ConnectionManager.getConnection();
				ps=con.prepareStatement(QueryConstants.SELECT_SPECIFICQUERY);
				ps.setInt(1,pno);
				rs=ps.executeQuery();
				while(rs.next())
				{
					bean=new Product();
					bean.setPid(rs.getInt(1));
					bean.setPname(rs.getString(2));
					bean.setPprice(rs.getDouble(3));
					bean.setPqty(rs.getInt(4));
				}
				System.out.println(bean);

				
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
					ConnectionManager.release(rs, con, ps);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			
		}
		
return bean;
	}

	@Override
	public void updateProductDetials() {
		// TODO Auto-generated method stub
		
		Connection con=null;
		PreparedStatement ps=null;
		String UPDATE_QUERY="update Product set pname=? where pno=?";
		String UPDATE_QUERY1="update Product set pprice=? where pno=?";
		String UPDATE_QUERY2="update Product set pqty=? where pno=?";
		
		Product bean=null;
		{
			try {
				con=ConnectionManager.getConnection();
				System.out.println("enter Product number");
				int pno=sc.nextInt();
				
				System.out.println("which detail u want to update 1)name 2)price 3)quantity");
				System.out.println("enter your choce");
				int choice=sc.nextInt();
				switch(choice)
				{
				case 1:ps=con.prepareStatement(UPDATE_QUERY);
				System.out.println("enter Product name");
				String pname=sc.next();
				ps.setString(1, pname);
				ps.setInt(2, pno);
				int count=ps.executeUpdate();
				if(count!=0)
				{
					System.out.println("detail name is updated");
				}
				else
				{
					System.out.println("detail name is not updated");
				}
				case 2:ps=con.prepareStatement(UPDATE_QUERY1);
				System.out.println("enter product price");
				double pprice=sc.nextDouble();
				ps.setDouble(1, pprice);
				ps.setInt(2, pno);
				int count1=ps.executeUpdate();
				if(count1!=0)
				{
					System.out.println("detail price is updated");
				}
				else
				{
					System.out.println("detail price is not updated");
				}
				case 3:ps=con.prepareStatement(UPDATE_QUERY2);
				System.out.println("enter product quantity");
				int pqty=sc.nextInt();
				ps.setInt(1, pqty);
				ps.setInt(2, pno);
				int count2=ps.executeUpdate();
				if(count2!=0)
				{
					System.out.println("detail quantity is updated" );
				}
				else
				{
					System.out.println("detail quantity is not updated");
				}
				
				
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

		
		
		

	}

	@Override
	public void DeleteProductDetilas() {
		// TODO Auto-generated method stub
		
		Connection con=null;
		PreparedStatement ps=null;
		Product bean=null;
		{
			try {
				con=ConnectionManager.getConnection();
				ps=con.prepareStatement(QueryConstants.SELECT_DELETE);
				System.out.println("enter Product number to delete record");
				int pno=sc.nextInt();
				ps.setInt(1,pno);	
				int count=ps.executeUpdate();
				if(count!=0)
				{
					System.out.println("reocrd is deleted");
				}
				else
				{
					System.out.println("record is not  deleted");
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
		

		
		
		

	}

}
