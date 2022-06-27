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
	
	MakeRecipe MR = new MakeRecipe();
	
	Recipe recipe = MR.buildRecipe(new OurDatabaseRecipeBuilder());
		
	String n=request.getParameter("RecipeName");  
    String a=request.getParameter("RecipeAmountFed");
    String u=request.getParameter("RecipeUserIDthatAdded");
    String d=request.getParameter("RecipeIngredient"); 
    String z=request.getParameter("RecipeIngredientMeasurementUnit");
    String r=request.getParameter("RecipeAmountOfIngredient"); 
    
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
        
        PreparedStatement s = con.prepareStatement("INSERT INTO RECIPE name=MR.name, amountFed=Mr.amountFed, userIdThatAdded=MR.userIdThatAdded,"
        		+ " ingredient = MR.Ingredient, UnitOfMeasurement= MR.UnitOfMeasurement,amountOfIngredient = MR.amountOfIngredient");
        		s.setString(1,n);
        		s.setString(2,a);
        		s.setString(3, u);
        		s.setString(4, d);
        		s.setString(5, z);
        		s.setString(6, r);

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch(Exception e){
		System.out.println(e);
		}  
		 
	}
}

class Recipe {
    String name;
    int amountFed;
    final String userAdded = "y";
    int userIdThatAdded;
    String ingredient;
    String unitOfMeasurement;
    int amountOfIngredient;

    public void setName(String name) {
        this.name = name;
    }

    public void setAmountFed(int amountFed) {
        this.amountFed = amountFed;
    }

    public void setuserIdThatAdded(int userIdThatAdded) {
        this.userIdThatAdded = userIdThatAdded;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public void setAmountOfIngredient(int amountOfIngredient) {
        this.amountOfIngredient = amountOfIngredient;
    }
}

abstract class RecipeBuilder {
    protected Recipe recipe = new Recipe();

    public Recipe getRecipe() {
        return recipe;
    }

    public abstract void buildName();
    public abstract void buildAmountfed();
    public abstract void builduserIdThatAdded();
    public abstract void buildIngredient();
    public abstract void buildUnitOfMeasurement();
    public abstract void buildAmountOfIngredient();
}

class OurDatabaseRecipeBuilder extends RecipeBuilder { //for user to build a recipe with our ingredients
    @Override
    public void buildName() {
        //get user input for name
        recipe.setName("userInputForName");
    }

    @Override
    public void buildAmountfed() {
        //get user input for how many servings
        recipe.setAmountFed(0); //the int will be user input for how many people the meal feeds
    }

    @Override
    public void builduserIdThatAdded() {
        //This will always be the userId that is adding the recipe
        recipe.setuserIdThatAdded(0);   //the int will be userId
    }

    @Override
    public void buildIngredient() {
        recipe.setIngredient("USER WILL CLICK AN INGREDIENT FROM DROPDOWN SELECTION FROM OUR INGREDIENTS TABLE IN DATABASE");
    }

    @Override
    public void buildUnitOfMeasurement() {
        //get user input for the unit of measurement to accompany the ingredient
        recipe.setUnitOfMeasurement("user input for measurement");
    }

    @Override
    public void buildAmountOfIngredient() {
        //get user input for how much of that particlar ingredient
        recipe.setAmountOfIngredient(0); //the int will be how much the user wants to add of that ingredient
    }
}

class NewIngredientRecipeBuiler extends RecipeBuilder { //for user to build a recipe with ingredients they add
    @Override
    public void buildName() {
        //get user input for name
        recipe.setName("userInputForName");
    }

    @Override
    public void buildAmountfed() {
        //get user input for how many servings
        recipe.setAmountFed(0); //the int will be user input for how many people the meal feeds
    }

    @Override
    public void builduserIdThatAdded() {
        //This will always be the userId that is adding the recipe
        recipe.setuserIdThatAdded(0);   //the int will be userId
    }

    @Override
    public void buildIngredient() {
        //have user input ingredients by name one by one and add to ingredients table
        recipe.setIngredient("Newly added ingredient ID in table");
    }

    @Override
    public void buildUnitOfMeasurement() {
        //get user input for the unit of measurement to accompany the ingredient
        recipe.setUnitOfMeasurement("user input for measurement");
    }

    @Override
    public void buildAmountOfIngredient() {
        //get user input for how much of that particlar ingredient
        recipe.setAmountOfIngredient(0); //the int will be how much the user wants to add of that ingredient
    }
}

class MakeRecipe {
    
    public Recipe buildRecipe(RecipeBuilder builder) {
        builder.buildName();
        builder.buildAmountfed();
        builder.builduserIdThatAdded();
        builder.buildIngredient();
        builder.buildUnitOfMeasurement();
        builder.buildAmountOfIngredient();
        return builder.getRecipe();
    }
}