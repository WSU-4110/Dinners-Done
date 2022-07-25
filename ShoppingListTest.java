package CSC4100Project;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShoppingListTest {
    @Test
    public void getName()
    {
        ShoppingListIngredient a = new ShoppingListIngredient("a", 1, "a");
        assertEquals("a", a.getName());
    }
    @Test
    public void setName()
    {
        ShoppingListIngredient a = new ShoppingListIngredient("a", 1, "a");
        a.setName("b");
        assertEquals("b", a.getName());
    }
    @Test
    public void getAmount()
    {
        ShoppingListIngredient a = new ShoppingListIngredient("a", 1, "a");
        assertEquals(1, a.getAmount());
    }
    @Test
    public  void setAmount()
    {
        ShoppingListIngredient a = new ShoppingListIngredient("a", 1, "a");
        a.setAmount(2);
        assertEquals(2, a.getAmount());
    }
    @Test
    public void getUnit()
    {
        ShoppingListIngredient a = new ShoppingListIngredient("a", 1, "a");
        assertEquals("a", a.getUnit());
    }
    @Test
    public  void setUnit()
    {
        ShoppingListIngredient a = new ShoppingListIngredient("a", 1, "a");
        a.setUnit("c");
        assertEquals("c", a.getUnit());
    }
}
