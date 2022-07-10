

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


  @WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {  
	
private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("username");  
    String p=request.getParameter("userpass");  
          
    //the following calls the LoginVerification class and runs the validation
    //via a server query; the results are a bool
    
          //"servlet2" is a redirect if the info is valid
          //it will be updated to include the user-specific info
    
             //verify that the entries are not null
    if(n.length() > 0 && p.length() > 0) {
    	if(validate(n, p)){  
    		RequestDispatcher rd=request.getRequestDispatcher("/recipes");  
    		rd.forward(request,response);  
        }  
             //right now the reset is to the index page
             //FIXME: move the reset to login page when completed
        else{  
        	request.setAttribute("error", "Invalid Username and/or Password"); 
        	request.getRequestDispatcher("userSignIn.html").forward(request,  response); 
        }  	
    }   
                //following can be used in place of javaScript field verification
    else {
    	JOptionPane.showMessageDialog(null, "All fields need to be filled.");
    }
    out.close();       
}

public static boolean validate(String name,String pass){  
	boolean status=false;  
	
	try{  
		         
		Connection con = ConnToDb.getCon();
	
	//this will access any user account with matching parameters

	PreparedStatement stmnt1 = con.prepareStatement("select * from USERDB where name=? and pass=?");  
	stmnt1.setString(1,name);  
	stmnt1.setString(2,pass);  
	               
	//result will determine whether or not the entered
	//information portions were both valid (nothing returned by query if not)
	
	ResultSet res1 = stmnt1.executeQuery();  
	if(res1.next()) {
		//access favorites from user's linked recipes
		//display favorites on page
		//access any user-specified data for site
		
	}
	     
	
	}catch(Exception e){
		System.out.println(e);
	}  
	
	return status;  
	}  
} 
