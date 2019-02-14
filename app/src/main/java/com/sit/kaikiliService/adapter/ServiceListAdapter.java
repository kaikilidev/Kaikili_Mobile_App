package com.sit.kaikiliService.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sit.kaikiliService.KaikiliApplication;
import com.sit.kaikiliService.R;
import com.sit.kaikiliService.activity.ServiceInfoActivity;
import com.sit.kaikiliService.font.TextViewEuphemiaUCASRegular;

import java.util.ArrayList;

import com.sit.kaikiliService.model.ServiceModel;


/**
 * Created by ketan patel on 30/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 */

public class ServiceListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mActivity;
    private KaikiliApplication application;
    private ArrayList <ServiceModel> serviceList;

    public ServiceListAdapter(Context activity) {
        // TODO Auto-generated constructor stub
        mActivity = activity;
        application = (KaikiliApplication) mActivity.getApplicationContext();
        serviceList = new ArrayList<>( );
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
        View v = inflater.inflate( R.layout.row_services_book, parent, false );
        viewHolder = new MyViewHolder( v );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.tvTitle.setText( serviceList.get( position ).getServiceName());
        viewHolder.tvTime.setText( serviceList.get( position ).getServiceTime());

//
//        viewHolder.cardView.setTag( position );
//
        viewHolder.cardView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( mActivity, ServiceInfoActivity.class );
                 mActivity.startActivity( intent );

            }
        } );
//
//        viewHolder.mainLinLayout.setOnLongClickListener( new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                int p = Integer.valueOf( view.getTag().toString() );
//                System.out.println( "LongClick: " + p );
//                ((FavoritesTaleListActivity) mActivity).deleteTale( taleList.get( p ).getTaleId() );
//                return false;// returning true instead of false, works for me
//            }
//        } );


    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }


    @Override
    public int getItemCount() {
        return serviceList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextViewEuphemiaUCASRegular tvTitle,tvTime;
        private CardView cardView;


        public MyViewHolder(View itemView) {
            super( itemView );

            tvTitle = (TextViewEuphemiaUCASRegular) itemView.findViewById( R.id.row_service_book_item_tv_title );
            tvTime = (TextViewEuphemiaUCASRegular) itemView.findViewById( R.id.row_service_book_item_tv_time );
            cardView = (CardView) itemView.findViewById( R.id.row_service_book_cardView );





        }

    }

    public void setList(ArrayList<ServiceModel> serviceList) {
        // TODO Auto-generated method stub
        this.serviceList = serviceList;
        notifyDataSetChanged();
    }



}




