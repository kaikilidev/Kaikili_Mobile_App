package com.sit.kaikiliService.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.sit.kaikiliService.R;
import com.sit.kaikiliService.adapter.NotificationCustomerListAdapter;
import com.sit.kaikiliService.adapter.NotificationListAdapter;
import com.sit.kaikiliService.font.TextViewEuphemiaUCASRegular;
import com.sit.kaikiliService.model.NotificationModel;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by ketan patel on 30/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 */

public class NotificationFragment extends BaseFragment {


    @Bind(R.id.fag_noti_ll_customer )LinearLayout fag_noti_ll_customer;
    @Bind(R.id.fag_noti_ll_kaikili )LinearLayout fag_noti_ll_kaikili;
    @Bind(R.id.fag_noti_tv_customer )TextViewEuphemiaUCASRegular fag_noti_tv_customer;
    @Bind(R.id.fag_noti_tv_kaikili )TextViewEuphemiaUCASRegular fag_noti_tv_kaikili;
    @Bind(R.id.fag_noti_tv_recyclerView )RecyclerView fag_noti_tv_recyclerView;
    @Bind(R.id.fag_noti_tv_custome_recyclerView )RecyclerView fag_noti_tv_custome_recyclerView;


    private NotificationListAdapter adapter;
    private NotificationCustomerListAdapter adapterCustomer;
    private ArrayList<NotificationModel> notificationList,notificationList2;

    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_notification, container, false);
       // initToolbar();
        ButterKnife.bind( this,rootView);
        initComponents(rootView);
        return rootView;
    }


    @Override
    public void initComponents(View rootView) {

        fag_noti_ll_kaikili.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        fag_noti_ll_customer.setBackgroundColor(getResources().getColor(R.color.transparent));
        fag_noti_tv_kaikili.setTextColor(getResources().getColor(R.color.white));
        fag_noti_tv_customer.setTextColor(getResources().getColor(R.color.colorAccent));

        fag_noti_ll_kaikili.setOnClickListener( this );
        fag_noti_ll_customer.setOnClickListener( this );

        adapter = new NotificationListAdapter( getActivity());
        adapterCustomer = new NotificationCustomerListAdapter(getActivity());

        fag_noti_tv_recyclerView.setLayoutManager(new LinearLayoutManager( getActivity() ) );
        fag_noti_tv_recyclerView.setAdapter(adapter);

        fag_noti_tv_custome_recyclerView.setLayoutManager(new LinearLayoutManager( getActivity() ) );
        fag_noti_tv_custome_recyclerView.setAdapter(adapterCustomer);


        notificationList = new ArrayList<>();
        notificationList2 = new ArrayList<>();
        adapter.setList( notificationList );
        adapterCustomer.setList( notificationList2 );

        setCustomerMessage();


    }

    @Override
    public void onClick(View v) {
        if(fag_noti_ll_kaikili == v) {
            fag_noti_ll_customer.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            fag_noti_tv_customer.setTextColor(getResources().getColor(R.color.white));
            fag_noti_ll_kaikili.setBackgroundColor(getResources().getColor(R.color.transparent));
            fag_noti_tv_kaikili.setTextColor(getResources().getColor(R.color.colorAccent));

            setKaikiliMessage();

        }else if(fag_noti_ll_customer == v){
            fag_noti_ll_kaikili.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            fag_noti_tv_kaikili.setTextColor(getResources().getColor(R.color.white));
            fag_noti_ll_customer.setBackgroundColor(getResources().getColor(R.color.transparent));
            fag_noti_tv_customer.setTextColor(getResources().getColor(R.color.colorAccent));
            setCustomerMessage();
        }
    }

    private void setCustomerMessage() {

        fag_noti_tv_custome_recyclerView.setVisibility( View.VISIBLE );
        fag_noti_tv_recyclerView.setVisibility( View.GONE );


        notificationList2 = new ArrayList<>( );
        NotificationModel model = new NotificationModel();
        model.setId("1" );
        model.setReadStatus( true );
        model.setTime( "01/10/2019 8:30 AM" );
        model.setTitle( "Bob F" );
        model.setMessage( "New: TV Mount Installation" );

        notificationList2.add( model );
        NotificationModel model2 = new NotificationModel();
        model2.setId("2" );
        model2.setReadStatus( true );
        model2.setTime( "01/09/2019 6:30 PM" );
        model2.setTitle( "Lucy M" );
        model2.setMessage( "New: Interior Painting" );
        notificationList2.add( model2 );


        NotificationModel model3 = new NotificationModel();
        model3.setId("3" );
        model3.setReadStatus( false );
        model3.setTime( "01/08/2019 4:30 PM" );
        model3.setTitle( "Sarah W" );
        model3.setMessage( "Reschedule: Lawn Mowing" );
        notificationList2.add( model3 );

        NotificationModel model4 = new NotificationModel();
        model4.setId("4" );
        model4.setReadStatus( false );
        model4.setTime( "01/08/2019 4:30 PM" );
        model4.setTitle( "Merry E" );
        model4.setMessage( "Confirmed: Dishwasher Installation" );
        notificationList2.add( model4);

        NotificationModel model5 = new NotificationModel();
        model5.setId("5" );
        model5.setReadStatus( false );
        model5.setTime( "01/09/2019 8:30 AM" );
        model5.setTitle( "Alex D" );
        model5.setMessage( "Cancelled: Carpet Cleaning" );
        notificationList2.add( model5 );

        adapterCustomer.setList( notificationList2);
    }

    private void setKaikiliMessage() {

        fag_noti_tv_custome_recyclerView.setVisibility( View.GONE );
        fag_noti_tv_recyclerView.setVisibility( View.VISIBLE );

        notificationList = new ArrayList<>( );
        NotificationModel model1 = new NotificationModel();
        model1.setId("1" );
        model1.setReadStatus( true );
        model1.setTime( "01/10/2019 8:30 AM" );
        model1.setTitle( "Alert: New Service Added" );
        notificationList.add( model1 );

        NotificationModel model2 = new NotificationModel();
        model2.setId("2" );
        model2.setReadStatus( true );
        model2.setTime( "01/10/2019 2:30 PM" );
        model2.setTitle( "Reminder: Carpet Cleaning" );
        notificationList.add( model2 );

        NotificationModel model3 = new NotificationModel();
        model3.setId("3" );
        model3.setReadStatus( false );
        model3.setTime( "01/08/2019 4:30 PM" );
        model3.setTitle( "Auto Cancel: Dishwasher Installation" );
        notificationList.add( model3 );

        NotificationModel model4 = new NotificationModel();
        model4.setId("4" );
        model4.setReadStatus( false );
        model4.setTime( "01/08/2019 4:30 PM" );
        model4.setTitle( "Auto Cancel: Dishwasher Installation" );
        notificationList.add( model4 );

        NotificationModel model5 = new NotificationModel();
        model5.setId("5" );
        model5.setReadStatus( false );
        model5.setTime( "01/08/2019 10:30 AM" );
        model5.setTitle( "Reminder: Carpet Cleaning" );
        notificationList.add( model5 );

        adapter.setList( notificationList );
    }
}
