package com.manish.sqlite;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class FoodStepDB extends SQLiteOpenHelper {
	//final static  String context = "foodstep";	
	final static  String name = "food.db";	
	final static  int version = 1;
	
	public FoodStepDB(Context context) {	
		// TODO Auto-generated constructor stub
		super(context, name, null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	}
	// Getting All Contacts
		public List<Contact> getAllContacts(int id) {
			List<Contact> contactList = new ArrayList<Contact>();
			// Select All Query
			String selectQuery = "SELECT  * FROM FoodStep where id = " + (id + 1);

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);
			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Contact contact = new Contact();
					contact.setID(Integer.parseInt(cursor.getString(0)));
					contact.setName(cursor.getString(3));
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
	
}
