package com.sit.kaikiliService.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.sit.kaikiliService.KaikiliApplication;
import com.sit.kaikiliService.R;
import com.sit.kaikiliService.font.TextViewEuphemiaUCASRegular;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ketan patel on 21/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 *
 */


public class RegistrationActivity extends BaseActivity implements View.OnClickListener {


    @Bind(R.id.reg_iv_addServices) ImageView reg_iv_addServices;
    @Bind(R.id.reg_iv_bankDetails) ImageView reg_iv_bankDetails;
    @Bind(R.id.reg_iv_createProfile) ImageView reg_iv_createProfile;
    @Bind(R.id.reg_iv_personalInformation) ImageView reg_iv_personalInformation;
    @Bind(R.id.reg_iv_phoneVerification)  ImageView reg_iv_phoneVerification;

    @Bind(R.id.reg_tv_addServices) TextViewEuphemiaUCASRegular reg_tv_addServices;
    @Bind(R.id.reg_tv_bankDetails) TextViewEuphemiaUCASRegular reg_tv_bankDetails;
    @Bind(R.id.reg_tv_createProfile) TextViewEuphemiaUCASRegular reg_tv_createProfile;
    @Bind(R.id.reg_tv_goHome) TextViewEuphemiaUCASRegular reg_tv_goHome;
    @Bind(R.id.reg_tv_personalInformation) TextViewEuphemiaUCASRegular reg_tv_personalInformation;
    @Bind(R.id.reg_tv_phoneVerification) TextViewEuphemiaUCASRegular reg_tv_phoneVerification;

    private KaikiliApplication application;
    private SharedPreferences preferences;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this, this);
        application = (KaikiliApplication) getApplicationContext();
        preferences = application.getSharedPreferences();

        reg_tv_addServices.setOnClickListener( this );
        reg_tv_bankDetails.setOnClickListener( this );
        reg_tv_createProfile.setOnClickListener( this );
        reg_tv_personalInformation.setOnClickListener( this );
        reg_tv_phoneVerification.setOnClickListener( this );
        reg_tv_goHome.setOnClickListener( this );

    }


    @Override
    public void onClick(View view) {

        if(view == reg_tv_phoneVerification){
            Intent intent = new Intent(this,PhoneNoValidationActivity.class);
            startActivity(intent);
        }else if(view == reg_tv_personalInformation){
            Intent intent = new Intent(this,PersonalInformationActivity.class);
            startActivity(intent);
        }else if(view == reg_tv_createProfile){
            Intent intent = new Intent(this,ProfileEditActivity.class);
            startActivity(intent);
        }else if(view == reg_tv_addServices){
            Intent intent = new Intent(this,AddServiceActivity.class);
            startActivity(intent);
        }else if(view == reg_tv_bankDetails){
            Intent intent = new Intent(this,AddBankDetailsActivity.class);
            startActivity(intent);
        }else if(view == reg_tv_goHome){
            Intent intent = new Intent(this,HomeScreenActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
