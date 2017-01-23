package com.manish.sqlite;

public class IngredientsContact {

	// private variables
	String id = "";
	String name = "";

	// Empty constructor
	public IngredientsContact() {

	}

	// constructor
/*	
	public IngredientsContact(String keyId, String name) {
		this.id = keyId;
		this.name = name;
	}
*/
	
	// getting ID
	public String getID() {
		return this.id;
	}

	// setting id
	public void setID(String keyId) {
		this.id = keyId;
	}
	// getting name
	public String getName() {
		return this.name;
	}

	// setting name
	public void setName(String name) {
		this.name = name;
	}
}
