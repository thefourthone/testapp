package com.BenjaminLanders.testapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainMenu extends ListActivity{
	
	
	String[] classes = {"MainActivity","example","example","example","example","example"};
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(MainMenu.this,
				android.R.layout.simple_list_item_1, classes));
		
		
		
		
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String nameofclass = classes[position];
		Class<?> ourclass;
		try {
			ourclass = Class.forName("com.BenjaminLanders.testapp."+nameofclass);
			Intent ourIntent = new Intent(MainMenu.this , ourclass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
