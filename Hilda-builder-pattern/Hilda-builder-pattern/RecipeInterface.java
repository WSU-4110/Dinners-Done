package DD;

public interface RecipeInterface {

    void setName(string name);
    void setAuthor(String author);
    void setWebAddress(String webAddress);
    void setIngredients(String[] ingredients);
    void save();
}
