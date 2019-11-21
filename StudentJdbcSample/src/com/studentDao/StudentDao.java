package com.studentDao;

import java.util.List;

import com.studentbean.StudentBean;

public interface StudentDao {
	void AddStudent();
	List<StudentBean>viewStudent();
	void viewStudent(int sno);
	void UpdateStudent(int sno);
	void DeleteStudent(int sno);

}
