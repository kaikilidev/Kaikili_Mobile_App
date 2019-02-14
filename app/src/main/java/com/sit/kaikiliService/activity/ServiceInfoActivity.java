package com.sit.kaikiliService.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.sit.kaikiliService.KaikiliApplication;
import com.sit.kaikiliService.R;
import com.sit.kaikiliService.adapter.ServiceInfoItemAdapter;
import com.sit.kaikiliService.comman.WithoutScrollListView;
import com.sit.kaikiliService.font.TextViewEuphemiaUCASRegular;
import com.sit.kaikiliService.model.ServiceInfoModel;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by ketan patel on 31/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 */

public class ServiceInfoActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.top_back)
    ImageView top_back;
    @Bind(R.id.top_title)
    TextViewEuphemiaUCASRegular top_title;
    @Bind(R.id.service_info_listView)
    WithoutScrollListView service_info_listView;

    private KaikiliApplication application;
    private SharedPreferences preferences;
    private ServiceInfoItemAdapter adapter;
    private ArrayList<ServiceInfoModel> serviceInfoList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_service_info );
        ButterKnife.bind( this, this );

        application = (KaikiliApplication) getApplicationContext();
        preferences = application.getSharedPreferences();

        top_title.setText( "Service Detail" );
        top_back.setOnClickListener( this );

        adapter = new ServiceInfoItemAdapter( this );
        service_info_listView.setAdapter( adapter );

        serviceInfoList = new ArrayList<>();
        ServiceInfoModel model = new ServiceInfoModel();
        model.setName( "Int Wall Painting 2500/$0.25" );
        model.setAmount( "65.00" );
        serviceInfoList.add( model );

        ServiceInfoModel model1 = new ServiceInfoModel();
        model1.setName( "Number of Doors 6@$10" );
        model1.setAmount( "60.00" );
        serviceInfoList.add( model1 );

        ServiceInfoModel model2 = new ServiceInfoModel();
        model2.setName( "Number of Windows 10@$5" );
        model2.setAmount( "50.00" );
        serviceInfoList.add( model2 );

        ServiceInfoModel model3 = new ServiceInfoModel();
        model3.setName( "Number of Closet 8@10" );
        model3.setAmount( "80.00" );
        serviceInfoList.add( model3 );

        ServiceInfoModel model4 = new ServiceInfoModel();
        model4.setName( "Top Trim Sq Footage 1000@$0.1" );
        model4.setAmount( "100.00" );
        serviceInfoList.add( model4 );

        ServiceInfoModel model5 = new ServiceInfoModel();
        model5.setName( "Bottom Trim Sq Footage1000@$0.1" );
        model5.setAmount( "100.00" );
        serviceInfoList.add( model5 );

        adapter.setList( serviceInfoList );

    }


    @Override
    public void onClick(View view) {

        if (view == top_back) {
            finish();

        }
    }
}
