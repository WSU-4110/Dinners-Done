public class FoodD {

    public static void main(String[] args) {
       Food foodOptions = new ShapeFactory();
 
 
       Food food1 = foodOptions.getFood("Chicken");
 

       Food food2 = foodOptions.getFood("Shrimp");
 

       Food food3 = foodOptions.getFood("PorkChops");

       Food food4 = foodOptions.getFood("Pasta");
    }
 }