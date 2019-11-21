package com.employee.client;

import java.util.List;
import java.util.Scanner;

import com.employee.bean.Employee;
import com.employee.dao.EmployeeDbImpl;

public class EmployeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
EmployeeDbImpl empdao=new EmployeeDbImpl();
		while(true)
{
		System.out.println("1)AddEmployeeRecords");
System.out.println("2)viewEmployeeRecords");
System.out.println("3)viewEmployee");
System.out.println("4)UpdateEmployee");
System.out.println("5)DeleteEmployee");
System.out.println("6)Exit");
System.out.println("Enter a Choice");
int choice=sc.nextInt();
switch(choice)
{
case 1:
	empdao.addEmployeeRecords();
	break;
case 2:
	System.out.println("eno\tename\teadd");
	List<Employee>viewRecords=empdao.viewEmployeeRecords();
	for(Employee e : viewRecords)
		System.out.println(e.getEno()+"\t"+e.getEname()+"\t"+e.getEadd());
	break;
case 3:
	System.out.println("eno\tename\teadd");

	System.out.println("Enter Employee Number");
	int eno=sc.nextInt();
Employee e=	empdao.viewEmpRecord(eno);
if(e!=null)
	System.out.println(e.getEno()+"\t"+e.getEname()+"\t"+e.getEadd());
else
	System.out.println("Employee Record is not avilable");
	break;
case 4:

	System.out.println("Enter Employee Number");
	int eno1=sc.nextInt();
	empdao.updateEmployeeRecord(eno1);
	break;
case 5:
	System.out.println("Enter Employee Number");
	int eno2=sc.nextInt();

	empdao.deleteEmployeeRecord(eno2);
	break;
case 6:
	System.out.println("Thx for Using Application");
System.exit(0);
break;
default:
	System.out.println("Choose 1 to 6 between");




}
}


	}

}
