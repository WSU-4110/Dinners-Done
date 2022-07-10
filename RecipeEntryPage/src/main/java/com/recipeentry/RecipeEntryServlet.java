package com.recipeentry;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class RecipeEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public RecipeEntryServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/recipeentry.jsp";
		String ingredientsID = request.getParameter("ingrename");
		String ingredientAmount = request.getParameter("unitname");
		
		retrieveDB(ingredientsID, ingredientAmount);
		
		Recipe ingre = new Recipe(ingredientsID, ingredientAmount);
		
		request.setAttribute("cust", ingre);
		getServletContext().getRequestDispatcher(url).forward(request,response);
				
	}
	
	protected void retrieveDB(String ingredientsID, String ingredientAmount) {
		Connection con;
		
		try {
			Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:/home/bruno/eclipse-workspace/RecpiEntry/src/main/resources/recipeentry.db"; //path to the db
			con = DriverManager.getConnection(url);
			Statement s = con.createStatement();
			String query = "SELECT * FROM RecipesDB" + "(ingredients, unit)" + 
			"VALUES ('" + ingredientsID + "', '" + ingredientAmount + "', NULL)";
			s.executeUpdate(query);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	
}
