package com.student.utll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionManager {
	private static Connection con=null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		if(con!=null)
		 System.out.println("connection is established");
		else
			System.out.println("connection is not established");
		return con;
	}
	public static void release(Connection con,PreparedStatement ps) throws SQLException
	{
		if(con!=null)
			con.close();
		if(ps!=null)
		ps.close();
		
	}
	public static void release(Connection con,PreparedStatement ps,ResultSet rs) throws SQLException
	{
		if(rs!=null)
		rs.close();
		if(con!=null)
		con.close();
		if(ps!=null)
		ps.close();
		
	
	}

}
