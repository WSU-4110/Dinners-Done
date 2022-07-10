import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.CommonDataSource;

import org.apache.tomcat.jdbc.pool.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/recipes")

public class RecipeServlet extends HttpServlet {
    
                
	private static final long serialVersionUID = 1L;
	private DataSource dataSource;
    private RecipeDao recipeDao;

    @Override
    public void init() {
        recipeDao = new RecipeDao(dataSource);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            List<Recipe> recipes = recipeDao.list();
                     //the following will make the recipe list available as ${recipes} in JSP
            request.setAttribute("recipes", recipes);

            request.getRequestDispatcher("/WEB-INF/products.jsp").forward(request, response);

        } catch (SQLException sqlEx) {
            throw new ServletException("Cannot retrieve recipes from database.", sqlEx);
        }
    }

}