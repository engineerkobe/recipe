package com.manish.sqlite;

public class FoodContact {
	// private variables
	int _id;
	String _name;
	byte[] _image;

	
	public FoodContact(int keyId, String name, byte[] image) {
		this._id = keyId;
		this._name = name;
		this._image = image;
	}

	// getting ID
	public int getID() {
		return this._id;
	}

	// setting id
	public void setID(int keyId) {
		this._id = keyId;
	}

	// getting name
	public String getName() {
		return this._name;
	}

	// setting name
	public void setName(String name) {
		this._name = name;
	}

	// getting phone number
	public byte[] getImage() {
		return this._image;
	}

	// setting phone number
	public void setImage(byte[] image) {
		this._image = image;
	}
}
