import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.tomcat.jdbc.pool.DataSource;

public class Recipe {


//name, address, webAddress need to be linked to recipe db

int id;
String name;
String author;
String webAddress;
String description;
int servings;


int[] ingredientTotals;  
String[] ingredients;


public Recipe() {
	name = "";
	author = "";
	webAddress = "";
	description = "";
	servings = 0;
}

//constructor for recipe that has link
public Recipe(String name, String author, String webAddress, String[] ingredients) {
  this.name = name;
  this.author = author;
  this.webAddress = webAddress;
  this.ingredients = ingredients;
}

//constructor for recipe that is personally added
public Recipe(String name, String author, String[] ingredients) {
  this.name = name;
  this.author = author;
  this.ingredients = ingredients;
}

          //SETTERS
public void setId(int id) {
	this.id = id;
}

public void setName(String name) {
  this.name = name;
}

public void setAuthor(String author) {
  this.author = author;
}

public void setWebAddress(String webAddress) {
  this.webAddress = webAddress;
}

public void setIngredients(String[] ingredients) {
  this.ingredients = ingredients;
}

public void setDescription(String description) {
	this.description = description;
}

public void setServings(int servings) {
	this.servings = servings;
}

          //GETTERS

public int getId() {
	return id;
}

public String getName() {
  return name;
}

public String getAuthor() {
  return author;
}

public String getWebAddress() {
  return webAddress;
}

//link to db and add ingredients from db into array
public String[] getIngredients() {
  return ingredients;
}

public String getDescription() {
	return description;
}

public int getServings() {
	return servings;
}


/* the following function will take the user input from the website
to add ingredients for a recipe to the user's individual database of recipes
that recipe's information will only be available to that user and the system
*/
public void getInfoToAddToRecipeList(Connection c) throws SQLException, InstantiationException, IllegalAccessException {
  
  try {

	  Connection con = ConnToDb.getCon();

      Statement s = con.createStatement();
                  //update data fields with information from form
                  //then use those values to input information into database
                  //that has restricted access to only that user and system
      s.executeUpdate("INSERT INTO RECIPE " +
                      "NAME (givenInfo)" +
                      "AUTHOR (givenInfo) +" +
                      "URL (givenInfo" );
      //TODO: insert givenInfo formula & algorithm when Sprint 1 form completed by B. Martins

                  //after I receive the Sprint 1 information, I can decide which algorithm to follow
      String userInput;
      /*while(userInput.next()){
          add to local list of ingredients
      Once local array of ingredients completed
          loop through the array and insert via statement execute update as below
      After the entire list of ingredients' quantities for new recipe added,
          set output to screen that the recipe has been added
          display new recipe on screen via query and retrieval
      */
      s.executeUpdate("UPDATE INGREDIENTS IN RECIPE");
               /*ingredient will only be used for equivalence check
               unit should not be needed, as it is supposed to be pre-entered in form and unchanging
               following verification of name equivalence of ingredient
                  use corresponding name to insert new quantity
                  loop through entire ingredients list following same format
                */
      String query = "ADD INGREDIENT, QUANTITY, UNIT from RECIPE";


      con.close();    //close connection to avoid issues

  } catch (SQLException e) {
      e.printStackTrace();
      System.err.println(e.getMessage());
  }
}

}
