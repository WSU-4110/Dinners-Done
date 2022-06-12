package DD;

             //this class is reserved for any user information to be 
             //added in future (after db and all password setting complete
             //on webpages

public class User {

    /*info below needs functions to link them to db
    query for getUser given as long as both match
     */
  String userName;  //TODO: link to user database
  String password;  //TODO: link to user database

    /*array to hold names of favorites
     this string array can be used to match to query in db

     Setting array to fixed length will reduce complexity from quadratic
     to linear for searching, printing, and retrieval
     */
  String[] favorites;   //TODO: set size of array to match array size in recipe db

  
  // Getters and Setters
  public String getUserName() {
	  return userName; 
	  }
  public void setUserName(String userName) {
	  this.userName = userName; 
	  }
  public String getpassword() {
	  return password; 
	  }
  public void setPassword(String password) {
	  this.password = password;
	  }

 

  public void getFavoritesList(String[] favorites){

      System.out.println("Your Favorite Recipes");

      for(int i=0; i < favorites.length; i++) {
          /*run query to recipe db to display any
          recipe whose title matches string in
          favorites
          loop through entire array and display matches as:
           */
          if(true){   //true to be replaced by query to db
              /*1. query to check for match to recipe name
                   no match requires message that recipe does not exist
                2. if match exists, db should return info from recipe
              */
              System.out.println("Insert link to db here");
          }
          else{
              System.out.println(favorites[i] + " not found ");
          }
      }
  }
}
