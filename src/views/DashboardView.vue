<template>
  <div class="">
    <section>
      <div class="box">
        <div class="rbox" v-for="recipe in recipes" v-bind:key="recipe.id">
          <a :href="recipe.data().link">
            <img class="recipe-img" :src="recipe.data().image" >
            <br>
            <div class="recipe-name">{{recipe.data().name}}</div>
            <br>
          </a>

          <div class="recipe-name">Serving size: {{recipe.data().serving_size}}</div>
            <br>
            <div class="recipe-name">Web link: <a v-bind:href='recipe.data().link'>{{recipe.data().link}}</a></div>
            <br>
            <div class="recipe-name">
              <b>Ingredients:</b>
              <ul v-for="ingredient in recipe.data().ingredients" v-bind:key="ingredient.name + ingredient.size">
                <li style="display: block; color: black"> Name: {{ingredient.name }}</li>
                <li style="display: block; color: black">Amount: {{ingredient.amount }}</li>
                <li style="display: block; color: black">Size: {{ingredient.size }} <br></li>
                <div style="height: 10px; display: block"></div>
              </ul>
            </div>
          <div>
            <br><button type="button" class="favbtn" v-if="user.loggedIn">Add Favorite</button>
            <br><button type="button" class="shopbtn" @click="onclick(recipe.id)">Add to Shopping List</button>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>


<script>


import {db} from "@/main";
//import { browserPopupRedirectResolver } from "@firebase/auth";
import {mapGetters} from "vuex";
import firebase from "firebase/compat/app";
// import {collection } from "firebase/firestore"

export default {
  data() {
    return {
      recipes: [],
    };
  },
  created() {
    //this.$route.params.id  .doc()
    //  db.collection("recipes").get().then((data) =>
    //  this.recipes = data.docs );
    
    db.collection('recipes')
        .get()
        .then(querySnapshot => {
          console.log(querySnapshot);
          this.recipes = querySnapshot.docs
        })

  },
  methods: {
    submit() {
    },
    async onclick(recipeId) {
      //this will store recipe id in the users shopping list if user does not have shopping list we will create one
      let usersShoppingLists = (await db.collection('shoppingLists').get()).docs;
      
      const loggedInUsersId = firebase.auth().currentUser.uid;
      console.log("User id: " , loggedInUsersId)


      let shoppingListId;

      usersShoppingLists.forEach(doc => {
        if (doc.data().userId === loggedInUsersId) {
          shoppingListId = doc.id 
          console.log("Shopping List Id: ", shoppingListId)
        }
      })

      let recipeids = []

      if(!shoppingListId) {
          //create shopping lists for user
        shoppingListId = (await db.collection("shoppingLists").add( {
        recipeIds: recipeids,
        userId: loggedInUsersId
        })).id
      }
      
      await db.collection('shoppingLists')
      .doc(shoppingListId)
      .get()
      .then (querySnapshot => {
          querySnapshot.data().recipeIds.forEach(id => {
            recipeids.push(id)
          })
      })

      // find recipe id of the one that was clicked
      console.log("recipeId: ", recipeId)
      let clickedRecipeId = recipeId


      if (!recipeids.includes(clickedRecipeId)) {
        recipeids.push(clickedRecipeId)

        console.log("Update recipe ids: " , recipeids)
        //update user shopping lists
        await db.collection('shoppingLists')
        .doc(shoppingListId)
        .update({
            recipeIds: recipeids
        })      
      }

      alert("Added to Shopping List")
   }
  },
  computed: {
    // map `this.user` to `this.$store.getters.user`
    ...mapGetters({
      user: "user"
    })
  }


};

</script>

<style>
@import '../assets/style.css';
</style>

