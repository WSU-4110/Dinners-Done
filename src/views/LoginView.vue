<template>
  <div>
    <section>
      <div class="container">
        <div class="title"><span>Login</span></div>
        //Prevents the default html behavior
        <form action="#" @submit.prevent="submit">
          <div class="text">

            <input type="text" placeholder="Enter Email" required
                   v-model="form.email"
            >
          </div>
          <div class="text">
            <input type="password" placeholder="Enter Password" required
                   v-model="form.password"
            >
          </div>
          <div class="error" v-if="error.value.length !== 0">
            {{error.value}}
          </div>
<!--          <div class="pass"><a href="#">Forgot password?</a></div>-->
          <div class="buttn">
            <input type="submit" value="Login">
          </div>

          <div class="signup">Not a member? <a href="/register">Create an account</a></div>
        </form>
      </div>

  </section>

  </div>
</template>


<script>
import {
  signInWithEmailAndPassword,
    getAuth
} from "firebase/auth";
// Initialize Firebase Authentication and get a reference to the service
const auth = getAuth();
//Authenticate the user to firebase
export default {
  data() {
    return {
      form: {
        email: "",
        password: "",

      },
      error: {
        value:''
      },
    };
  },
  methods: {
    submit() {
    //When signed in redirect to the dashboard page
      signInWithEmailAndPassword(auth, this.form.email, this.form.password)
          .then((user) => {
            console.log(user);
            this.$router.push("/dashboard");

          })
          //Login Form validation
          .catch((error) => {
            switch (error.code) {
              case "auth/invalid-email":
                this.error.value = "Invalid email";
                break;
              case "auth/user-not-found":
                this.error.value = "No account with that email was found";
                break;
              case "auth/wrong-password":
                this.error.value = "Incorrect password";
                break;
              default:
                this.error.value = "Email or password was incorrect";
                break;
            }
          });
    }
  }

};
</script>
<style scoped>
</style>
