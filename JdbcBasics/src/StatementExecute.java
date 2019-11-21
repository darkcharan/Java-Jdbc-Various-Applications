import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementExecute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			st=con.createStatement();
			rs=st.executeQuery("select * from student");
			//executes the given sql statement and get the data from db and stores insdie the resultsetinterface
			//ResultSet interface referecne variable point to first record
			System.out.println("sno\tsname\tsadd");
			while(rs.next())
			{
				int sno=rs.getInt(1);
				String sname=rs.getString(2);
				String sadd=rs.getString(3);
				System.out.println(sno+"\t"+sname+"\t"+sadd);
			}
			
			
					}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if(st!=null)
				try {
					st.close();
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
