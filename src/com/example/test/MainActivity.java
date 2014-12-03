package com.example.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ListView lv = (ListView) findViewById(R.id.listView1);

		String[] nums = { "1", "2", "3", "4", "5", "11", "12", "13", "14",
				"15", "21", "22", "23", "24", "25" };
		CustomListAdapter adapter = new CustomListAdapter(this, nums);
		lv.setAdapter(adapter);
	}
}