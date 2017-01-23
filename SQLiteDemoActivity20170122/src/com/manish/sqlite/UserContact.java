package com.manish.sqlite;

public class UserContact {

	// private variables
	int sn;
	int species;
	String name;
	int amount;
	String unit;
	
	// Empty constructor
	public UserContact() {

	}

	// constructor
	public UserContact(int sn, int species, String name, int amount, String unit) {
		this.sn	= sn;
		this.species = species;
		this.name = name;
		this.amount = amount;
		this.unit = unit;
	}

	public int getsn(){
		return this.sn;
	}

	public void setsn(int sn) {
		this.sn = sn;
	}

	public int getspecies() {
		return this.species;
	}
	public void setspecies(int species) {
		this.species = species;
	}

	public String getname() {
		return this.name;
	}
	public void setname(String name) {
		this.name = name;
	}

	public int getamount() {
		return amount;
	}
	public void setamount(int amount) {
		this.amount = amount;
	}

	public String getunit() {
		return this.unit;
	}
	public void setunit (String unit) {
		this.unit = unit;

	}
}
