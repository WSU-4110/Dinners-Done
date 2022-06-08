function SaveRecipe() {
    var RecipeName = document.getElementById("RecipeName").value;
    var RecipeAuthor = document.getElementById("RecipeAuthor").value;
    var RecipeUrl = document.getElementById("RecipeUrl").value;
    var Recipe = document.getElementById("Recipe").value;

    alert("Recipe Name: " + RecipeName + "\nRecipe Author: " + RecipeAuthor + "\nRecipe Url: " + RecipeUrl + "\nRecipe Instructions: \n" + Recipe);
}