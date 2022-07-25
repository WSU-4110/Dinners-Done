import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RecipeBuilder {

    public String name;
    public String author;
    public String webAddress;
    public String description;

    public String[] ingredients;

    public void setName(String name) {

        this.name = name;
    }

    public void setAuthor(String author) {

        this.author = author;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public void setWebAddress(String webAddress) {

        this.webAddress = webAddress;
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
            ((Statement) s).executeUpdate("INSERT INTO RECIPE " +
                    "NAME" + this.name + ",AUTHOR " + this.author + ", URL " + this.webAddress + ", description " + this.description + ", ingredients " + this.ingredients);

        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}