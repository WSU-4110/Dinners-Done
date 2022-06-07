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

    //following code adds to existing quantity of an ingredient
    public void addToIngredientList(String newIngredient, int newQuantity) {
        for(int i = 0; i < ingredientList.length; i++){
            if(newIngredient == ingredientList[i]){
                quantityList[i] += newQuantity;
            }
        }
    }
}
