package DD;

import java.io.IOException;  
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

  
public class LoginServlet extends HttpServlet {  
	
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
    if(LoginVerification.validate(n, p)){  
        RequestDispatcher rd=request.getRequestDispatcher("servlet2");  
        rd.forward(request,response);  
    }  
             //right now the reset is to the index page
             //FIXME: move the reset to login page when completed
    else{  
        out.print("Username and/or password incorrect");  
        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
        rd.include(request,response);  
    }  
          
    out.close();  
    }  
} 
