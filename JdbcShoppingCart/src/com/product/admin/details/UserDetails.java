package com.product.admin.details;

import java.util.List;
import java.util.Scanner;

import com.product.bean.Product;
import com.product.client.ProductClient;
import com.product.user.dao.ShopingCartDaoImpl;

public class UserDetails {
	Scanner sc=new Scanner(System.in);
	ShopingCartDaoImpl cartDao=new ShopingCartDaoImpl();
public	void userDetailsMenu()
	{
		
		while(true)
		{
		System.out.println("1)ViewAllProducts");
		System.out.println("2)Shoping");
		System.out.println("3)Back");
	System.out.println("Enter Your Choice");
	int choice=sc.nextInt();
	switch(choice)
	{
	case 1:
		List<Product>viewDetails=cartDao.viewAllProducts();
		for(Product pro : viewDetails)
		{
			System.out.println(pro);
		}
		break;
	case 2:
		sopingMenu();
		
		break;
	case 3:
		ProductClient.main(null);
		break;
	default:
		System.out.println("choose 1 to 3 between");
	
	
	}
		
		
		
		
		}
		
	}//end of UserDetails
void sopingMenu()
{
	while(true)
	{
		System.out.println("1)AddCart");
	System.out.println("2)ViewCart");
	System.out.println("3)UpdateCart");
	System.out.println("4)RemoveCart");
	System.out.println("5)BillGenerate");
	System.out.println("6)Back");
	System.out.println("Enter Your Choice");
	int choice=sc.nextInt();
	switch(choice)
	{
	case 1:
		cartDao.addCart();
		break;
	case 2:
		cartDao.viewCart();
		break;
	case 3:
		cartDao.updateCart();
		break;
	
	case 4:
		cartDao.removeCart();
		break;
	
	case 5:
		cartDao.billGenerate();
		break;
	
	case 6:
		userDetailsMenu();
		break;
	default:
		System.out.println("choose 1 to 6 between");
	
	
	}
	
	
	
	
}


}
}
