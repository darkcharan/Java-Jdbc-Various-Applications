import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement st=null;
		final String UPDATE_QUERY="update student set sname='deep' where sno=100";
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			st=con.createStatement();
			int count=st.executeUpdate(UPDATE_QUERY);
			if(count!=0)
			{
				System.out.println("querry is effected");
			}
			else
			{
				System.out.println("query is not effected");
			}
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
