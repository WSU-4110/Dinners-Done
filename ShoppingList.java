package DD;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingList {

    private DataSource dataSource;

    public ShoppingList(DataSource dataSource) {

        this.dataSource = dataSource;
    }

    public List<ShoppingListIngredient> getShoppingListIngedients() throws SQLException {
        List<String> idRecipes = new ArrayList<String>();
        List<String> idIngredients = new ArrayList<String>();
        List<DD.ShoppingListIngredient>  shoppingListIngredients = new ArrayList<DD.ShoppingListIngredient>();
        List<Integer> ingredientAmounts = new ArrayList<Integer>();
        List<String> ingredientNames = new ArrayList<String>();

        Connection connection = dataSource.getConnection();

        try{
            PreparedStatement pst = connection.prepareStatement("SELECT idRecipes FROM recipes"); //selects from table recipes
            ResultSet rs = pst.executeQuery();

            while(rs.next() ) {
                idRecipes.add(rs.getString("idRecipes"));
            }

            for (String id : idRecipes){ //loop over list to get idIngredient and amount
                PreparedStatement pst_ingredient = connection.prepareStatement("SELECT idIngredient, amount FROM recipe_ingredient WHERE idRecipe=" + id); //selects ingredient ID and amount where idRecipe equals id
                ResultSet rs_ingredient = pst_ingredient.executeQuery();

                while(rs.next()) {
                    idIngredients.add(rs_ingredient.getString("idIngredient")); //add ingredient to list
                    ingredientAmounts.add(rs_ingredient.getInt("amount")); //add ingredient amount to list
                }
            }

            for (String id : idIngredients){ //loop over list to get ingredient name and unit
                PreparedStatement pst_ingredientname = connection.prepareStatement("SELECT name FROM ingredients WHERE idIngredients=" + id); //selects name and unit where idIngredients equals id
                ResultSet rs_ingredientname = pst_ingredientname.executeQuery();

                while(rs.next()) {
                    ingredientNames.add(rs_ingredientname.getString("name")); //add ingredient name to list
                }
            }

            for(int i =0; i > ingredientNames.size(); i++){ //loops through the list to get name and amount to add in same row

                String name = ingredientNames.get(i);
                int amount = ingredientAmounts.get(i);
                ShoppingListIngredient list = ShoppingListIngredient();
                list.setName(name);
                list.setAmount(amount);

                shoppingListIngredients.add(list);
            }


        }finally {
            connection.close();

        }

        return shoppingListIngredients;
    }

}
