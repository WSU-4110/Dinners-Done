import java.sql.*;
import java.util.Scanner;


public class ProjectMain {
    public static void main(String[] args) {
        MakeRecipe MR = new MakeRecipe();
        Recipe recipe = MR.buildRecipe(new OurDatabaseRecipeBuilder());
        String url = "jdbc:sqlite:src/main/resources/RecipesDB.db"; //path from content root
        try {
            // query that shows records needed from each recipe, this example uses recipe 3 as seen in R2I.idrecipe = 3"
            String query = "select I.name, I.unit, amount from ingredients I inner join recipe_ingredient R2I" +
                    " on I.idingredients = R2I.idingredient where R2I.idrecipe = 3";
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            ResultSet rset = statement.executeQuery(query);

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
    String name;
    int amountFed;
    final String userAdded = "y";
    int[] unitOfMeasurement;
    double amountOfIngredient;
    int[] ingredients;

    public void setName(String name) {
        this.name = name;
    }

    public void setAmountFed(int amountFed) {
        this.amountFed = amountFed;
    }

    public void setIngredient(int[] ingredient) {
        this.ingredients = ingredient;
    }

    public void setAmountOfIngredient(double amountOfIngredient) {
        this.amountOfIngredient = amountOfIngredient;
    }

}

abstract class RecipeBuilder {
    protected Recipe recipe = new Recipe();

    public Recipe getRecipe() {
        return recipe;
    }

    public abstract void buildName();
    public abstract void buildAmountFed();
    public abstract void buildIngredient();
    public abstract void buildAmountOfIngredient();
}

class OurDatabaseRecipeBuilder extends RecipeBuilder { //for user to build a recipe with our ingredients
    Scanner scanner = new Scanner(System.in);
    @Override
    public void buildName() {
        String userInputName = scanner.nextLine();	//user input for name
        recipe.setName(userInputName);
    }

    @Override
    public void buildAmountFed() {
        int userInputAmountFed = scanner.nextInt();	//user input for serving size
        recipe.setAmountFed(userInputAmountFed); //the int will be user input for how many people the meal feeds
    }


    @Override
    public void buildIngredient() {
        int userInputNumIngredients = scanner.nextInt();	//get number of ingredients user will be adding
        int ingredients[] = new int[userInputNumIngredients];
        for (int i = 0; i < ingredients.length; i++) {
            ingredients[i] = scanner.nextInt();				//get the ingredient id from user
        }
        recipe.setIngredient(ingredients);
    }


    @Override
    public void buildAmountOfIngredient() {
        double userInputAmountIngredient = scanner.nextDouble();	//get number of ingredients user will be adding
        recipe.setAmountOfIngredient(userInputAmountIngredient); //the int will be how much the user wants to add of that ingredient
    }
}

class NewIngredientRecipeBuiler extends RecipeBuilder { //for user to build a recipe with ingredients they add
    Scanner scanner = new Scanner(System.in);
    @Override
    public void buildName() {
        String userInputName = scanner.nextLine();	//user input for name
        recipe.setName(userInputName);
    }

    @Override
    public void buildAmountFed() {
        int userInputAmountFed = scanner.nextInt();	//user input for serving size
        recipe.setAmountFed(userInputAmountFed); //the int will be user input for how many people the meal feeds
    }


    @Override
    public void buildIngredient() {
        PreparedStatement prep;
        int userInputArraySize = scanner.nextInt();	//user input for how many ingredients he will add
        int[] ingredients = new int[userInputArraySize];
        String ingredientName;
        String unitOfMeasurement;
        Connection connection = null;
        ResultSet rset;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/RecipesDB.db");
            Statement statement = connection.createStatement();
            ingredientName = scanner.next();
            unitOfMeasurement = scanner.next();
            for (int i = 0; i < userInputArraySize; i++) {
                prep = connection.prepareStatement("insert into ingredients values (" +ingredientName + ", " + unitOfMeasurement + ")", Statement.RETURN_GENERATED_KEYS);
                rset = prep.getGeneratedKeys();
                ingredients[i] = rset.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        recipe.setIngredient(ingredients);
    }


    @Override
    public void buildAmountOfIngredient() {
        double userInputAmountIngredient = 0;
        int userInputSize = scanner.nextInt();	//user input for how many ingredients did you add
        for (int i = 0; i < userInputSize; i++) {
            userInputAmountIngredient = scanner.nextDouble();	//get number of ingredients user will be adding
        }
        recipe.setAmountOfIngredient(userInputAmountIngredient); //the int will be how much the user wants to add of that ingredient
    }
}

class MakeRecipe {

    public Recipe buildRecipe(RecipeBuilder builder) {
        builder.buildName();
        builder.buildAmountFed();
        builder.buildIngredient();
        builder.buildAmountOfIngredient();
        return builder.getRecipe();
    }
}
