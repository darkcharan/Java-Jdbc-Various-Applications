package com.employee.clinet;

import java.util.List;
import java.util.Scanner;

import com.employee.bean.Employee;
import com.employee.dao.EmployeeDaoImpl;

public class EmployeeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		EmployeeDaoImpl edao=new EmployeeDaoImpl();
		while(true)
		{
			System.out.println("1)AddEmployeeDetails");
			System.out.println("2)viewEmployeeDetials");
			System.out.println("3)viewSpeficEmployeeDetials");
			System.out.println("4)updateEmployeeDetails");
			System.out.println("5)DeleteEmployeeDetails");
			System.out.println("6)exit");
			System.out.println("enter a choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				edao.addEmployeeDetails();
				break;
			case 2:
				edao.viewEmployeeDetails();
				List<Employee>viewRecords=edao.viewEmployeeDetails();
				for(Employee e:viewRecords)
					System.out.println(e.getEno()+"\t"+e.getEname()+"\t"+e.getEaddr());
					break;
				
			case 3:
				edao.viewSpecificEmployeeDetail();
				System.out.println("employee record is avilable");
				break;
			case 4:
				edao.updateEmployeeDetails();
				break;
			case 5:
				edao.DeleteEmployeeDetials();
				break;
			}
			
			
		}

	}

}
