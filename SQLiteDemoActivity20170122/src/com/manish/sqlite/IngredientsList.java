package com.manish.sqlite;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class IngredientsList extends Activity{
	String main_type[] = {"魚肉","海鮮","肉類","蔬菜","豆類製品","蛋類","加工產品"};	
	String number[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
	int spinner_index1 = 0;
	int spinner_index2 = 0;
	int spinner_index3 = 0;
	IngredientsDB DB = new IngredientsDB(this);
	private List<IngredientsContact> contacts;
	String spinner2_item[];
    //Intent intent = new Intent(IngredientsList.this,SQLiteDemoActivity.class);
    
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2 );
		
		final Spinner spinner1 = (Spinner)findViewById(R.id.mainlist1);
		final Spinner spinner2 = (Spinner)findViewById(R.id.mainlist2);
		final Spinner spinner3 = (Spinner)findViewById(R.id.mainlist3);
		final Button  button1  = (Button) findViewById(R.id.input); 
		final Button  button2  = (Button) findViewById(R.id.IngredientYES); 
		
		ArrayAdapter aa = new ArrayAdapter(IngredientsList.this,android.R.layout.simple_spinner_item,main_type);//選項資料內容
		spinner1.setAdapter(aa);
		
		ArrayAdapter bb = new ArrayAdapter(IngredientsList.this,android.R.layout.simple_spinner_item,number);//選項資料內容
		spinner3.setAdapter(bb);
		//spinner1監聽
		spinner1.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
	    	@Override 
	    	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) { 
	    		spinner_index1 = arg2;
	    		//搜尋 所有資料
	    		contacts = DB.getAllContacts(main_type[spinner_index1]);
	    		
	    		spinner2_item = new String[contacts.size()];
	    		for(int i = 0; i < contacts.size(); i++){
	    			IngredientsContact d = contacts.get(i);
	    			spinner2_item[i] = d.getName();
	    		}
	    		ArrayAdapter aa = new ArrayAdapter(IngredientsList.this,android.R.layout.simple_spinner_item,spinner2_item);//選項資料內容
	    		spinner2.setAdapter(aa);
            }  
	    	@Override  
            public void onNothingSelected(AdapterView<?> arg0) {}     	
	    });  //getString()
	  

	    spinner2.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
	    	@Override 
	    	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) { 
	    		spinner_index2 = arg2;
	    	}
	    	@Override  
            public void onNothingSelected(AdapterView<?> arg0) {}     	
	    }); 
	    
	    spinner3.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
	    	@Override 
	    	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) { 
	    		spinner_index3 = arg2 + 1;
	    	}
	    	@Override  
            public void onNothingSelected(AdapterView<?> arg0) {}     	
	    }); 
		
	    button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(IngredientsList.this,SQLiteDemoActivity.class);
				startActivity(intent); 
			}
		});
	    
	  final UserDataBaseHandler UDB = new UserDataBaseHandler(this); 
	    button2.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//							sn, species, name, amount, unit
				UserContact d = new UserContact(3,
						spinner_index1,
						spinner2_item[spinner_index2],
						spinner_index3,
						"G");
		
				/*UserContact d;
				d = new UserContact(1,
									spinner_index1,
									spinner2_item[spinner_index2],
									spinner_index3,
									"G");
									*/
				//UDB.addContact(d);
				UDB.updateContact(d);
				//UDB.addContact(new UserContact(1,2,"3",4,"5"));
			}
		});
	}
}
