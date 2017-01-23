package com.manish.sqlite;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.AdapterView.OnItemSelectedListener;

public class IngredientsDB extends SQLiteOpenHelper {
	//final static  String context = "foodstep";	
	final static  String name = "save.db";	
	final static  int version = 1;
	
	public IngredientsDB(IngredientsList ingredientsList) {	
		// TODO Auto-generated constructor stub
		super((Context) ingredientsList, name, null, version);
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
		public List<IngredientsContact> getAllContacts(String id) {
			List<IngredientsContact> contactList = new ArrayList<IngredientsContact>();
			// Select All Query
			String selectQuery = "SELECT * FROM  save where ²Ä¤@¼h =  '" + id + "'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			if (cursor.moveToFirst()) {
				do {
					IngredientsContact contact =new IngredientsContact();
					contact.setID(cursor.getString(0));
					contact.setName(cursor.getString(1));
					//contact.setImage(cursor.getBlob(2));
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
