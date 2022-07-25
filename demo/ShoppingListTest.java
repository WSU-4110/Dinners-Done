package demo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShoppingListTest {

    @Test
    public void getName()
    {
        ShoppingListIngredient a = new ShoppingListIngredient();
        assertEquals("a", a.getName() );
    }
}
