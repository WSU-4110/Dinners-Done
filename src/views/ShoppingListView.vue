<template>
  <div class="container">
    <section>
      <h1>"hello shopping list"</h1>
    </section>
  </div>
</template>


<script>
import {db} from '@/main';

export default {
  
    //shoppinglists: {},

  data() {
    return {
      recipe: {
        amount:null,
        name:null,
        unit:null
      }
    };
  },

  created(){
    db.collection("users").collection("shoppinglist").get().then(function(querySnapshot) {
      querySnapshot.forEach(function(doc) {
        console.log(doc.id, " => ", doc.data());
      });
    });
  }

};

</script> 
<style scoped>
</style>
