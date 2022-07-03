import java.sql.*;

public class ProjectMain {
    public static void main(String[] args) {

        Recipe[] recipe = new Recipe[20];
        double[] ingredients = new double[101]; //main array used for calculations

        String[][] ingredientsUnitName = new String[101][2]; //used so we can easily output without another query
        //first array being ingredient name, second being units for that ingredient.
        //get ID and amount of ingredient for each recipe object

        String url = "jdbc:sqlite:src/main/resources/RecipesDB.db"; //path from content root
        try {

            // query that shows records needed from each recipe, this example uses recipe 3 as seen in R2I.idrecipe = 3"
            //String query = "select I.name, I.unit, amount from ingredients I inner join recipe_ingredient R2I" +
            // " on I.idingredients = R2I.idingredient where R2I.idrecipe = 3";

            //ResultSet rset = statement.executeQuery(query);

            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();

            String nameQuery = "select name, amountFed, link from recipes"; //query for name, serving size, and web address
            ResultSet rset = statement.executeQuery(nameQuery);
            int counter = 0;
            while(rset.next()) {   // process each row
                recipe[counter] = new Recipe(rset.getString("name"), rset.getInt("amountFed"), rset.getString("link"));
                counter++;
            }

            counter = 0;
            String ingredientsQuery = "select name, unit from ingredients"; //query for ingredient name and unit for outputting ingredients for each object
            rset = statement.executeQuery(ingredientsQuery);
            while (rset.next()) {
                ingredientsUnitName[counter][0] = rset.getString("name");
                ingredientsUnitName[counter][1] = rset.getString("unit");
                counter++;
            }

            //set size of individual recipe object arrays
            for (int i = 1; i <= recipe.length; i++) {
                rset = statement.executeQuery("select count(idingredient) from recipe_ingredient where idrecipe = " + i);
                recipe[i-1].setArraySize(rset.getInt("count(idingredient)"));
                recipe[i-1].setIngredientsID(new int[recipe[i-1].getArraySize()]);       //declare size of their arrays
                recipe[i-1].setIngredientsAmount(new double[recipe[i-1].getArraySize()]); //declare size of their arrays
            }

            //intialize data in the recipe object arrays
            for (int i = 1; i <= recipe.length; i++) {
                counter = 0;
                rset = statement.executeQuery("select idingredient, amount from recipe_ingredient where idrecipe = " + i);
                while (rset.next()){
                    recipe[i - 1].ingredientsID[counter] = rset.getInt("idingredient");
                    recipe[i - 1].ingredientAmount[counter] = rset.getDouble("amount");
                    counter++;
                }
            }

            //how to output the information from each object, this shows object in index 1 as example. just change recipe[index] for different object.
            System.out.println(recipe[1].getName() + "\t\t" + recipe[1].getAmountFed() + "\t\t" + recipe[1].getWebAddress());
            for (int i = 0; i < recipe[1].getArraySize(); i++) {
                System.out.println(recipe[1].ingredientAmount[i] + "\t" + ingredientsUnitName[i][1] + "\t" + ingredientsUnitName[i][0]);
            }

            /*while(rset.next()) {   // process each row
                String name = rset.getString("name");      // get name of ingredient
                double amount = rset.getDouble("amount");  // get amount of ingredient used in recipe
                String unit = rset.getString("unit");      // get unit of measurement for ingredient
                System.out.printf("%10.2f%10s%30s%n", amount, unit, name);
            }*/

/*            /////////////////////////////////////////////////////
            // functionality ideas for user searching database //
            /////////////////////////////////////////////////////
            //every time event on search bar happens
            //clear database results that may be shown
            //loop though array of ingredients
            //check if userinput.containsIgnoreCase(ingredients[i])
            //if it does use i+1 in query search -> database starts at 1
            //this example uses chicken which would is idingredient 14 as shown in ingredient table
            String searchRecipes = "select R.name from recipes R inner join recipe_ingredient R2I" +
                    " on R.idRecipes = R2I.idrecipe where R2I.idingredient = 14";

            rset = statement.executeQuery(searchRecipes);

            while(rset.next()) {   // process each row
                String name = rset.getString("name");      // get name of recipe
                System.out.println("\n" + name + "\n");
            }*/



/*            ////////////////////////////////////
            //To see all data in recipes table//
            ////////////////////////////////////
            String queryRecipeData = "select * from recipes";
            System.out.println("\nData from recipes table");
            System.out.printf("%5s%20s%20s%50s%n", "ID", "NAME", "serving size" , " link");
            rset = statement.executeQuery(queryRecipeData);

            while(rset.next()) {   // process each row
                int idRecipe = rset.getInt("idRecipes");
                String recipeName = rset.getString("name");
                int amountFed = rset.getInt("amountFed");
                String urlLink = rset.getString("link");
                System.out.printf("%5d%30s%5d%80s%n",idRecipe, recipeName, amountFed, urlLink);
            }

            ////////////////////////////////////
            //To see all data in ingredients table//
            ////////////////////////////////////
            String queryIngredientsData = "select * from ingredients";
            System.out.println("\nData from ingredients table");
            System.out.printf("%5s%30s%20s%n", "ID", "NAME", "measurement unit");
            rset = statement.executeQuery(queryIngredientsData);

            while(rset.next()) {   // process each row
                int idIngredients = rset.getInt("idIngredients");
                String ingredientName = rset.getString("name");
                String unit = rset.getString("unit");
                System.out.printf("%5d%30s%20s%n",idIngredients, ingredientName, unit);
            }

            //////////////////////////////////////////////
            //To see all data in recipe_ingredient table//
            //////////////////////////////////////////////
            String queryJoinedTableData = "select * from recipe_ingredient";
            System.out.println("\nData from recipe_ingredient table");
            System.out.printf("%5s%12s%15s%30s%n", "ID", "recipeID", "ingredientID" , "amount of ingredient");
            rset = statement.executeQuery(queryJoinedTableData);

            while(rset.next()) {   // process each row
                int idRecipeIngredient = rset.getInt("idrecipe_ingredient");
                int idRecipes = rset.getInt("idrecipe");
                int idIngredients = rset.getInt("idingredient");
                double amount = rset.getDouble("amount");

                System.out.printf("%5d%10d%10d%20.2f%n", idRecipeIngredient, idRecipes, idIngredients, amount);
            }*/

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
class Recipe {

    int[] ingredientsID;
    double[] ingredientAmount;
    int arraySize;
    String name;
    String webAddress;
    int amountFed;

    public Recipe(String name, int amountFed, String link) {
        this.name = name;
        this.webAddress = link;
        this.amountFed = amountFed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public void setAmountFed(int amountFed) {
        this.amountFed = amountFed;
    }

    public void setIngredientsID(int[] ingredientsID) {
        this.ingredientsID = ingredientsID;
    }

    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }

    public void setIngredientsAmount(double[] ingredientsAmount) {
        this.ingredientAmount = ingredientsAmount;
    }

    public double[] getIngredientsAmount() {
        return ingredientAmount;
    }

    public int[] getIngredientsID() {
        return ingredientsID;
    }

    public String getName() {
        return name;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public int getAmountFed() {
        return amountFed;
    }

    public int getArraySize() {
        return arraySize;
    }
}