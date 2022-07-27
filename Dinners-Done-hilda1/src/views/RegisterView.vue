<template>
  <div class="container">
    <nav class="menu">
      <input type="checkbox" id="toggle-bar">
      <label for="toggle-bar" class='btn'>
        <i class="fa fa-bars"></i>
      </label>
    </nav>
    <section>
      <div class="container">
        <div class="title"><span>Register</span></div>
        <form action="#" @submit.prevent="submit">
          <div class="text">

            <input type="text" placeholder="Enter your name" v-model="form.name" required>
          </div>
          <div class="text">

            <input type="text" placeholder="Enter Email" v-model="form.email" required>
          </div>

          <div class="text">
            <input type="password" v-model="form.password" placeholder="Enter Password" id="password" required>
          </div>
          <div class="text">
            <input type="password" v-model="form.password_confirmation"  placeholder="Confirm password" id="password2" required >
          </div>
          <div class="buttn">
            <input type="submit" value="Signup">
            <li v-for="error in form.error" style="color:gray; text-align: left;  padding-left: 40px;" v-bind:key="error">{{error}}</li>

          </div>
          <div class="login">Already have an account? <a href="login.html"> login Now </a></div>

        </form>

      </div>



    </section>
  </div>
</template>


<script>
//Importing the functions from firebase
import { getAuth, createUserWithEmailAndPassword, updateProfile } from 'firebase/auth'
//Register the user to firebase
export default {
  data() {
    return {
      form: {
        name: "",
        email: "",
        password: "",
        error: [],
      },
      error: null
    };
  },
   //Register Form validation
  methods: {
    validateForm(){
      var valid = true;
      this.form.error =[];


      if(this.form.name.length === 0 ){
        this.form.error.push("The username field is required") ;

        valid = false;

      }
      if(this.form.email.length === 0 ){
        this.form.error.push("The email field is required") ;
        valid = false;
      }

      if(this.form.password !== this.form.password_confirmation){
        this.form.error.push("The passwords do not match") ;
        valid = false;

      }
      if(this.form.password.length < 6 || this.form.password.length > 14 ){
        this.form.error.push("The password length should be between 6 and 14") ;

        valid = false;

      }
      return valid
    },

    submit() {
      if(this.validateForm()) {
  //Authorize and register the user
      const auth = getAuth();
       //Creaating user with email and password
      createUserWithEmailAndPassword(auth, this.form.email, this.form.password)
          .then((user) => {
            if (user) {
              updateProfile(auth.currentUser, {
                displayName: this.form.name,
                photoURL: ''
              })
            }
             //Navigating to the url
            this.$router.push('/');

          })
           //Handling the errors
          .catch(err => {
            this.error = err.message;
          });
      }
    }
  }
};
</script>

<style>
/*@import '../assets/style.css';*/
</style>

