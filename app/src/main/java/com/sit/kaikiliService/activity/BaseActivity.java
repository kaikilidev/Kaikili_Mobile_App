package com.sit.kaikiliService.activity;

import android.accounts.NetworkErrorException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.sit.kaikiliService.R;

import retrofit.RetrofitError;


/**
 * Created by ketan patel on 21/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 *
 */


public class BaseActivity extends AppCompatActivity {

    public static final String FINISH_ALL_ACTIVITIES_ACTIVITY_ACTION = "com.ketan.FINISH_ALL_ACTIVITIES_ACTIVITY_ACTION";
    private BaseActivityReceiver baseActivityReceiver = new BaseActivityReceiver();
    public static final IntentFilter INTENT_FILTER = createIntentFilter();



    private static IntentFilter createIntentFilter() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(FINISH_ALL_ACTIVITIES_ACTIVITY_ACTION);
        return filter;
    }

    // Slider view
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        registerBaseActivityReceiver();


        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // clear FLAG_TRANSLUCENT_STATUS flag:
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            // finally change the color
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }



    }

    protected void registerBaseActivityReceiver() {
        registerReceiver(baseActivityReceiver, INTENT_FILTER);
    }

    protected void unRegisterBaseActivityReceiver() {
        unregisterReceiver(baseActivityReceiver);
    }

    public class BaseActivityReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(FINISH_ALL_ACTIVITIES_ACTIVITY_ACTION)) {
                finish();
            }
        }
    }

    /**
     * Close all previous activities.
     *
     **/
    protected void closeAllActivities() {
        sendBroadcast(new Intent(FINISH_ALL_ACTIVITIES_ACTIVITY_ACTION));
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        unRegisterBaseActivityReceiver();
    }


    protected void showToast(@StringRes int msgRes) {
        Toast.makeText(this, msgRes, Toast.LENGTH_SHORT).show();
    }

    public static String handleError(final RetrofitError error) {

        try {
            if (error != null) {
                if (error.getBody() != null) {
                    RestError body = (RestError) error.getBodyAs(RestError.class);

                    if (body.message != null) {
                        //CommonMethods.toast(body.message, true);
                        return body.message;
                    } else {
                        return "Something went wrong or may be you have lost the internet connection.";
                    }

                } else {
                    if (error.getMessage() != null) {
                        //CommonMethods.toast(error.getMessage(), true);
                        //return error.getMessage();
                        return "Something went wrong or may be you have lost the internet connection.";
                    } else {
                        // CommonMethods.toast(Commonmessage.NETWORK_ERROR, true);
                        return "Something went wrong or may be you have lost the internet connection.";
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof NetworkErrorException) {
                //System.out.println("ERROR NETWORK_ERROR == " + Commonmessage.NETWORK_ERROR);
                //CommonMethods.toast(Commonmessage.NETWORK_ERROR, true);
                return "Something went wrong or may be you have lost the internet connection.";
            } else {
                //System.out.println("ERROR UNKNOWN_ERROR == " + Commonmessage.UNKNOWN_ERROR);
                //CommonMethods.toast(Commonmessage.UNKNOWN_ERROR, true);
                return "Something went wrong or may be you have lost the internet connection.";
            }
        }


        return "Something went wrong or may be you have lost the internet connection.";
    }


    @JsonObject
    static class RestError {
        @JsonField
        public int status;

        @JsonField
        public String message;

    }

}
