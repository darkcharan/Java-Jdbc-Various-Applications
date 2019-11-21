package com.product.admin.details;

import java.util.List;
import java.util.Scanner;

import com.product.bean.Product;
import com.product.bean.dao.ProductDaoImpl;
import com.product.client.ProductClient;

public class AdminDetails {
public void adminMenu()
{
	ProductDaoImpl prodao =new ProductDaoImpl();
	while(true)
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("1)AddProductDetails");
	System.out.println("2)viewProductDetilas");
	System.out.println("3)viewspecificProductDetail");
	System.out.println("4)updateProductDetails");
	System.out.println("5)DeleteProductDetails");
	System.out.println("6)Back");
	System.out.println("enter your choice");
	int choice=sc.nextInt();
	
	switch(choice)
	{
	case 1: 		
	  prodao.addProductDetails();
	  break;
	  
	case 2:
		System.out.println("pid\tpname\tpprice\tpqnt");

		List<Product>viewRecords=prodao.addRecordsviewProductDetails();
		for(Product p:viewRecords)
		{
			System.out.println(p.getPid()+"\t"+p.getPname()+"\t"+p.getPprice()+"\t"+p.getPqty());
		}
		break;
	case 3:
		System.out.println("pid\tpname\tpprice\tpqnt");

		System.out.println("Enter Product Number");
		int pno=sc.nextInt();
	Product p=prodao.viewSpecificProductDetials(pno);
	if(p!=null)
	{
		System.out.println(p.getPid()+"\t"+p.getPname()+"\t"+p.getPprice()+"\t"+p.getPqty());
	}
	else
		System.out.println("Given Product Id is not avilble try Another product");
	break;
	case 4:
		prodao.updateProductDetials();
		break;
	case 5:
		prodao.DeleteProductDetilas();
		break;
	case 6:	
		ProductClient.main(null);
		break;
		default:
			System.out.println("Choose 1 to 6 between");

	
	
}

	}
}//Admin Menu


}
