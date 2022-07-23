<template>
  <div class="">
    <section>
      <div class="box">
        <div class="rbox" v-for="recipe in recipes" v-bind:key="recipe.id">
          <a :href="recipe.link">
            <img class="recipe-img" :src="recipe.image" >
            <br>
            <div class="recipe-name">{{recipe.name}}</div>
            <br>
          </a>
        </div>
      </div>

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

                <div class="form-group">
                    <label for="Recipe">Recipe Notes<br></label>
                    <textarea name="textarea" id="Recipe" rows="10" cols="40"></textarea>
                    <input type="submit">
                </div>    

            </form>
        </div>
    </section>
</div>
</template> 