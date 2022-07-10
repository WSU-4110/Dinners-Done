import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;

public class RecipeDao  {
    public RecipeDao(DataSource dataSource) {

    }
                           //create a list of recipe objects to be used as favorites, shopping list, etc.
    public List<Recipe> list() throws SQLException {
        List<Recipe> recipes = new ArrayList<Recipe>();
                           
        try{
            Connection con = ConnToDb.getCon();
            PreparedStatement pst = con.prepareStatement("SELECT id, name, description, servings FROM recipes");
            ResultSet rs = pst.executeQuery();


            // after results are returned, create a new recipe object for each
            // use values from each row of db returned as data field
            // then add each recipe to the list

            while(rs.next() ) {
                Recipe recipe = new Recipe();
                recipe.setId(rs.getInt("id") );
                recipe.setName(rs.getString("name") );
                recipe.setDescription(rs.getString("description") );
                recipe.setServings(rs.getInt("servings") );
                recipes.add(recipe);

            }
        }finally {
        	
        }
        return recipes;
    }
}