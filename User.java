

public class User {


String userName; 
String password; 
String firstName;
String lastName;
String email;
int userId;

/*array to hold names of favorites
this string array can be used to match to query in db

Setting array to fixed length will reduce complexity from quadratic
to linear for searching, printing, and retrieval
*/
String[] favorites;   


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


public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}


public String[] getFavorites() {
	return favorites;
}


public void setFavorites(String[] favorites) {
	this.favorites = favorites;
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
