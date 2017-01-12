package com.manish.sqlite;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class SQLiteDemoActivity extends Activity {
	ArrayList<Contact> imageArry = new ArrayList<Contact>();
	ContactImageAdapter adapter;
	public static final int resultNum = 0;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setTitle("食譜");
		
		DataBaseHandler db = new DataBaseHandler(this);

		List<Contact> contacts = db.getAllContacts();
		for (Contact cn : contacts) {
			imageArry.add(cn);
		}
		
		adapter = new ContactImageAdapter(this, R.layout.screen_list,
				imageArry);
		ListView dataList = (ListView) findViewById(R.id.list);
		
		dataList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			/* (non-Javadoc)
			 * @see android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget.AdapterView, android.view.View, int, long)
			 */
			@Override
			public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) { 
				// TODO Auto-generated method stub
				ListView listView = (ListView) arg0;
				//Log.d("OK" , "" +arg2);
				Intent intent = new Intent(SQLiteDemoActivity.this,MYFoodStep.class);
			
				Bundle bundle = new Bundle(); 
				//放入foodID:arg2
				bundle.putInt("foodID", arg2);

				intent.putExtras(bundle); 
				//近路MYFoodStep
				startActivity(intent); 
//				SQLiteDemoActivity.this.finish(); //關閉
//				startActivity(intent); //
			}

		}); 

		dataList.setAdapter(adapter);
		}
	
	}

