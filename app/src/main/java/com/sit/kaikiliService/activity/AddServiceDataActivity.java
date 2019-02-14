package com.sit.kaikiliService.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.sit.kaikiliService.KaikiliApplication;
import com.sit.kaikiliService.R;
import com.sit.kaikiliService.adapter.AddServiceItemAdapter;
import com.sit.kaikiliService.api.ServiceList;
import com.sit.kaikiliService.comman.WithoutScrollListView;
import com.sit.kaikiliService.font.EditTextEupheminUCASRegular;
import com.sit.kaikiliService.font.TextViewEuphemiaUCASBola;
import com.sit.kaikiliService.font.TextViewEuphemiaUCASRegular;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by ketan patel on 29/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 */

public class AddServiceDataActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.top_back)
    ImageView top_back;
    @Bind(R.id.top_title)
    TextViewEuphemiaUCASRegular top_title;


    @Bind(R.id.add_service_data_iv_switch)
    ImageView add_service_data_iv_switch;
    @Bind(R.id.add_service_data_listView_costPerItem)
    WithoutScrollListView add_service_data_listView_costPerItem;
    @Bind(R.id.add_service_data_tv_costPerItem)
    TextViewEuphemiaUCASRegular add_service_data_tv_costPerItem;
    @Bind(R.id.add_service_data_view_costPerItem)
    View add_service_data_view_costPerItem;
    @Bind(R.id.add_service_data_listView_costPerSize)
    WithoutScrollListView add_service_data_listView_costPerSize;
    @Bind(R.id.add_service_data_tv_costPerSize)
    TextViewEuphemiaUCASRegular add_service_data_tv_costPerSize;
    @Bind(R.id.add_service_data_view_costPerSize)
    View add_service_data_view_costPerSize;


    @Bind(R.id.add_service_data_edt_quoteService)
    EditTextEupheminUCASRegular add_service_data_edt_quoteService;
    @Bind(R.id.add_service_data_tv_quote)
    TextViewEuphemiaUCASRegular add_service_data_tv_quote;
    @Bind(R.id.add_service_data_tv_costHelper)
    TextViewEuphemiaUCASRegular add_service_data_tv_costHelper;
    @Bind(R.id.add_service_data_tv_note)
    TextViewEuphemiaUCASBola add_service_data_tv_note;

    @Bind(R.id.row_add_service_offer_tv_title)
    TextViewEuphemiaUCASRegular row_add_service_offer_tv_title;


    private KaikiliApplication application;
    private SharedPreferences preferences;
    private AddServiceItemAdapter adapterCostPerItme;
    private AddServiceItemAdapter adapterCostPerSize;

    private ArrayList<String> costPerItem;
    private ArrayList<String> costPerItem1;
    private ArrayList<String> costPerItem2;
    private ArrayList<String> costPerItem3;
    private ArrayList<String> costPerSize;
    private ServiceList serviceList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_srevice_data );
        ButterKnife.bind( this, this );

        application = (KaikiliApplication) getApplicationContext();
        preferences = application.getSharedPreferences();


        serviceList = (ServiceList) getIntent().getSerializableExtra( "serviceName" );

        top_title.setText( serviceList.getSr_title() );
        top_back.setOnClickListener( this );
        add_service_data_iv_switch.setOnClickListener( this );
        add_service_data_iv_switch.setTag( "1" );


        adapterCostPerItme = new AddServiceItemAdapter( this );
        adapterCostPerSize = new AddServiceItemAdapter( this );

        add_service_data_listView_costPerItem.setAdapter( adapterCostPerItme );
        add_service_data_listView_costPerSize.setAdapter( adapterCostPerSize );


        Log.e( "------------", serviceList.getCost_comps_per_item().size() +" item");
        Log.e( "------------", serviceList.getCost_comps_pro_rated().size() +" item");

        add_service_data_edt_quoteService.setVisibility( View.GONE );
        add_service_data_tv_quote.setVisibility( View.GONE );
        add_service_data_listView_costPerSize.setVisibility( View.GONE );
        add_service_data_tv_costPerSize.setVisibility( View.GONE );
        add_service_data_view_costPerSize.setVisibility( View.GONE );
        add_service_data_listView_costPerItem.setVisibility( View.GONE );
        add_service_data_tv_costPerItem.setVisibility( View.GONE );
        add_service_data_view_costPerItem.setVisibility( View.GONE );


        if (serviceList.getCost_comps_pro_rated().size()>0) {
            add_service_data_listView_costPerSize.setVisibility( View.VISIBLE );
            add_service_data_tv_costPerSize.setVisibility( View.VISIBLE );
            add_service_data_view_costPerSize.setVisibility( View.VISIBLE );
        }

        if (serviceList.getCost_comps_per_item().size()>0 ) {
            add_service_data_listView_costPerItem.setVisibility( View.VISIBLE );
            add_service_data_tv_costPerItem.setVisibility( View.VISIBLE );
            add_service_data_view_costPerItem.setVisibility( View.VISIBLE );
        }

        adapterCostPerSize.setList( serviceList.getCost_comps_pro_rated() );
        adapterCostPerItme.setList( serviceList.getCost_comps_per_item() );

        row_add_service_offer_tv_title.setText( serviceList.getDiscount().getDs_title() );


    }


    @Override
    public void onClick(View view) {

        if (view == top_back) {
            finish();

        } else if (view == add_service_data_iv_switch) {
            if (view.getTag().toString().equalsIgnoreCase( "1" )) {
                add_service_data_iv_switch.setTag( "0" );
                add_service_data_iv_switch.setImageDrawable( getDrawable( R.drawable.icon_off_swich ) );
            } else {
                add_service_data_iv_switch.setTag( "1" );
                add_service_data_iv_switch.setImageDrawable( getDrawable( R.drawable.icon_on_swich ) );
            }
        }
    }
}
