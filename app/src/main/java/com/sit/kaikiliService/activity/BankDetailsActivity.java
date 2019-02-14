package com.sit.kaikiliService.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.sit.kaikiliService.KaikiliApplication;
import com.sit.kaikiliService.R;
import com.sit.kaikiliService.adapter.BankDetailListAdapter;
import com.sit.kaikiliService.font.EditTextEupheminUCASRegular;
import com.sit.kaikiliService.font.TextViewEuphemiaUCASRegular;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by ketan patel on 2/2/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 */

public class BankDetailsActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.top_back)
    ImageView top_back;
    @Bind(R.id.top_title)
    TextViewEuphemiaUCASRegular top_title;

    @Bind(R.id.bank_details_tv_addNew)
    TextViewEuphemiaUCASRegular bank_details_tv_addNew;


    @Bind(R.id.bank_details_listview)
    ListView bank_details_listview;



    private KaikiliApplication application;
    private SharedPreferences preferences;
    private BankDetailListAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_bank_details );
        ButterKnife.bind( this, this );

        application = (KaikiliApplication) getApplicationContext();
        preferences = application.getSharedPreferences();

        top_title.setText( "Bank Details" );

        top_back.setOnClickListener( this );
        bank_details_tv_addNew.setOnClickListener( this );
        adapter = new BankDetailListAdapter( this );
        bank_details_listview.setAdapter( adapter );

        ArrayList<String> datalist =new ArrayList<>(  );
        datalist.add( "" );
        datalist.add( "" );
        datalist.add( "" );
        datalist.add( "" );
        datalist.add( "" );
        datalist.add( "" );

        adapter.setList(datalist);

    }



    @Override
    public void onClick(View view) {

        if (view == top_back) {
            finish();
        } else if (view == bank_details_tv_addNew) {
            Intent intent = new Intent( this,AddBankDetailsActivity.class );
            startActivity( intent );
        }
    }
}
