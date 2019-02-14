package com.sit.kaikiliService;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import java.io.File;


/**
 * Created by ketan patel on 21/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 *
 */


public class KaikiliApplication extends MultiDexApplication {




    private SharedPreferences sharedPreferences;
    private boolean isChetOpen = false;
    private boolean isAppOpen = false;

    public boolean isAppOpen() {
        return isAppOpen;
    }

    public void setAppOpen(boolean isAppOpen) {
        this.isAppOpen = isAppOpen;
    }

    public boolean isChetOpen() {
        return isChetOpen;
    }

    public void setChetOpen(boolean isChetOpen) {
        this.isChetOpen = isChetOpen;
    }

//    private DBHelper dbHelper;

    private String rootPath;
    public static double latitude =0, longitude=0;
//    public GPSService mGPSService;


    public String getRootPath() {
        return rootPath;
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        MultiDex.install(this);
        super.onCreate();
//        Fabric.with(this, new Crashlytics());


//        Environment.getDataDirectory()
//        mGPSService = new GPSService(this);
//        File f = new File(Environment.getDataDirectory(), "subdir");

//		rootPath = Environment.getExternalStorageDirectory()+"/.TranScanApp/DeviationImageFile";
//        String content = "hello world";
//        File file = new File(getCacheDir(), "MyCache");
//        rootPath = file.getAbsolutePath();
//        AppLog.Log("File Save Path ",rootPath);

        rootPath = Environment.getExternalStorageDirectory()+ File.separator+"DropTale"+File.separator+"ImageFile";


        File folder = new File(rootPath);

        if (!folder.exists()) {
            folder.mkdirs();
        }


        sharedPreferences = this.getSharedPreferences(getString(R.string.pref_key_sharedPreference), Context.MODE_PRIVATE);

//        dbHelper = new DBHelper(this);
//        try {
//            dbHelper.createDataBase();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        dbHelper.openDataBase();




    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

//    public DBHelper getDbHelper() {
//        return dbHelper;
//    }

//    @Override
//    public void onTerminate() {
//        super.onTerminate();
//
//        if (dbHelper != null) {
//            dbHelper.close();
//        }
//
////        mGPSService.closeGPS();
//    }


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        KaikiliApplication.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        KaikiliApplication.longitude = longitude;
    }





}
