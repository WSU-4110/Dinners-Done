package com.recipeentry;

import java.io.Serializable;

public class Recipe implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String ingredientsID;
	private String ingredientAmount;


	
	public Recipe() {
		this.ingredientsID = "";
		this.ingredientAmount = "";
	}
	

	public Recipe(String ingredientsID, String ingredientAmount) {
		this.ingredientsID = ingredientsID;
		this.ingredientAmount = ingredientAmount;

	}
	
	public String getingredientsID() {
		return ingredientsID;
	}
	
	public void setingredientsID(String ingredientsID) {
		this.ingredientsID = ingredientsID;
	}
	
	public String getingredientAmount() {
		return ingredientAmount;
	}
	
	public void setingredientAmount(String ingredientAmount) {
		this.ingredientAmount = ingredientAmount;
	}
	


}
