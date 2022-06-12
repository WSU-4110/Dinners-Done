package DD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginVerification {

	//the following will validate the user's site-entered information
	
	    //connection temporarily set for jdbc
	public static boolean validate(String name,String pass){  
		boolean status=false;  
		try{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con = DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
		
		//assume "USERDB" is descriptor of user database information tables
		//assume "name" is descriptor for username
		//assume "pass" is descriptor for password column in db
		
		PreparedStatement stmnt1 = con.prepareStatement
				("select * from USERDB where name=? and pass=?");  
		stmnt1.setString(1,name);  
		stmnt1.setString(2,pass);  
		               
		//result will determine whether or not the entered
		//information portions were both valid
		
		ResultSet res1 = stmnt1.executeQuery();  
		status=res1.next();  
		          
		}catch(Exception e){
			System.out.println(e);
		}  
		
		return status;  
		}  
}
