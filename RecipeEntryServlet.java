package DD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/recipeEntryPage")
public class RecipeEntryServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException { 
	
	String n=request.getParameter("RecipeName");  
    String a=request.getParameter("RecipeAuthor");
    String u=request.getParameter("RecipeUrl");
    String d=request.getParameter("Recipe");  //short description
    
    //TODO:  create additional form entries for ingredients
    //TODO:  link the ingredients to the array once created
    try {
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/DinnersDone";
        con = DriverManager.getConnection(url, "UserName", "Password");

        //update data fields with information from form
        //then use those values to input information into database
        //that has restricted access to only that user and system
        
        PreparedStatement s = con.prepareStatement("INSERT INTO RECIPE name=?, author=?, URL=?, description=?");
        		s.setString(1,n);
        		s.setString(2,a);
        		s.setString(3, u);
        		s.setString(4, d);
   

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch(Exception e){
		System.out.println(e);
		}  
		 
	}
}
