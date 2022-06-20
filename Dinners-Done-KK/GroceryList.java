import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class GroceryList {

             //temp set array lists to 30

    String[] ingredientList = new String[30];
    int [] quantityList = new int[30];
    String[] unitList = new String[30];

      /* Loop through the list of quantities only.  If the quantity is not 0,
      prints out all information of that ingredient.  If 0, not needed, so omit.
       */
    public void displayList(int[] quantityList) {
        System.out.println("Ingredient " + "\tQuantity " + "\tUnits");
        System.out.println("");
        for (int i = 0; i < quantityList.length; i++) {
            if (quantityList[i] != 0) {
                System.out.println(ingredientList[i] +
                        "\t" + quantityList[i] +
                        "\t" + unitList[i]);
            }
        } //TODO:  add a print option to site that takes display and prints to outside source
    }
               //should only be used on the first implementation
    public GroceryList(String[] ingredientList, int[] quantityList, String[] unitList) {
        this.ingredientList = ingredientList;
        this.quantityList = quantityList;
        this.unitList = unitList;
    }

    public void setIngredientList(String[] ingredientList) {
        this.ingredientList = ingredientList;
    }

    public void setQuantityList(int[] quantityList) {
        this.quantityList = quantityList;
    }

    public void setUnitList(String[] unitList) {
        this.unitList = unitList;
    }

    public String[] getIngredientList() {
        return ingredientList;
    }

    public int[] getQuantityList() {
        return quantityList;
    }

    public String[] getUnitList() {
        return unitList;
    }
              //TODO:  connect to website input info (boxes)
    public void getInfoToAddToMainList(Connection c) throws SQLException {
             //TODO:  change the query to match recipe db table row names
        String query = "select INGREDIENT, QUANTITY, UNIT from RECIPES";
        try (Statement s = c.createStatement() ) {
            ResultSet r = s.executeQuery(query);
                  /*to allow for multiples of the same recipe, use code below and
                    add loop to multiply the addToIngredient list by the multiple
                   */
            while(r.next() ){
                String newIngredient = r.getString("INGREDIENT");
                int newQuantity = r.getInt("QUANTITY");
                addToIngredientList(newIngredient, newQuantity);
            }
                       //TODO:  Fix SQLException (JDBC research needed)
        } /*catch (SQLException ex) {
            JDBCTutorialUtilities.printSQLException(ex);
        } */catch (Exception ex2) {
            ex2.printStackTrace(System.err);
        }
    }

    //following code adds to existing quantity of an ingredient
    public void addToIngredientList(String newIngredient, int newQuantity) {
        for(int i = 0; i < ingredientList.length; i++){
            if(newIngredient == ingredientList[i]){
                quantityList[i] += newQuantity;
            }
        }
    }

}
