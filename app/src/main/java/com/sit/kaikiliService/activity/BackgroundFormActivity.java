package com.sit.kaikiliService.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.sit.kaikiliService.KaikiliApplication;
import com.sit.kaikiliService.R;
import com.sit.kaikiliService.font.EditTextEupheminUCASRegular;
import com.sit.kaikiliService.font.TextViewEuphemiaUCASRegular;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by ketan patel on 24/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 */

public class BackgroundFormActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.top_back) ImageView top_back;
    @Bind(R.id.top_title) TextViewEuphemiaUCASRegular top_title;

    @Bind( R.id.background_form_edit_first) EditTextEupheminUCASRegular background_form_edit_first;
    @Bind( R.id.background_form_edit_middle) EditTextEupheminUCASRegular background_form_edit_middle;
    @Bind( R.id.background_form_edit_last) EditTextEupheminUCASRegular background_form_edit_last;
    @Bind( R.id.background_form_edit_address) EditTextEupheminUCASRegular background_form_edit_address;
    @Bind( R.id.background_form_edit_city) EditTextEupheminUCASRegular background_form_edit_city;
    @Bind( R.id.background_form_edit_zip) EditTextEupheminUCASRegular background_form_edit_zip;
    @Bind( R.id.background_form_edit_st) EditTextEupheminUCASRegular background_form_edit_st;
    @Bind( R.id.background_form_edit_ssn) EditTextEupheminUCASRegular background_form_edit_ssn;

        @Bind( R.id.background_form_tv_submit) TextViewEuphemiaUCASRegular background_form_tv_submit;


    private KaikiliApplication application;
    private SharedPreferences preferences;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_background_form );
        ButterKnife.bind( this, this );

        application = (KaikiliApplication) getApplicationContext();
        preferences = application.getSharedPreferences();

        top_title.setText( "Background Check Form" );

        top_back.setOnClickListener( this );
        background_form_tv_submit.setOnClickListener( this );

    }




    @Override
    public void onClick(View view) {

        if (view == top_back) {
            finish();
        } else if (view == background_form_tv_submit) {
            finish();
        }
    }
}
