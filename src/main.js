import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import firebase from 'firebase/compat/app';
import 'firebase/compat/auth';
import 'firebase/compat/firestore';

//Firebase configuration 
const firebaseConfig = {
    apiKey: "AIzaSyBGU_GbRz664n7KY8xU8GsT1_DfJMx0oqA",
    authDomain: "recipe-dd.firebaseapp.com",
    projectId: "recipe-dd",
    storageBucket: "recipe-dd.appspot.com",
    messagingSenderId: "843977391914",
    appId: "1:843977391914:web:a063668e9354567ef2a853",
    measurementId: "G-P18ZGNZN2D"
};

// initialize firebase application
const firebaseApp = firebase.initializeApp(firebaseConfig);

//create a globally accessible firestore object
export const db = firebaseApp.firestore();
firebase.auth().onAuthStateChanged(user => {
    store.dispatch("fetchUser", user);
});


// initialize VueJs and mount it on the div with id of app
createApp(App).use(store).use(router).mount('#app')



