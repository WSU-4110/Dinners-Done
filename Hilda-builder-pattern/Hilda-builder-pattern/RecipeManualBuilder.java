package DD;

import RecipeManualBuilder;

public class RecipeBuilder Implements RecipeInterface {

    String name;
    String author;
    String description;

    public void setName(string name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }
    public void save() {
        try {
            Connection connection;
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/DinnersDone";
            connection = DriverManager.getConnection(url, "UserName", "Password");

            Statement s = connection.createStatement();
            s.executeUpdate("INSERT INTO RECIPE " +
                    "NAME"  + this.name + ",AUTHOR +" this.author + ", description "+ this.description + ", ingredeients " + this.ingredients);

        } catch (Exception e) {
            e.printStackTrace();

        }

    }