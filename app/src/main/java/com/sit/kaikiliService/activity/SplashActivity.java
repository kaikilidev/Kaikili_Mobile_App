package com.sit.kaikiliService.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.sit.kaikiliService.KaikiliApplication;
import com.sit.kaikiliService.R;
import com.sit.kaikiliService.comman.AppLog;
import com.sit.kaikiliService.comman.Util;


/**
 * Created by ketan patel on 21/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 *
 */

public class SplashActivity extends BaseActivity {
    private static final short SPLASH_TIME = 2000;

//    private KaikiliApplication application;
    private ProgressDialog mDialog = null;
    private KaikiliApplication application;
    private SharedPreferences preferences;
    private String gcmRegistrationId = "";
    private static final int PERMISSION_REQUEST_CODE = 200;
    private static final int GPS_ON = 300;
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private AlertDialog dialog1;


    String[] perms = {"android.permission.ACCESS_FINE_LOCATION","android.permission.ACCESS_COARSE_LOCATION"};
//            "android.permission.CAMERA",
//            "android.permission.WRITE_EXTERNAL_STORAGE",
//            "android.permission.RECORD_AUDIO"};




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        application = (KaikiliApplication) getApplicationContext();
        preferences = application.getSharedPreferences();

        if(checkPlayServices()) {
            new SplashTask(SplashActivity.this).execute();
        }else {
            Util.displayDialog(getResources().getString(R.string.app_name), "This device is not supported. Please update google play store app.", this, false);
        }

    }


    private class SplashTask extends AsyncTask<Void, Void, Void> {

        public SplashTask(Context context) {
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {

            try {
                Thread.sleep(SPLASH_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            checkeAllParmisan();

        }

    }

    private void checkeAllParmisan() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

            if (checkWriteExternalPermission(perms[0]) && checkWriteExternalPermission(perms[1])){//&& checkWriteExternalPermission(perms[1]) && checkWriteExternalPermission(perms[2]) && checkWriteExternalPermission(perms[3])) {
//                callAppView();
                checkGPS();
            } else {
                requestPermissions(perms, PERMISSION_REQUEST_CODE);
            }

        }else {

            LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE );
            boolean statusOfGPS = manager.isProviderEnabled(LocationManager.GPS_PROVIDER);

            if(statusOfGPS){
//                callAppView();
                checkGPS();
            }else {
                turnGPSOn();
            }
        }

    }


    public void checkGPS(){


        LocationManager lm = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;

        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch(Exception ex) {}

        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch(Exception ex) {}

        if(!gps_enabled && !network_enabled) {
            // notify user
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setMessage(getString(R.string.msg_enable_location_service));
            dialog.setPositiveButton(this.getResources().getString(R.string.open_location_settings), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    // TODO Auto-generated method stub

                    Intent callGPSSettingIntent = new Intent( Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivityForResult(callGPSSettingIntent,GPS_ON);
                }
            });
            dialog.setNegativeButton("Exit", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    // TODO Auto-generated method stub
                    finish();

                }
            });
            dialog.show();
        }else {
            callAppView();
        }

    }

    private void turnGPSOn(){
        try{
            Intent intent = new Intent("android.location.GPS_ENABLED_CHANGE");
            intent.putExtra("enabled", true);
            this.sendBroadcast(intent);

            String provider = Settings.Secure.getString(getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
            if(!provider.contains("gps")){ //if gps is disabled
                final Intent poke = new Intent();
                poke.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
                poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
                poke.setData(Uri.parse("3"));
                this.sendBroadcast(poke);

            }
            callAppView();

        }catch (Exception e){
            showGPSDisabledAlertToUser();
        }
    }

    private void showGPSDisabledAlertToUser(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("GPS is disabled in your device. Would you like to enable it?")
                .setCancelable(false)
                .setPositiveButton("Goto Settings Page To Enable GPS"
                        , new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                Intent callGPSSettingIntent = new Intent( Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivityForResult(callGPSSettingIntent,GPS_ON);
//               startActivity(callGPSSettingIntent);
                            }
                        });
        alertDialogBuilder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        dialog.cancel();
                        finish();
                    }
                }
        );

        AlertDialog alert = alertDialogBuilder.create(); alert.show();
    }


    @Override
    protected void onPause() {
//        if(locationFinder != null) {
//            locationFinder.stopLocationUpdates();
//        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
//        if(locationFinder != null) {
//            locationFinder.stopLocationUpdates();
//        }
        super.onDestroy();

    }

    private void callAppView() {

            Intent intent = new Intent(this,PhoneNoValidationActivity.class);
//        Intent intent = new Intent(SplashActivity.this, RegistrationActivity.class);
//            intent.putExtra("GoTo", "Driver");
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            finish();

        if (preferences.getBoolean("AppTureShow", false)){
//            Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
//            intent.putExtra("GoTo", "Driver");
//            startActivity(intent);
//            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
//            finish();
        }else {
//                Intent intent = new Intent(SplashActivity.this, AppTureActivity.class);
//                intent.putExtra( "BeckHome",false);
//                startActivity(intent);
//                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
//                finish();
        }
    }


    private boolean checkPlayServices() {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {
                apiAvailability.getErrorDialog(this, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                AppLog.Log("TAG", "This device is not supported.");
//                finish();
            }
            return false;
        }
        return true;
    }


    @Override
    public void onRequestPermissionsResult(int permsRequestCode, String[] permissions, int[] grantResults){
//            case 200:
        if(permsRequestCode == 200){
            boolean locationAccepted = grantResults[0]== PackageManager.PERMISSION_GRANTED;
            boolean locationAccepted2 = grantResults[1]==PackageManager.PERMISSION_GRANTED;
//            boolean storageAccepted = grantResults[2]==PackageManager.PERMISSION_GRANTED;
//            boolean callPhoneAccepted = grantResults[3]==PackageManager.PERMISSION_GRANTED;


            if(locationAccepted && locationAccepted2 ){//&& cameraAccepted &&  storageAccepted && callPhoneAccepted){
                callAppView();
            }else {
                displayDialog();
            }
        }
    }

    public static int SETTING_PERMISSION_CODE = 110;

    public void displayDialog() {

        dialog1 = new AlertDialog.Builder(this)
                .setTitle("Permission needed")
                .setCancelable(false)
                .setMessage("All permissions are required without access to your phone. In order to identify calls you need to change your phone permission in settings.")
                .setPositiveButton("LET'S DO THIS", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete

                        dialog1.dismiss();
                        Intent intent = new Intent();
                        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", SplashActivity.this.getPackageName(), null);
                        intent.setData(uri);
                        startActivityForResult(intent, SETTING_PERMISSION_CODE);
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                        dialog1.dismiss();
                        finish();
                    }
                })
                .setIcon(R.mipmap.ic_launcher)
                .show();


    }


    private boolean checkWriteExternalPermission(String permissionName) {

        String permission = permissionName;
        int res = this.checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GPS_ON) {
//            Log.e("resultCode --> ",resultCode+"");
            checkeAllParmisan();
        }else if (requestCode == SETTING_PERMISSION_CODE) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                if (checkWriteExternalPermission(perms[0]) && checkWriteExternalPermission(perms[1]) && checkWriteExternalPermission(perms[2]) && checkWriteExternalPermission(perms[3])) {
//                    callAppView();
                    checkGPS();
                } else {
                    displayDialog();
                }
            } else {
//                callAppView();
                checkGPS();
            }

        }
    }


//    public void turnGPSOn(){
//        String provider = Settings.Secure.getString(getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
//
//        if(!provider.contains("gps")){ //if gps is disabled
//            final Intent poke = new Intent();
//            poke.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
//            poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
//            poke.setData(Uri.parse("3"));
//            sendBroadcast(poke);
//        }
//    }
}
