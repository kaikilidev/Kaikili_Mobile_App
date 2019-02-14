package com.sit.kaikiliService.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.sit.kaikiliService.KaikiliApplication;
import com.sit.kaikiliService.R;
import com.sit.kaikiliService.api.CompsItme;
import com.sit.kaikiliService.font.TextViewEuphemiaUCASRegular;

import java.util.ArrayList;


/**
 * Created by ketan patel on 28/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 */

public class AddServiceItemAdapter extends BaseAdapter {

	private Context mActivity;
	private LayoutInflater inflater;
	private ArrayList<CompsItme> compsItmeList = new ArrayList<>();
    private KaikiliApplication application;


	public AddServiceItemAdapter(Context activity) {
		// TODO Auto-generated constructor stub
		mActivity = activity;
        application = (KaikiliApplication)mActivity.getApplicationContext();
		inflater = (LayoutInflater) mActivity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return compsItmeList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return compsItmeList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View row = convertView;
        RecordHolder holder = null;
		final int post = position;

            holder = new RecordHolder();
            row = inflater.inflate(R.layout.row_add_services_item, null);
            holder.tvName = (TextViewEuphemiaUCASRegular)row.findViewById( R.id.row_add_service_item_tv_title );
            holder.frameLayout = (LinearLayout)row.findViewById( R.id.row_add_service_item_ll_row );
            row.setTag(holder);
            holder.tvName.setText( compsItmeList.get( post ).getCc_title());



		row.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

//				((MainActivity)mActivity).callGroupLink(compsItmeList.get(post).getCategory_title(),compsItmeList.get(post).getCategory_id());

//				Intent intent = new Intent(mActivity, GroupListActivity.class);
//				intent.putExtra("categoriesName",compsItmeList.get(post).getCategory_title());
//				intent.putExtra("categoriesId",compsItmeList.get(post).getCategory_id());
//				mActivity.startActivity(intent);
			}
		});


        return row;
    }



	public void setList(ArrayList<CompsItme> compsItmeList) {
		// TODO Auto-generated method stub
		this.compsItmeList = compsItmeList;
		notifyDataSetChanged();
	}

	static class RecordHolder {
		TextViewEuphemiaUCASRegular tvName;
		LinearLayout frameLayout;

	}

	
}
