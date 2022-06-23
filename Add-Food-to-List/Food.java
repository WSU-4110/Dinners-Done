public class Food {
	
   public static FoodOption getFood(String foodType){
    if(foodType == null){
       return null;
    }		
    if(foodType.equalsIgnoreCase("Chicken")){
       return new chicken();
       
    } else if(foodType.equalsIgnoreCase("Shrimp")){
       return new Shrimp();
       
    } else if(foodType.equalsIgnoreCase("Porkchops")){
       return new porkchops();

    } else if(foodType.equalsIgnoreCase("pasta")){
      return new pasta();
   }
    
    return null;
 }
}