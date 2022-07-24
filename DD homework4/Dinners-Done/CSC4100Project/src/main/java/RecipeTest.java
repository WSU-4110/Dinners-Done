import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {
    Recipe R = new Recipe();

    @Test
    void setUserAdded() {
        R.setUserAdded("yes");
        String expected = "yes";
        assertEquals(expected, R.userAdded);

        //test for failure
        expected = "y";
        assertNotEquals(expected, R.userAdded);
    }

    @Test
    void setUnitOfMeasurement() {
        int[] values = {0,4,6,9};
        R.setUnitOfMeasurement(values);
        int[] expected = values;
        assertEquals(expected, R.unitOfMeasurement);

        //test for failure
        int[] failVals = {1,1,1,1};
        expected = failVals;
        assertNotEquals(expected, R.userAdded);
    }

    @Test
    void setName() {
        R.setName("Pasta");
        String expected = "Pasta";
        assertEquals(expected, R.name);

        //test for failure
        expected = "Spaghetti";
        assertNotEquals(expected, R.userAdded);
    }

    @Test
    void setAmountFed() {
        R.setName("Pasta");
        String expected = "Pasta";
        assertEquals(expected, R.name);

        //test for failure
        expected = "Spaghetti";
        assertNotEquals(expected, R.userAdded);
    }

    @Test
    void setIngredient() {
        int[] values = {1,5,7,8};
        R.setIngredient(values);
        int[] expected = values;
        assertEquals(expected, R.ingredients);

        //test for failure
        int[] failVals = {1,1,1,1};
        expected = failVals;
        assertNotEquals(expected, R.userAdded);
    }

    @Test
    void setAmountOfIngredient() {
        R.setAmountOfIngredient(3.0);
        double expected = 3.0;
        assertEquals(expected, R.amountOfIngredient);

        //test for failure
        expected = 4.5;
        assertNotEquals(expected, R.amountOfIngredient);
    }


    @Test
    void testSetUserAdded(){}

    @Test
    void testSetUnitOfMeasurement(){}

    @Test
    void testSetName(){}

    @Test
    void testSetAmountFed(){}

    @Test
    void testSetIngredient(){}

    @Test
    void testSetAmountOfIngredient(){}
}