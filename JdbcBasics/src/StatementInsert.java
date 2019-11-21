import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement st=null;
		final String INSERT_QUERY="insert into student values(100,'charan','hyd')";
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr","hr");	
		    st=con.createStatement();
		    int count=st.executeUpdate(INSERT_QUERY);
		    
		    if(count!=0)
		   
		    	System.out.println("query if effected");
		    else
		    	System.out.println("query is not effected");
		    
		    if(con!=null)
		    	System.out.println("connection is established");
		    else
		    	System.out.println("connection is not established"); 
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(st!=null)
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}

	}

}
