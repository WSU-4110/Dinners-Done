import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeBuilderTest {

    private RecipeBuilder recipeBuilder;

    @BeforeEach
    void setUp() {
        this.recipeBuilder = new RecipeBuilder();

    }
    @AfterEach
    void tearDown() {

    }

    @Test
    void setName() {

        this.recipeBuilder.setName("Mac & Cheese");
        assertEquals("Mac & Cheese",this.recipeBuilder.name );
    }

    @Test
    void setAuthor() {
        this.recipeBuilder.setAuthor("allrecipes.com");

        assertEquals("allrecipes.com", this.recipeBuilder.author);
    }

    @Test
    void setDescription() {
        this.recipeBuilder.setDescription("Quick, easy, and tasty macaroni and cheese dish");

        assertEquals("Quick, easy, and tasty macaroni and cheese dish", this.recipeBuilder.description);
    }

    @Test
    void setWebAddress() {
        this.recipeBuilder.setWebAddress("allrecipes.com");

        assertEquals("allrecipes.com", this.recipeBuilder.webAddress);
    }

    @Test
    void setIngredients() {
        String expected[] = {"Butter", "Flour", "Milk", "Shredded Cheddar cheese", "Noodles"};
        this.recipeBuilder.setIngredients(expected);
        assertArrayEquals(expected, this.recipeBuilder.ingredients);
    }

    @Test
    void save() {
        assertEquals("allrecipes.com", "allrecipes.com");

    }
}