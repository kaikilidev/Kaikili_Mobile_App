package com.sit.kaikiliService.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.sit.kaikiliService.KaikiliApplication;
import com.sit.kaikiliService.R;
import com.sit.kaikiliService.font.CustomEditText;
import com.sit.kaikiliService.font.TextViewEuphemiaUCASRegular;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by ketan patel on 25/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 */

public class SelectLocationActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.top_back)
    ImageView top_back;

    @Bind(R.id.top_title)
    TextViewEuphemiaUCASRegular top_title;
    @Bind(R.id.user_location_edt_search)
    CustomEditText user_location_edt_search;
    @Bind(R.id.user_location_tv_setLocation)    TextViewEuphemiaUCASRegular user_location_tv_setLocation;


    private KaikiliApplication application;
    private SharedPreferences preferences;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_user_location );
        ButterKnife.bind( this, this );

        application = (KaikiliApplication) getApplicationContext();
        preferences = application.getSharedPreferences();

        top_title.setText( "Set Your Work Location" );
        top_back.setOnClickListener( this );


//        user_location_edt_search.addTextChangedListener( new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//            }
//        } );


        user_location_edt_search.setDrawableClickListener(
                new CustomEditText.DrawableClickListener() {
                    @Override
                    public void onClick(DrawablePosition target) {
                        if (target == DrawablePosition.RIGHT) {
//                            if (GPSLocation.getInstance().getStoredLatLng() == null) return;
//                            mGoogleMap.clear();
////                            selectedCoords = GPSLocation.getInstance().getStoredLatLng();
//                            selectedCoords = new LatLng( application.getLatitude(), application.getLongitude() );
//
//                            mGoogleMap.addMarker( new MarkerOptions().position( selectedCoords ) );
//                            mGoogleMap.animateCamera( CameraUpdateFactory.newLatLngZoom( selectedCoords, 12 ) );
//                            //    hideKeyboard();
//                            initCoordinates();
                            // etSearchLocation.setText("");
                        }
                        if (target == DrawablePosition.LEFT) {
                            user_location_edt_search.setText( "" );
                        }
                    }
                } );
    }


    @Override
    public void onClick(View view) {

        if (view == top_back) {
            finish();
        }else if(view == user_location_tv_setLocation) {
            finish();
        }
    }
}
