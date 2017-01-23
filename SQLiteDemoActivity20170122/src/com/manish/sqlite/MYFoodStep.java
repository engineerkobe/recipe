package com.manish.sqlite;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListView;

public class MYFoodStep extends Activity{
	 private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;
		ArrayList<Contact> imageArry = new ArrayList<Contact>();
		FoodStepContactImageAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main );
		//title
		setTitle("步驟");

		Bundle bundle = this.getIntent().getExtras(); 
		//取得點選的index
		int index =  bundle.getInt("foodID");
		FoodStepDB db = new  FoodStepDB(this);
		List<Contact> contacts = db.getAllContacts(index);
		for (Contact cn : contacts) {
			imageArry.add(cn);
		}
		adapter = new FoodStepContactImageAdapter(this, R.layout.item,
				imageArry);
		ListView dataList = (ListView) findViewById(R.id.list);
		dataList.setAdapter(adapter);
		//byte[] 轉 bitmap
	
	}
		
	
}
