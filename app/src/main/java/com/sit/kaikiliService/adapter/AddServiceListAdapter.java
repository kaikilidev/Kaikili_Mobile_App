package com.sit.kaikiliService.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;


import com.sit.kaikiliService.KaikiliApplication;
import com.sit.kaikiliService.R;
import com.sit.kaikiliService.activity.AddServiceDataActivity;
import com.sit.kaikiliService.api.ServiceList;
import com.sit.kaikiliService.font.TextViewEuphemiaUCASRegular;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Created by ketan patel on 30/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 */

public class AddServiceListAdapter extends BaseAdapter {

	private Context mActivity;
	private LayoutInflater inflater;
	private ArrayList<ServiceList> servicesList = new ArrayList<>();
    private KaikiliApplication application;


	public AddServiceListAdapter(Context activity) {
		// TODO Auto-generated constructor stub
		mActivity = activity;
        application = (KaikiliApplication)mActivity.getApplicationContext();
		inflater = (LayoutInflater) mActivity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return servicesList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return servicesList.get(position);
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
            row = inflater.inflate(R.layout.row_add_services, null);
            holder.tvName = (TextViewEuphemiaUCASRegular)row.findViewById( R.id.row_add_service_tv_title );
            holder.frameLayout = (LinearLayout)row.findViewById( R.id.row_add_service_ll_row );
            row.setTag(holder);
            holder.tvName.setText( servicesList.get(position).getSr_title());



		row.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

//				Log.e( "------------", servicesList.get(post).getCost_comps_per_itme().size() +" item");
//				Log.e( "------------", servicesList.get(post).getCost_comps_pro_rated().size() +" item");

				Intent intent = new Intent(mActivity, AddServiceDataActivity.class);
				intent.putExtra("serviceName",  servicesList.get(post) );
				mActivity.startActivity(intent);
			}
		});


        return row;
    }



	public void setList(ArrayList<ServiceList> servicesList) {
		// TODO Auto-generated method stub
		this.servicesList = servicesList;
		notifyDataSetChanged();
	}

	static class RecordHolder {
		TextViewEuphemiaUCASRegular tvName;
		LinearLayout frameLayout;

	}

	
}
