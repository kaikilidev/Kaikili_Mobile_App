package com.sit.kaikiliService.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.sit.kaikiliService.KaikiliApplication;
import com.sit.kaikiliService.R;
import com.sit.kaikiliService.adapter.ServiceCatalogueListAdapter;
import com.sit.kaikiliService.font.TextViewEuphemiaUCASRegular;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by ketan patel on 28/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 */

public class ServiceCatalogueActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.top_back) ImageView top_back;
    @Bind(R.id.top_title) TextViewEuphemiaUCASRegular top_title;

    @Bind(R.id.service_catalogue_listView) ListView service_catalogue_listView;





    private KaikiliApplication application;
    private SharedPreferences preferences;
    private ArrayList<String> serviceList;
    private ServiceCatalogueListAdapter adapter;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_srevice_catalogue );
        ButterKnife.bind( this, this );

        application = (KaikiliApplication) getApplicationContext();
        preferences = application.getSharedPreferences();

        top_title.setText( "Service Catalogue" );
        top_back.setOnClickListener( this );


        serviceList = new ArrayList<>();
        serviceList.add("TV Mount Installation");
        serviceList.add("Carpet Cleaning");
        serviceList.add("Lawn Mowing");
        serviceList.add("Dishwasher Installation");
        serviceList.add("Interior Painting");
        serviceList.add("Water Heater Installation");
        serviceList.add("Fireplace Cleaning");
        serviceList.add("Moving Service");


        adapter = new ServiceCatalogueListAdapter( this );
        service_catalogue_listView.setAdapter(adapter);
        adapter.setList(serviceList);

    }



    @Override
    public void onClick(View view) {

        if (view == top_back) {
            finish();

        }
    }
}
