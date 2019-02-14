package com.sit.kaikiliService.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.rilixtech.Country;
import com.rilixtech.CountryCodePicker;
import com.sit.kaikiliService.KaikiliApplication;
import com.sit.kaikiliService.R;
import com.sit.kaikiliService.font.EditTextEupheminUCASRegular;
import com.sit.kaikiliService.font.TextViewEuphemiaUCASRegular;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by ketan patel on 22/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 */

public class PhoneNoValidationActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.top_back)
    ImageView top_back;


    @Bind(R.id.top_title)
    TextViewEuphemiaUCASRegular top_title;

    @Bind(R.id.ccp)
    CountryCodePicker ccp;

    @Bind(R.id.phone_number_next)
    FloatingActionButton phone_number_next;

    @Bind(R.id.phone_number_edt)
    EditTextEupheminUCASRegular phone_number_edt;

    private KaikiliApplication application;
    private SharedPreferences preferences;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_phone_no_validation );
        ButterKnife.bind( this, this );

        top_title.setText( "Phone Number Validation" );

        application = (KaikiliApplication) getApplicationContext();
        preferences = application.getSharedPreferences();

        top_back.setOnClickListener( this );
        phone_number_next.setOnClickListener( this );

        ccp.registerPhoneNumberTextView( phone_number_edt );
        ccp.setOnCountryChangeListener( new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected(Country selectedCountry) {
                Toast.makeText( PhoneNoValidationActivity.this, "Updated " + selectedCountry.getName(), Toast.LENGTH_SHORT ).show();
            }
        } );

    }


    @Override
    public void onClick(View view) {

        if (view == top_back) {
            finish();
        } else if (view == phone_number_next) {
            Intent intent = new Intent( PhoneNoValidationActivity.this, PhoneValidationCodeActivity.class );
            startActivity( intent );
            finish();
        }
    }
}
