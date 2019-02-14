package com.sit.kaikiliService.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.sit.kaikiliService.KaikiliApplication;
import com.sit.kaikiliService.R;
import com.sit.kaikiliService.adapter.AddServiceListAdapter;
import com.sit.kaikiliService.api.GetAllServiceAPI;
import com.sit.kaikiliService.api.ServiceList;
import com.sit.kaikiliService.api.WebApiClient;
import com.sit.kaikiliService.comman.WithoutScrollListView;
import com.sit.kaikiliService.font.EditTextEupheminUCASRegular;
import com.sit.kaikiliService.font.TextViewEuphemiaUCASRegular;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


/**
 * Created by ketan patel on 28/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 */

public class AddServiceActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.top_back) ImageView top_back;
    @Bind(R.id.top_title) TextViewEuphemiaUCASRegular top_title;


    @Bind(R.id.add_service_edt_search) EditTextEupheminUCASRegular add_service_edt_search;
    @Bind(R.id.add_service_iv_remove) ImageView add_service_iv_remove;
    @Bind(R.id.add_service_listView_serviceList) WithoutScrollListView add_service_listView_serviceList;
    @Bind(R.id.add_service_listView_searchList) WithoutScrollListView add_service_listView_searchList;





    private KaikiliApplication application;
    private SharedPreferences preferences;
    private ArrayList<ServiceList> serviceList = new ArrayList<>(  );
    private ArrayList<ServiceList> filterList = new ArrayList<>(  );
    private AddServiceListAdapter adapter;
    private AddServiceListAdapter adapterSearch;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_srevice );
        ButterKnife.bind( this, this );

        application = (KaikiliApplication) getApplicationContext();
        preferences = application.getSharedPreferences();

        top_title.setText( "Add Services" );
        top_back.setOnClickListener( this );
        add_service_iv_remove.setOnClickListener( this );

        filterList = new ArrayList<>();

//        serviceList = new ArrayList<>();
//        serviceList.add("TV Mount Installation");
//        serviceList.add("Carpet Cleaning");
//        serviceList.add("Lawn Mowing");
//        serviceList.add("Dishwasher Installation");
//        serviceList.add("Interior Painting");
//        serviceList.add("Water Heater Installation");
//        serviceList.add("Fireplace Cleaning");
//        serviceList.add("Moving Service");
//        serviceList.add("Hair Cutting at Salon");
//        serviceList.add("Custom Cabinet Building");
//        serviceList.add("Water Softener Installation");
//        serviceList.add("Fence Painting");
//        serviceList.add("Home Theater System Installation");
//        serviceList.add("Roof Installation or Replacement");
//        serviceList.add("Upholstery and Furniture Cleaning");
//        serviceList.add("Lawn Mowing and Trimming");
//        serviceList.add("Popcorn Texture Removal");
//        serviceList.add("Drywall Repair and Texturing");
//        serviceList.add("Solar Panel Cleaning");

        adapter = new AddServiceListAdapter( this );
        adapterSearch = new AddServiceListAdapter( this );
        add_service_listView_serviceList.setAdapter(adapter);
        add_service_listView_searchList.setAdapter(adapterSearch);
        GetAllServiceAPI();
        adapterSearch.setList(filterList);




        add_service_edt_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //after the change calling the method and passing the search input
                filter(editable.toString());
            }
        });
    }


    private void filter(String text) {
        //new array list that will hold the filtered data
        ArrayList<ServiceList> filterdNames = new ArrayList<>();

        //looping through existing elements
        for (int i=0;i<serviceList.size();i++) {
            //if the existing elements contains the search input
            if (serviceList.get(i).getSr_title().toLowerCase().contains(text.toLowerCase())) {
                //adding the element to filtered list
                filterdNames.add(serviceList.get(i));
            }
        }

        //calling a method of the adapter class and passing the filtered list
        adapterSearch.setList(filterdNames);
    }

    @Override
    public void onClick(View view) {

        if (view == top_back) {
            finish();
        } else if (view == add_service_iv_remove) {
           add_service_edt_search.setText("");
            filterList = new ArrayList<>();
            adapterSearch.setList(filterList);
        }
    }


    public void GetAllServiceAPI() {
        try {
            WebApiClient.getInstance( this ).getWebApi().getAllAddService( "getAllAddService",
                    new Callback<GetAllServiceAPI>() {
                        @Override
                        public void success(GetAllServiceAPI getAllServiceAPI, Response response) {

                            if (getAllServiceAPI != null) {
                                if (getAllServiceAPI.getStatus() == 1) {
                                    serviceList = getAllServiceAPI.getData();
                                    adapter.setList(serviceList);
                                } else {
                                    Toast.makeText(AddServiceActivity.this, getAllServiceAPI.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            Toast.makeText(AddServiceActivity.this, handleError(error), Toast.LENGTH_SHORT).show();
                        }
                    } );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
