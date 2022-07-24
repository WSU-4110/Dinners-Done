<template>
  <div>
    <h1>List Recipe</h1>
    <table class="table table-striped">
      <thead>
        <tr>
          <th>Recipe Name</th>
          <th colspan="2">Action</th>
        </tr>
      </thead>
      <tbody>
          <tr v-for="item of items" :key="item['.key']">
            <td>{{ item.RecipeName }}</td>
          </tr>
      </tbody>
    </table>
  </div>
</template>



<script>

import {db} from "@/main";

export default {
  components: {
      RecipeName: 'recipeentry'
  },
  data() {
    return {
      items: []
    }
  },
  firebase: {
    items: db.ref('recipeentry')
  }
}
</script>