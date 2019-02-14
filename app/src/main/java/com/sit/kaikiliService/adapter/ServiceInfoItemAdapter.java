package com.sit.kaikiliService.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.sit.kaikiliService.KaikiliApplication;
import com.sit.kaikiliService.R;
import com.sit.kaikiliService.font.TextViewEuphemiaUCASRegular;
import com.sit.kaikiliService.model.ServiceInfoModel;

import java.util.ArrayList;


/**
 * Created by ketan patel on 31/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 */

public class ServiceInfoItemAdapter extends BaseAdapter {

    private Context mActivity;
    private LayoutInflater inflater;
    private ArrayList<ServiceInfoModel> servicesList = new ArrayList<>();
    private KaikiliApplication application;


    public ServiceInfoItemAdapter(Context activity) {
        // TODO Auto-generated constructor stub
        mActivity = activity;
        application = (KaikiliApplication) mActivity.getApplicationContext();
        inflater = (LayoutInflater) mActivity.getSystemService( Activity.LAYOUT_INFLATER_SERVICE );

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return servicesList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return servicesList.get( position );
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
        row = inflater.inflate( R.layout.row_service_info_item, null );
        holder.tvName = (TextViewEuphemiaUCASRegular) row.findViewById( R.id.row_service_info_item_tv_name );
        holder.tvAmount = (TextViewEuphemiaUCASRegular) row.findViewById( R.id.row_service_info_item_tv_amount );

        holder.tvAmount.setText( "$ " + servicesList.get( position ).getAmount() );
        holder.tvName.setText( servicesList.get( position ).getName() );


        return row;
    }


    public void setList(ArrayList<ServiceInfoModel> servicesList) {
        // TODO Auto-generated method stub
        this.servicesList = servicesList;
        notifyDataSetChanged();
    }

    static class RecordHolder {
        TextViewEuphemiaUCASRegular tvName, tvAmount;

    }


}
