public class JUnitTesting {
    public static String addRecipe(String recipe1, String recipe2){
        return recipe1 + recipe2;
    }

    public static int recipeCalc(int rec1, int rec2){
        int sum = rec1 + rec2;
        return sum;
    }

    public static int recipeSub(int rec3, int rec4){
        int minusSum = rec3 - rec4;
        return minusSum;
    }

    public static boolean foodType(String recipe1, String recipe2){
        if(recipe1.equals(recipe2)){
            return false;
        }
        return true;
    }

    public static boolean cookTime(int cookingTime, int purchaseTime){
        if(cookingTime == purchaseTime){
            return true;
        }
        return false;
    }
    public static boolean buttonClicked(int click){
        click = 2;
        if(click >= 1){
            return true;
        }
        return false;
    }

}
