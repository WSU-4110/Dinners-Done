<template>
  <nav>
        <nav class="menu">
          <ul>
            <div v-if="user.loggedIn" style="color: azure">Hello {{user.data.displayName}}</div>

            <li class="nav">  <router-link to="/">Home</router-link></li>
            <li class="nav" v-if="! user.loggedIn">  <router-link to="/login">Login</router-link></li>
            <li class="nav" v-if="! user.loggedIn">  <router-link to="/register">Register</router-link></li>
            <li class="nav" v-if="user">  <router-link to="/dashboard">Recipes</router-link></li>
            <li class="nav" v-if="user">  <router-link to="/recipeentry">Recipe Entry</router-link></li>
            <li class="nav" v-if="user.loggedIn">  <router-link to="/shoppinglist">Shopping List</router-link></li>
            <li class="nav" v-if="user.loggedIn">  <router-link to="/favorite">Favorites</router-link></li>
            <li class="logout" v-if="user.loggedIn" @click="signOut">Sign out</li>
          </ul>
        </nav>

    <!--    |-->
    <!--    <router-link to="/register">Register</router-link>-->
  </nav>
  <router-view/>
</template>

<script>
import { mapGetters } from "vuex";
import firebase from "firebase/compat/app";

export default {

  methods:{
    signOut() {
      firebase
          .auth()
          .signOut()
          .then(() => {
            this.$router.replace({
              name: "login"
            });
          });
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
@import './assets/style.css';


  #app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
