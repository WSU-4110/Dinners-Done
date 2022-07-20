import static org.junit.jupiter.api.Assertions.*;

class JUnitTestingTest {
    private JUnitTestingTest testobj;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        testobj = new JUnitTestingTest();
    }
    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        testobj = null;
    }
    @org.junit.jupiter.api.Test

    void addRecipe() {
        JUnitTesting addrec = new JUnitTesting();
        String recipe1 = "Salmon", recipe2 = "Shrimp";
        assertEquals(recipe1.concat(recipe2), addrec.addRecipe(recipe1, recipe2));
    }
    @org.junit.jupiter.api.Test
     void recipeSub() {
        JUnitTesting addrec = new JUnitTesting();
        int rec3 = 50;
        int rec4 = 100;
        int sum = rec3 - rec4;
        assertEquals(sum, addrec.recipeSub(rec3,rec4));

    }

    @org.junit.jupiter.api.Test
    void recipeCalc() {
        JUnitTesting addrec = new JUnitTesting();
        int recipe1 = 10, recipe2 = 5;
        assertEquals(recipe1+recipe2,addrec.recipeCalc(recipe1,recipe2));
    }

    @org.junit.jupiter.api.Test
    void recipeMinus() {
        JUnitTesting addrec = new JUnitTesting();
        int rec1 = 80;
        int rec2 = 100;
        assertEquals(rec1-rec2,addrec.recipeSub(rec1,rec2));
    }

    @org.junit.jupiter.api.Test
    void foodType(){
        JUnitTesting addrec = new JUnitTesting();
        String recipe1 = "Mac & Cheese";
        String recipe2 = "Fries";
        assertEquals(recipe1!=recipe2,addrec.foodType(recipe1,recipe2));
    }
    @org.junit.jupiter.api.Test
    void cookTime(){
        JUnitTesting cookTime = new JUnitTesting();
        int cookingTime = 40;
        int purchaseTime = 40;
        assertEquals(cookingTime==purchaseTime,cookTime.cookTime(cookingTime,purchaseTime));
    }
    @org.junit.jupiter.api.Test
    void buttonClick(){
        JUnitTesting buttonClicked = new JUnitTesting();
        int buttonClick = 2;
        assertEquals(buttonClick>1,buttonClicked.buttonClicked(2));
    }

}