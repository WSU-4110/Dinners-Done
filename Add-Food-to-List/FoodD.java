public class FoodD {

    public static void main(String[] args) {
       Food foodOptions = new Food();
 
 
       FoodOption food1 = Food.getFood("Chicken");
       food1.food();

       FoodOption food2 = foodOptions.getFood("Shrimp");
       food2.food();

       FoodOption food3 =  foodOptions.getFood("PorkChops");
       food3.food();

       FoodOption food4 = foodOptions.getFood("Pasta");
       food4.food();
    }
 }