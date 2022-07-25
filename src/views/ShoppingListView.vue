<template>
    <v-container>
        <h1>Shopping List</h1>
        <v-simple-table>
            <template v-slot:default>
                <thead>
                    <tr>
                        <th class="text-left">Catogorie</th>
                        <th class="text-left">Product</th>
                    </tr>
                </thead>
                <tbody>
                    <!---<tr v-for="recipes in ShoppingList" :key="shoppingList.id">
                        //<td>{{shoppingList.addShoppingList.name}}</td>
                        //<td>{{shoppingList.addShoppingList.amount}}</td>
                    </tr>-->
                </tbody>
            </template>
        </v-simple-table>
    </v-container>
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
          this.ShoppingList.push(querySnapshot.data())
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
