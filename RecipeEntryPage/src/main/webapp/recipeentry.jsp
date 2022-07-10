<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Dinners Done</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="index.js"> </script>

</head>
<body>
    
<script type="text/javaScript">
function SaveRecipe() {
    var RecipeName = document.getElementById("RecipeName").value;
    var RecipeAuthor = document.getElementById("RecipeAuthor").value;
    var RecipeUrl = document.getElementById("RecipeUrl").value;
    var Recipe = document.getElementById("Recipe").value;

    alert("Recipe Name: " + RecipeName + "\nRecipe Author: " + RecipeAuthor + "\nRecipe Url: " + RecipeUrl + "\nRecipe Instructions: \n" + Recipe);
}
</script>
    <nav class="menu">
        <input type="checkbox" id="toggle-bar">
        <label for="toggle-bar" class='btn'>
            <i class="fa fa-bars"></i>
        </label>
        
        <ul>
            <li class="nav"> <a href="index.html">Home</a></li>
            <li class="nav"> <a href="recipes.html">Recipes</a></li>
            <li class="nav"> <a href="login.html">Login</a></li>
            <li class="nav"> <a href="signup.html">SignUp</a></li>
            <li class="nav"> <a class="active" href="recipeEntryPage.html">Recipe Entry</a></li>
        </ul>
    </nav>

 
    <section>
        <div class="content1">
            <form id="form" onsubmit="return false">
                <div class="form-group">
                    <label for="RecipeName">Recipe Name<br></label>
                    <input type="text1" class="form-control" id="RecipeName" placeholder="Enter name">
                </div>
                
                <div class="form-group">
                    <label for="RecipeAuthor">Recipe Author<br></label>
                    <input type="text1" class="form-control" id="RecipeAuthor" placeholder="Enter Recipe Author">
                </div>
                
                <div class="form-group">
                    <label for="RecipeUrl">Recipe Url<br></label>
                    <input type="text1" class="form-control" id="RecipeUrl" placeholder="Enter Recipe Url">
                </div>

                <div class="row">
                    <div class="form-group">
                        <label for="Ingredients">Ingredients<br></label>
                                <div class="col-xs-6">
                                    <select name="Ingredients" id="ingre">
                                        <option value="test1">${ingre.ingredientsID}</option>
                                    </select>
                                </div>

                                <div class="col-xs-6">
                                    <input type="text1" class="form-control" id="amount" placeholder="Enter amount">
                                </div>   

                                <div class="col-xs-6">
                                    <select name="unit" id="unit">
                                        <option value="test1">${ingre.ingredientAmount}</option>

                                    </select>
                                </div>
                    </div>                   
                </div> 
                
                <div class="form-group">
                    <label for="Recipe">Recipe Notes<br></label>
                    <textarea name="textarea" id="Recipe" rows="10" cols="40"></textarea>

                    <input type="submit" onclick="SaveRecipe();">
                </div>
                
               
                    
               

            </form>
            </div>
    </section>
</body>