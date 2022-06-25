import java.sql.*;

public class ProjectMain {
    public static void main(String[] args) {


        String url = "jdbc:sqlite:CSC4100Project/src/main/resources/RecipesDB.db"; //path from content root
        try {


            //QUERY FOR WHEN USER FAVORITES RECIPE
            //INSERT INTO user_recipe(idRecipes, idUser)
            //VALUES(RECIPE ID THAT THEY CLICKED, USER ID);

            //QUERY FOR WHEN USER UNFAVORITES RECIPE
            //delete from user_recipe
            //where idRecipes = RECIPE ID THAT THEY CLICKED and idUser = USER ID;

            //QUERY TO SHOW USER THEIR FAVORITES
            //select R.name from recipes R inner join user_recipe U2R on
            //R.idRecipes = U2R.idRecipes where U2R.idUser = USER ID;

            //QUERY TO INSERT NEW RECIPE INTO TABLE
            //INSERT INTO recipes(name, amountFed, link,userAdded,userIdThatAdded)
            //VALUES("MEAL NAME", AMOUNT FED, "LINK", 'y', USER ID);

            //QUERY TO DELETE RECIPE THEY CREATED FROM TABLE
            //delete from recipes
            //where name = "MEAL NAME";

            //QUERY TO SHOW USER THE RECIPES THAT THEY CREATED
            //select name from recipes where userIdThatAdded = 2;


            // query that shows records needed from each recipe, this example uses recipe 3 as seen in R2I.idrecipe = 3"
            String query = "select I.name, I.unit, amount from ingredients I inner join recipe_ingredient R2I" +
                    " on I.idingredients = R2I.idingredient where R2I.idrecipe = 3";

            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();

            ResultSet rset = statement.executeQuery(query);


/*            while(rset.next()) {   // process each row
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



            ////////////////////////////////////
            //To see all data in recipes table//
            ////////////////////////////////////
            String queryRecipeData = "select * from recipes";
            System.out.println("\nData from recipes table");
            System.out.printf("%5s%20s%20s%50s%%15s%10sn", "ID", "NAME", "serving size" , " link", "userAdded", "userThatAdded");
            rset = statement.executeQuery(queryRecipeData);

            while(rset.next()) {   // process each row
                int idRecipe = rset.getInt("idRecipes");
                String recipeName = rset.getString("name");
                int amountFed = rset.getInt("amountFed");
                String urlLink = rset.getString("link");
                String userAdded = rset.getString("userAdded");
                int userIdThatAdded = rset.getInt("userIdThatAdded");
                System.out.printf("%5d%35s%5d%80s%5s%10d%n",idRecipe, recipeName, amountFed, urlLink, userAdded, userIdThatAdded);
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
            }

            //////////////////////////////////////////////
            //To see all data in user_recipe table//        -- there is none until users add
            //////////////////////////////////////////////
            String queryUserJoinedTableData = "select * from user_recipe";
            System.out.println("\nData from user_recipe table");
            System.out.printf("%5s%12s%15s%n", "ID", "recipeID", "userId");
            rset = statement.executeQuery(queryUserJoinedTableData);

            while(rset.next()) {   // process each row
                int idUserRecipe = rset.getInt("idUserRecipes");
                int idRecipes = rset.getInt("idRecipes");
                int idUser = rset.getInt("idUser");

                System.out.printf("%5d%10d%15d%n", idUserRecipe, idRecipes, idUser);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
