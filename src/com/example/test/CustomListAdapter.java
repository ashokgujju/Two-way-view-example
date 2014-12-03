package com.example.test;

import org.lucasr.twowayview.TwoWayView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CustomListAdapter extends BaseAdapter{

	Context context;
	String [] nums;
	LayoutInflater inflater;
	
	public CustomListAdapter(MainActivity mainActivity, String[] nums) {
		this.nums = nums;
		context = mainActivity;
	}

	@Override
	public int getCount() {
		return nums.length;
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup arg2) {
		if(inflater == null) {
			inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}
		if(view == null) {
			view = inflater.inflate(R.layout.list_item, null);
		}
		
		TextView tv = (TextView) view.findViewById(R.id.textView1);
		tv.setText(nums[position]);
		
		TwoWayView twview = (TwoWayView) view.findViewById(R.id.twowayview);
		twview.setAdapter(new BaseAdapter() {
			
			@Override
			public View getView(int arg0, View convertView, ViewGroup arg2) {
					if (convertView == null) {
						convertView = inflater.inflate(R.layout.twview_item, null);
					}
					Button b = (Button) convertView.findViewById(R.id.button1);
					b.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							Toast.makeText(arg0.getContext(), "click", Toast.LENGTH_LONG).show();
						}
					});
					b.setOnLongClickListener(new OnLongClickListener() {
						
						@Override
						public boolean onLongClick(View arg0) {
							Toast.makeText(arg0.getContext(), "Long click", Toast.LENGTH_LONG).show();
							return false;
						}
					});
//					TextView tv = (TextView) convertView.findViewById(R.id.textView1);
//					tv.setText("ashok");
				return convertView;
			}
			
			@Override
			public long getItemId(int arg0) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Object getItem(int arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return 10;
			}
		});
		
		return view;
	}
}