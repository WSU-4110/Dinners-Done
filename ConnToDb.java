
import java.sql.Connection;
import java.sql.DriverManager;


public class ConnToDb {

	
	public static Connection getCon() {
		Connection con = null;
		
		try {
			con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/DinnersDone", "root", "SEC4$dd@wsu%");
			
			if(con != null) {
				System.out.println("db connected");
			}
			
		}catch (Exception ex) {
			System.out.println("db not connected");
		}
		return con;
	}
}
