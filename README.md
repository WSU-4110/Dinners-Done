# Dinners Done Website
The overall goal of this code is a website that allows users to view 1 single list for use when grocery shopping. A user must sign in to use this site, so an account creation is required first. This requires the user to add name, Email address, and an acceptable password. At present, there are some protections from the creation of a weak password. Upon signing in, the user may search the recipes available on the site. The user has the ability to save to "favorites" any recipe displayed. The user can also delete a favorited recipe. The user may also add his/her own recipe. Any recipe created by the user must add a URL to credit the author if that author is another individual. Recipes created by users will only be visible to that individual user, and will not be made availble or searchable to any other individuals. If the users clicks "add to shopping list," the selected recipe will be added to the current list. That includes the name of the recipe and each ingredient's amount being added to the total of that ingredient in the shopping list. The user may choose any number of recipes to add. Whenever the user selects the shopping cart icon, he/she will see a display of the current recipes selected and the list of ingredients (totals only) required to make those recipes. The primary goal of this site is not to provide a recipe outlet, but to allow a user a quick list of groceries necessary to prepare selected recipes. This is a highly useful concept for parents, students, and any others that lack time necessary to plan several meals and the grocery trips associated with them. 

## Project setup
```
npm install
```
Create a .env file in the root directory.

Copy the .env.example to the .env file.

Replace key-here with the firebase api key.

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Lints and fixes files
```
npm run lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).
