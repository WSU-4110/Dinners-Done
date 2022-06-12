package DD;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class RecipeListServlet extends HttpServlet {
	 

	    public void doGet(HttpServletRequest request,
	                      HttpServletResponse response)
	        throws ServletException, IOException
	    {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	       
	        long before = System.currentTimeMillis();
	 
	          /*the getAttribute("data") will retrieve the info to be inserted onto
	          html page.  This will be linked according to entire list of recipes.
	          Will need a separate call for favorites.
	          TODO:  insert which info is to be querried from db
	          */
	        ServletContext context = getServletContext();
	        List list = (List)context.getAttribute("data");

/*
	        Iterator itr = list.iterator();
	 
	        // Condition holds true till there is single element
	        // remaining in the List
	        
	        while (itr.hasNext()) {
	            Recipe r = (Recipe)itr.next();
	            PrintWriter out = new PrintWriter();
				out.print("<br>" + Recipe.getName() + " " + Recipe.getWebAddress()
	                      + " " + Recipe.getDiscription());
	        }
*/	 
	        out.close();
	    }
}

