package com.employee.util;

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
System.out.println("Connection is established");
else
	System.out.println("Connection is not established");

		return con;
	}//close getConnection method
	
public static void release(Connection con,PreparedStatement ps) throws SQLException
{
	if(ps!=null)
		ps.close();
	if(con!=null)
		con.close();
}

public static void release(ResultSet rs, PreparedStatement ps, Connection con) throws SQLException {
	// TODO Auto-generated method stub
	if(rs!=null)
		con.close();
	if(ps!=null)
		ps.close();
	if(con!=null)
		con.close();
}
	
}
