import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
// import * as firebase from "firebase/app";
// import { initializeApp } from "firebase/app";
// import { getAuth } from "firebase/auth";
import firebase from 'firebase/compat/app';
import 'firebase/compat/auth';
import 'firebase/compat/firestore';


// import { getDatabase } from "firebase/database";

// import { initializeApp } from "firebase/app";
//
const firebaseConfig = {
    apiKey: "",
    authDomain: "recipe-dd.firebaseapp.com",
    projectId: "recipe-dd",
    storageBucket: "recipe-dd.appspot.com",
    messagingSenderId: "843977391914",
    appId: "1:843977391914:web:a063668e9354567ef2a853",
    measurementId: "G-P18ZGNZN2D"
};

const firebaseApp = firebase.initializeApp(firebaseConfig);

export const db = firebaseApp.firestore();
firebase.auth().onAuthStateChanged(user => {
    store.dispatch("fetchUser", user);
});

//
// export const db = getDatabase(firebaseApp);
// export const auth = getAuth(firebaseApp);

// export const db = firebase.firestore();
// var db = firebase.firestore()

createApp(App).use(store).use(router).mount('#app')



