package com.manish.sqlite;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDataBaseHandler extends SQLiteOpenHelper {

	// All Static variabes
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "user.db";

	// Contacts table name
	private static final String TABLE_CONTACTS = "contacts";

	public UserDataBaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	// Creating Tables
//	魚肉 1
//	海鮮 2
//	肉類 3
//	蔬菜 4
//	豆類製品 	5
//	蛋類		6
//	加工產品	7

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = 
				"CREATE TABLE " + "contacts" + "("
				+ "sn" 	+ " INTEGER PRIMARY KEY,"
				+ "species" + " INTEGER,"
				+ "name" 	+ " TEXT,"
				+ "amount" +  " INTEGER,"
				+ "unit" +  " TEXT"
				+ ")";
		db.execSQL(CREATE_CONTACTS_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
		// Create tables again
		onCreate(db);
	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	public// Adding new contact
	void addContact(UserContact contact) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		//values.put("sn", contact.sn); // Contact Name
		values.put("species", contact.getspecies()); 
		values.put("name", contact.getname()); 
		values.put("amount", contact.getamount());
		values.put("unit", contact.getunit());
		// Inserting Row
		db.insert(TABLE_CONTACTS, null, values);
		db.close(); // Closing database connection
	}

	// Getting single contact
	Contact getContact(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_CONTACTS, new String[] { "sn","species","name","amount","unit"
				}, "sn" + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), cursor.getBlob(1));

		// return contact
		return contact;

	}

	// Getting All Contacts
	public List<Contact> getAllContacts() {
		List<Contact> contactList = new ArrayList<Contact>();
		// Select All Query
		String selectQuery = "SELECT  * FROM contacts ORDER BY name";

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Contact contact = new Contact();
				contact.setID(Integer.parseInt(cursor.getString(0)));
				contact.setName(cursor.getString(1));
				contact.setImage(cursor.getBlob(2));
				// Adding contact to list
				contactList.add(contact);
			} while (cursor.moveToNext());
		}
		// close inserting data from database
		db.close();
		// return contact list
		return contactList;

	}

	// Updating single contact
	public int updateContact(UserContact contact) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		//values.put("sn", contact.sn); // Contact Name
		values.put("species", contact.species); 
		values.put("name", contact.name); 
		values.put("amount", contact.amount);
		values.put("unit", contact.unit);
		// updating row
		return db.update(TABLE_CONTACTS, values, "sn" + " = ?",
				new String[] { String.valueOf(contact.getsn()) });

	}

	// Deleting single contact
	public void deleteContact(Contact contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_CONTACTS, "sn" + " = ?",
				new String[] { String.valueOf(contact.getID()) });
		db.close();
	}

	// Getting contacts Count
	public int getContactsCount() {
		String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}


}
