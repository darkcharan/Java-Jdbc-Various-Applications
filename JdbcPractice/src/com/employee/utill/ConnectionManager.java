package com.employee.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionManager {
public static	Connection con=null;
	
	public static Connection getConnection() throws SQLException
	{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		
		con=DriverManager.getConnection("jdbdc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		if(con!=null)
			System.out.println("connection is established");
		else
			System.out.println("connection is not established");
		
		return con;
		
	}
	
	public static void relaese(Connection con, PreparedStatement ps) throws SQLException
	{
		if(ps!=null)
			ps.close();
		if(con!=null)
			con.close();
	}
	
	public static void release(ResultSet rs,Connection con,PreparedStatement ps) throws SQLException
	{
		if(rs!=null)
			rs.close();
		if(con!=null)
			con.close();
		if(ps!=null)
			ps.close();
		
	}

}
