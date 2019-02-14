package com.sit.kaikiliService.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;

import com.sit.kaikiliService.KaikiliApplication;
import com.sit.kaikiliService.R;
import com.sit.kaikiliService.font.EditTextEupheminUCASRegular;
import com.sit.kaikiliService.font.TextViewEuphemiaUCASRegular;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by ketan patel on 26/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 */

public class AddBankDetailsActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.top_back)
    ImageView top_back;
    @Bind(R.id.top_title)
    TextViewEuphemiaUCASRegular top_title;
    @Bind(R.id.add_card_edit_cardNumbers)
    EditTextEupheminUCASRegular add_card_edit_cardNumbers;
    @Bind(R.id.add_card_edit_date)
    EditTextEupheminUCASRegular add_card_edit_date;


    private KaikiliApplication application;
    private SharedPreferences preferences;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_bank_details );
        ButterKnife.bind( this, this );

        application = (KaikiliApplication) getApplicationContext();
        preferences = application.getSharedPreferences();

        top_title.setText( "Add Bank Details" );

        top_back.setOnClickListener( this );
        add_card_edit_cardNumbers.addTextChangedListener( new CreditCardNumberFormattingTextWatcher() );
        add_card_edit_date.addTextChangedListener( new DateAndYearFormattingTextWatcher() );

    }

    public static class CreditCardNumberFormattingTextWatcher implements TextWatcher {
        private static final char space = '-';

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {

            if (s.length() > 0 && (s.length() % 5) == 0) {
                final char c = s.charAt( s.length() - 1 );
                if (space == c) {
                    s.delete( s.length() - 1, s.length() );
                }
            }
            // Insert char where needed.
            if (s.length() > 0 && (s.length() % 5) == 0) {
                char c = s.charAt( s.length() - 1 );
                // Only if its a digit where there should be a space we insert a space
                if (Character.isDigit( c ) && TextUtils.split( s.toString(), String.valueOf( space ) ).length <= 3) {
                    s.insert( s.length() - 1, String.valueOf( space ) );
                }

            }
        }
    }

    public static class DateAndYearFormattingTextWatcher implements TextWatcher {

        private static final char space = '/';

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.length() > 0 && (s.length() % 3) == 0) {
                final char c = s.charAt( s.length() - 1 );
                if (space == c) {
                    s.delete( s.length() - 1, s.length() );
                }
            }
            // Insert char where needed.
            if (s.length() > 0 && (s.length() % 3) == 0) {
                char c = s.charAt( s.length() - 1 );
                // Only if its a digit where there should be a space we insert a space
                if (Character.isDigit( c ) && TextUtils.split( s.toString(), String.valueOf( space ) ).length <= 3) {
                    s.insert( s.length() - 1, String.valueOf( space ) );
                }
            }
        }
    }


    @Override
    public void onClick(View view) {

        if (view == top_back) {
            finish();
//        } else if (view == background_form_tv_submit) {
//            finish();
        }
    }
}
