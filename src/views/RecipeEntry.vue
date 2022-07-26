<template>
        <div class="content1">
            <form v-on:submit.prevent="addRecipe">
                <div class="form-group">
                    <label for="RecipeName">Recipe Name<br></label>
                    <input type="text1" class="form-control" id="RecipeName" v-model="newRecipe.RecipeName" placeholder="Enter name">
                </div>
                
                <div class="form-group">
                    <label for="RecipeAuthor">Recipe Author<br></label>
                    <input type="text1" class="form-control" v-model="newRecipe.RecipeAuthor" id="RecipeAuthor" placeholder="Enter Recipe Author">
                </div>
                
                <div class="form-group">
                    <label for="RecipeUrl">Recipe Url<br></label>
                    <input type="text1" class="form-control" v-model="newRecipe.RecipeUrl" id="RecipeUrl" placeholder="Enter Recipe Url">
                </div>

                <div class="form-group">
                    <label for="Recipe">Recipe Notes<br></label>
                    <textarea name="textarea" id="Recipe" rows="10" cols="40" v-model="newRecipe.RecipeNotes"></textarea>
                    <input type="submit" value="Add Recipe">
                </div>    

            </form>
        </div>
</template>


<script>

import {db} from "@/main";

export default {
  data() {
    return {
      newRecipe: {
        RecipeName: '',
        RecipeAuthor: '',
        RecipeUrl: '',
        RecipeNotes: ''
      }
    }
  },
  methods: {
    addRecipe() {
      db.collection('recipeentry').add({
        RecipeName: this.newRecipe.RecipeName,
        RecipeAuthor: this.newRecipe.RecipeAuthor,
        RecipeUrl: this.newRecipe.RecipeUrl,
        RecipeNotes: this.newRecipe.RecipeNotes
      })
      this.newRecipe.RecipeName = '';
      this.newRecipe.RecipeAuthor = '';
      this.newRecipe.RecipeUrl = '';
      this.newRecipe.RecipeNotes = '';
      alert("Successfully added")
      
    }
  }

}

</script>



