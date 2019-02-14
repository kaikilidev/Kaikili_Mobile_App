package com.sit.kaikiliService.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;

import com.sit.kaikiliService.KaikiliApplication;
import com.sit.kaikiliService.R;
import com.sit.kaikiliService.comman.BetterSpinner;
import com.sit.kaikiliService.comman.Util;
import com.sit.kaikiliService.font.EditTextEupheminUCASRegular;
import com.sit.kaikiliService.font.TextViewEuphemiaUCASRegular;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by ketan patel on 22/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 */

public class PersonalInformationActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.top_back)
    ImageView top_back;
    @Bind(R.id.top_title)
    TextViewEuphemiaUCASRegular top_title;
    @Bind(R.id.personal_info_edit_first)
    EditTextEupheminUCASRegular personal_info_edit_first;
    @Bind(R.id.personal_info_edit_last)
    EditTextEupheminUCASRegular personal_info_edit_last;
    @Bind(R.id.personal_info_edit_email)
    EditTextEupheminUCASRegular personal_info_edit_email;
    @Bind(R.id.personal_info_edit_dob)
    EditTextEupheminUCASRegular personal_info_edit_dob;
    @Bind(R.id.personal_info_bs_gender)
    BetterSpinner personal_info_bs_gender;

    @Bind(R.id.personal_info_fb_next)
    FloatingActionButton personal_info_fb_next;

    private KaikiliApplication application;
    private SharedPreferences preferences;

    private Calendar calendar;
    private int year, month, day;

    private String from = null;

    String date;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_personal_information );
        ButterKnife.bind( this, this );

        application = (KaikiliApplication) getApplicationContext();
        preferences = application.getSharedPreferences();

        top_title.setText( "Enter Personal Information" );

        calendar = Calendar.getInstance();
        year = calendar.get( Calendar.YEAR );
        month = calendar.get( Calendar.MONTH );
        day = calendar.get( Calendar.DAY_OF_MONTH );


        top_back.setOnClickListener( this );
        personal_info_fb_next.setOnClickListener( this );
//        personal_info_edit_dob.setOnClickListener( this );

        List<String> nameList = new ArrayList<>();
        nameList.add( "Male" );
        nameList.add( "Female " );

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                nameList );

        personal_info_bs_gender.setAdapter( arrayAdapter );

    }


    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // arg1 = year
            // arg2 = month
            // arg3 = daya
            showDate( arg1, arg2 + 1, arg3 );
        }
    };

    public void showDate(int year, int month, int day) {

        date = year + "-" + month + "-" + day;
        personal_info_edit_dob.setText( Util.getDateWithFormate( date, "yyyy-MM-dd", "MM/dd/yyyy" ) );
    }


    @Override
    public void onClick(View view) {

        if (view == top_back) {
            finish();
        } else if (view == personal_info_fb_next) {

            Intent intent = new Intent( this, TermsConditionsActivity.class );
            startActivity( intent );
            finish();
        } else if (view == personal_info_edit_dob) {
            DatePickerDialog datePickerDialog = new DatePickerDialog( this, myDateListener, year, month, day );
            //datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
//                if (PreferenceHelper.getInstance(mainActivity).getString(Common.LOGIN_GENDER).equals("Female")) {
            datePickerDialog.getDatePicker().setMaxDate( (long) (System.currentTimeMillis() - 5.676e+11) );
//                } else {
//                    datePickerDialog.getDatePicker().setMaxDate((long) (System.currentTimeMillis() - 6.623e+11));
//                }
            datePickerDialog.show();
            datePickerDialog.getButton( DatePickerDialog.BUTTON_NEGATIVE ).setTextColor( Color.RED );
            datePickerDialog.getButton( DatePickerDialog.BUTTON_POSITIVE ).setTextColor( Color.RED );
        }
    }
}
