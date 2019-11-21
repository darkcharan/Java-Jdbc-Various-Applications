package com.product.user.dao;

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

public class ShopingCartDaoImpl implements ShopingCartDao {

	List<Product> viewRecords=null;
	List<Product> addCart=new ArrayList<Product>();
	
	Scanner sc=new Scanner(System.in);
	@Override
	public List<Product> viewAllProducts() {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
	viewRecords=new ArrayList<Product>();
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
				viewRecords.add(bean);
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
		return viewRecords;
	}

	@Override
	public void addCart() {
		// TODO Auto-generated method stub
System.out.println("Avilable Products on SuperMart");
viewRecords=viewAllProducts();
for(Product product: viewRecords)
	System.out.println(product);
System.out.println("Do You want to Continue Shopping 1)Yes  2)No");
int k=sc.nextInt();
while(k==1)
{
System.out.println("Which Product u want to Buy");
int pid=sc.nextInt();
System.out.println("Howmany Products u want");
int pqty=sc.nextInt();



int s=0;

for(Product product: viewRecords)
{
	if(product.getPid()==pid)
	{
		s++;
		product.setPqty(pqty);
		addCart.add(product);
		System.out.println("Given Product added to the cart");
	}
}
if(s==0)
{
	System.out.println("Given Product Is not Avilable");
}
	System.out.println("Do You want to Continue Shopping 1)Yes  2)No");	
k=sc.nextInt();
}

}

	@Override
	public void viewCart() {
		// TODO Auto-generated method stub
for(Product product : addCart)
	System.out.println(product);
	}

	@Override
	public void updateCart() {
		System.out.println("Avilable Products on SuperMart");
		viewRecords=viewAllProducts();
		for(Product product: viewRecords)
			System.out.println(product);
		System.out.println("Do You want to Continue Shopping 1)Yes  2)No");
		int k=sc.nextInt();
		while(k==1)
		{
		System.out.println("Which Product u want to Buy");
		int pid=sc.nextInt();
		System.out.println("Howmany Products u want");
		int pqty=sc.nextInt();

		int s=0;

		for(Product product: viewRecords)
		{
			if(product.getPid()==pid)
			{
				s++;
product.setPqty(pqty);
				addCart.add(product);
				System.out.println("Given Product added to the cart");
			}
		}
		if(s==0)
		{
			System.out.println("Given Product Is not Avilable");
		}
			System.out.println("Do You want to Continue Shopping 1)Yes  2)No");	
		k=sc.nextInt();
		}


}

		
	@Override
	public void removeCart() {
		// TODO Auto-generated method stub
System.out.println("avilable products on cart");
		for(Product product : addCart)
			System.out.println(product);
	System.out.println("Which Product u want to remove");	
	int pid=sc.nextInt();
	int s=0;
	for(Product product : addCart)
	{
	if(product.getPid()==pid)
	{
		s++;
		addCart.remove(product);
		System.out.println("Product Remove From Cart");
	}

	}
if(s==0)
System.out.println("given product is not avilable");		
	}

	@Override
	public void billGenerate() {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;

		ResultSet rs=null;
		String select_query="select * from product where pid=?";
		String update_query="update product set pqty=? where pid=?";

		System.out.println("avilable products on cart");
		for(Product product : addCart)
			System.out.println(product);
System.out.println("Generating Bill");
double totalBill=0.0;
double  bill=0;
System.out.println("PRODUCTID\tPRODUCTNAME\tPRODUCTPRICE\tPRODUCTQTY\tTOTAL");
for(Product product : addCart)
{
	try {
		con=ConnectionManager.getConnection();
		ps=con.prepareStatement(select_query);
		ps.setInt(1,product.getPid());
		rs=ps.executeQuery();
	boolean flag=rs.next();
int count=0;
	if(flag==true)
	{
		int pqty=rs.getInt(4);
		ps1=con.prepareStatement(update_query);
		if(product.getPqty()<pqty)
		{
			pqty=pqty-product.getPqty();
				ps1.setInt(1,pqty);
		ps1.setInt(2,product.getPid());
	count=ps1.executeUpdate();
	System.out.println(product.getPid()+"\t"+product.getPname()+"\t"+product.getPprice()+"\t"+product.getPqty()+"\t"+product.getPprice()*product.getPqty());
	 bill=(product.getPprice()*product.getPqty());
		}
		else
		{
	System.out.println("sufficent  products are not avilale We are not adding bill");
		}
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	totalBill=totalBill+bill;
	
		
}
System.out.println("*********************************************");
System.out.println("Total Bill :"+ totalBill);
System.out.println("*********************************************");

/*Connection con=null;
PreparedStatement ps=null;
PreparedStatement ps1=null;

ResultSet rs=null;
System.out.println("*********************************************");
System.out.println("Total Bill :"+ totalBill);
System.out.println("*********************************************");
String select_query="select * from product where pid=?";
String update_query="update product set pqty=? where pid=?";
*/
/*for(Product product : addCart)
{
	try {
		con=ConnectionManager.getConnection();
		ps=con.prepareStatement(select_query);
		ps.setInt(1,product.getPid());
		rs=ps.executeQuery();
	boolean flag=rs.next();
int count=0;
	if(flag==true)
	{
		int pqty=rs.getInt(4);
		ps1=con.prepareStatement(update_query);
		if(product.getPqty()<pqty)
		{
			pqty=pqty-product.getPqty();
				ps1.setInt(1,pqty);
		ps1.setInt(2,product.getPid());
	count=ps1.executeUpdate();
		}
		else
		{
	System.out.println("sufficent products are not avilale check later");
		}
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}*/
		
	}
}
