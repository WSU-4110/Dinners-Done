public class Food {

   public FoodOption getFood(String foodType) {
      if (foodType == null) {
         return null;
      }
      if (foodType.equalsIgnoreCase("Chicken")) {
         return new chicken();

      } else if (foodType.equalsIgnoreCase("Shrimp")) {
         return new shrimp();

      } else if (foodType.equalsIgnoreCase("Porkchops")) {
         return new porkchops();

      } else if (foodType.equalsIgnoreCase("pasta")) {
         return new pasta();
      }

      return null;
   }
}