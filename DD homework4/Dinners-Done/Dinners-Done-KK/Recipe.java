package DD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Recipe {

//name, address, webAddress need to be linked to recipe db

String name;
String author;
String webAddress;
String description;

//TODO: set array to recipe list number
//TODO: set all first and third col values as given in recipeDB
String[] ingredients;  

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


/* the following function will take the user input from the website
to add ingredients for a recipe to the user's individual database of recipes
that recipe's information will only be available to that user and the system
 */
@SuppressWarnings("deprecation")
public void getInfoToAddToRecipeList(Connection c) throws SQLException {
    //TODO:  get info for inputting recipe when the interface is completed by B.Martins - due 6/2
    try {
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/DinnersDone";
        con = DriverManager.getConnection(url, "UserName", "Password");

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
        String query = "ADD INGREDIENT, QUANTITY, UNIT from RECIPES";


        con.close();    //close connection to avoid issues

    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (InstantiationException e) {
        e.printStackTrace();
        System.err.println(e.getMessage());
    } catch (IllegalAccessException e) {
        e.printStackTrace();
        System.err.println(e.getMessage());
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println(e.getMessage());
    }
}

}