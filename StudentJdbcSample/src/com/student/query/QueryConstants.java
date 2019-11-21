package com.student.query;

public interface QueryConstants {
	String INSERT_QUERY="insert into student values(?,?,?)";
	String SELECT_QUERY="select * from student";
	String SELECT_SPECIFICQUERY="select * from student where sno=?";
	String DELETE_QUERY="delete student where sno=?";

}
