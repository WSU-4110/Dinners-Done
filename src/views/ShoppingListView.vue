<template>
  <div class="">
    <section>
      <div class="box">
        <div class="rbox" v-for="recipe in ShoppingList" v-bind:key="recipe.id">
          <a :href="recipe.data().link">
            <div class="recipe-name">{{recipe.data().name}}</div>
            <br>
          </a>

            <div class="recipe-name">
            <br>
              <b>Ingredients:</b>
              <ul v-for="ingredient in recipe.data().ingredients" v-bind:key="ingredient.name + ingredient.size">
                <li style="display: block; color: black"> Name: {{ingredient.name }}</li>
                <li style="display: block; color: black">Amount: {{ingredient.amount }}</li>
                <li style="display: block; color: black">Size: {{ingredient.unit }} <br></li>
                <div style="height: 10px; display: block"></div>
              </ul>
            </div>
          <div>
            <button type="button" class="shopbtn" @click="onclick(recipe.id)">Remove</button>
          </div>
        </div>
      </div>
      <div class="iboxes">
        <h1>Shopping List:</h1>
        <div v-for="([name, unitAmountList], key) in IngredientsList" :key="key">
        <h2 align="left">{{name}}</h2>
        <li align="left" v-for="([unit, amount], key) in unitAmountList" :key="key">
          {{amount}}
          {{unit}}
        </li>
        </div>
      </div>
    </section>
  </div>
</template>




<script>
import {db} from "@/main";
import firebase from "firebase/compat/app";

export default {
    firestore: {
        ShoppingList: db.collection('shoppinglist')
    },
    data() {
        return {
            ShoppingList: [],
            IngredientsList: Map
        }
    },
    methods: {
    back() {
      location.reload();
    },
    //create a button to remove recipes from shopping list
    async onclick(recipeIdtoRemove) {
            
    let shoppingListId;
    
    //get favorites id
    let usersShoppingLists = (await db.collection('shoppingLists').get()).docs;
    
    //get current user id
    const loggedInUsersId = firebase.auth().currentUser.uid;

    //get shoppingLists id from user and match with current user
    usersShoppingLists.forEach(doc => {
    if (doc.data().userId === loggedInUsersId) {
    shoppingListId = doc.id 
    }
    })
    
    let recipeids = []

    await db.collection('shoppingLists')
    .doc(shoppingListId)
    .get()
    .then (querySnapshot => {
    querySnapshot.data().recipeIds.forEach(id => {
    //if recipe id does not match dont push it
        if (recipeIdtoRemove != id) {
            recipeids.push(id)
          }
        })
    })

    //update recipes in favorites collection
    await db.collection('shoppingLists')
    .doc(shoppingListId)
    .update({
        recipeIds: recipeids
     })

      //reload page when recipe is removed
      window.location.reload()

    }
        
    },
    async created() {
      // get all documents in the shoppingLists table
      let usersShoppingLists = (await db.collection('shoppingLists').get()).docs;

      // get logged in users id
      const loggedInUsersId = firebase.auth().currentUser.uid;
      
      // go through all the usersShoppingList docs and find the one with the logged in users Id
      // and save all the recipe ids into our data
      let recipeIds = [];

      usersShoppingLists.forEach(doc => {
        if (doc.data().userId === loggedInUsersId) {
          doc.data().recipeIds.forEach(id => {
            recipeIds.push(id);
          })
        }
      })

      // with all the recipe ids, we need to go through the recipes table and for each recipe
      // that has the matching id, save that to our ShoppingList data

      //create a map to store the name of ingredient, amount/unit
      this.IngredientsList = new Map()
        
      //get the ingredient name , unit, and amount from recipe
      recipeIds.forEach(async id => {
        await db.collection('recipes')
        .doc(id)
        .get()
        .then (querySnapshot => {
          this.ShoppingList.push(querySnapshot)
          querySnapshot.data().ingredients.forEach(ingredient => { 
              let unitAmountMap;

              unitAmountMap = this.IngredientsList.get(ingredient.name)

              let unitAmount = ingredient.amount;

              //if units are not identical with ingredient name, create a new map
              if (!unitAmountMap) {
                unitAmountMap = new Map()
              } else {
                const storedUnitAmount = unitAmountMap.get(ingredient.unit);

                //add amount if units are identical in the ingredient
                if (storedUnitAmount) {
                  unitAmount += storedUnitAmount
                }
              }

              unitAmountMap.set(ingredient.unit, unitAmount)
              this.IngredientsList.set(ingredient.name, unitAmountMap)
          })
        })
      })

      console.log("Lists: " , this.IngredientsList)

    }
}
</script>

<style scoped>
</style>
