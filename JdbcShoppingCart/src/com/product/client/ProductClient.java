package com.product.client;

import java.util.Scanner;

import com.product.admin.details.AdminDetails;
import com.product.admin.details.UserDetails;

public class ProductClient {
	public static void main(String[] args)
	{
		AdminDetails details=new AdminDetails();	
		UserDetails userdetails=new UserDetails();
		Scanner sc=new Scanner(System.in);
		
		while(true)
		{
			System.out.println("1)Admin");
			System.out.println("2)User");
			System.out.println("3)Exit");
System.out.println("Enter A Number");
			int choice=sc.nextInt();
switch(choice)
{
case 1:
	details.adminMenu();
	break;
case 2:
	userdetails.userDetailsMenu();
	break;
case 3:
	System.out.println("Thx for using applications");
	System.exit(0);
	default:
	System.out.println("choose 1 to 3 between");
	break;
}
		}
			
		
	}
}

