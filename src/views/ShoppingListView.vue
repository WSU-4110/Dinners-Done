<template>
  <div class="">
    <section>
      <div class="box">
        <div class="rbox" v-for="recipe in ShoppingList" v-bind:key="recipe.id">
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
            <br><button type="button" class="shopbtn" @click="onclick(recipe.id)">Add to Shopping List</button>
            <select name="Quantity" class="foodquantity">
              <option value="o1">1</option>
              <option value="o2">2</option>
              <option value="o3">3</option>
              <option value="o4">4</option>
              <option value="o5">5</option>
              <option value="o6">6</option>
              <option value="o7">7</option>
              <option value="o8">8</option>
              <option value="o9">9</option>
              <option value="o10">10</option>
            </select><br>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>




<script>
import {db} from "@/main";
import firebase from "firebase/compat/app";
//import { QuerySnapshot } from "@firebase/firestore-types";


export default {
    firestore: {
        ShoppingList: db.collection('shoppinglist')
    },
    data() {
        return {
            ShoppingList: []
        }
    },
    methods: {
        back() {
            location.reload();
            //console.log(querySnapshot)
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

      console.log("RecipeIds: ", recipeIds)


      // with all the recipe ids, we need to go through the recipes table and for each recipe
      // that has the matching id, save that to our ShoppingList data

      recipeIds.forEach(id => {
        db.collection('recipes')
        .doc(id)
        .get()
        .then (querySnapshot => {
          this.ShoppingList.push(querySnapshot)
          console.log(this.ShoppingList)
        })
      })

        // db.collection('users')
        // .doc('MESV3Sx0cDBTK82da0U8')
        // .collection('shoppinglist')
        // .get()
        // .then(querySnapshot => {
          
        //   querySnapshot.forEach(doc => {
        //     console.log(doc.data())
        //     this.recipeId.push(doc.data().recipes.recipeid)
        //     console.log(this.recipeId)

        //   })

        //   db.collection('recipes')
        //   .doc(this.recipeId[0])
        //   .get()
        //   .then(querySnapshot => {
        //       this.ShoppingList.push(querySnapshot.data())
        //       console.log(this.ShoppingList)
        //   })
          //this.ShoppingList = querySnapshot.docs.map(doc => doc.data())
          //console.log(this.ShoppingList[0].userid);
          // do something with documents
        //})
        //console.log(this.ShoppingList)
        //this.getShoppingList();
    }
}
</script>

<style scoped>
</style>
