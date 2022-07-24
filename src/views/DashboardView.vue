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

          <div class="recipe-name">Author: {{recipe.author}}</div>
            <br>
            <div class="recipe-name">Amount Fed: {{recipe.amount_fed}}</div>
            <br>
            <div class="recipe-name">
              <b>Ingredients:</b>
              <ul v-for="ingredient in recipe.ingredients" v-bind:key="ingredient.name + ingredient.size">
                <li style="display: block; color: black"> Name: {{ingredient.name }}</li>
                <li style="display: block; color: black">Amount: {{ingredient.amount }}</li>
                <li style="display: block; color: black">Size: {{ingredient.size }} <br></li>
                <div style="height: 10px; display: block"></div>
              </ul>
            </div>
          <div>
            <br><button type="button" class="favbtn" v-if="user.loggedIn">Add Favorite</button>
            <br><button type="button" class="shopbtn" @click="shopBtnFunction()">Add to Shopping List</button>
                <span class="popuptext" id="myPopup">Added to Shopping List</span>
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
//import { browserPopupRedirectResolver } from "@firebase/auth";
import {mapGetters} from "vuex";
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
          this.recipes = querySnapshot.docs.map(doc => doc.data())
          // do something with documents
        })

  },
  methods: {
    submit() {
    },
    shopBtnFunction()  {
    var shopbtn = document.getElementById("myPopup");
    //console.log("Something");
    shopbtn.classList.toggle("show");
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

