package com.student.client;

import java.util.List;
import java.util.Scanner;

import com.studentDao.StudentDaoImpl;
import com.studentbean.StudentBean;

public class StudentClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		StudentDaoImpl stu=new StudentDaoImpl();
		int k=1;
			while(k==1)
			{
		System.out.println("1)Add Student Record");
		System.out.println("2)View Student Record");
		System.out.println("3)View Specific Student Record");
		System.out.println("4)Update Student Record");
		System.out.println("5)Delete Student Record");
		System.out.println("6)exit");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			stu.AddStudent();
			break;
		case 2:
			List<StudentBean>viewRecords=stu.viewStudent();
			for(StudentBean bean:viewRecords)
			{
				System.out.println(bean.getSno()+bean.getSname()+bean.getSaddr());
			}
			break;
		case 3:
			System.out.println("enter student number");
			int sno=sc.nextInt();
			stu.viewStudent(sno);
			break;
		case 4:
			System.out.println("enter student number");
			int sno1=sc.nextInt();
			stu.UpdateStudent(sno1);
			break;
		case 5:
			System.out.println("enter student number");
			int sno2=sc.nextInt();
			stu.DeleteStudent(sno2);
			break;
		case 6:
			System.out.println("tq u for using");
			System.exit(0);
		
		}
		
		

	}

}
}