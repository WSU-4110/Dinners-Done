public class Recipe {

      //name, address, webAddress need to be linked to recipe db

    String name;
    String author;
    String webAddress;

    String[] ingredients;  //TODO: set array to recipe list number

                //constructor for recipe that has link
    public Recipe(String name, String author, String webAddress, String[] ingredients) {
        this.name = name;
        this.author = author;
        this.webAddress = webAddress;
        this.ingredients = ingredients;
    }
              //constructor for recipe that is personally added
    public Recipe(String name, String author, String[] ingredients) {
        this.name = name;
        this.author = author;
        this.ingredients = ingredients;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getWebAddress() {
        return webAddress;
    }
       //link to db and add ingredients from db into array
    public String[] getIngredients() {
        return ingredients;
    }

}
