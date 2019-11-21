import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PsStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		
		PreparedStatement ps=null;
		
		
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");	
		ps=con.prepareStatement("insert into student values(? ? ?)");
		ps.setInt(1,101);
		ps.setString(2, "rani");
		ps.setString(3, "hyd");
		
		int count=ps.executeUpdate();
		if(count!=0)
		System.out.println("query is effected");
		else
			System.out.println("query is not effected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

}
