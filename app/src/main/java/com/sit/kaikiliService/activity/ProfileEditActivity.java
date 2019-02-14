package com.sit.kaikiliService.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;

import com.sit.kaikiliService.KaikiliApplication;
import com.sit.kaikiliService.R;
import com.sit.kaikiliService.camera.Config;
import com.sit.kaikiliService.camera.ImagePickerActivity;
import com.sit.kaikiliService.comman.Util;
import com.sit.kaikiliService.font.EditTextEupheminUCASRegular;
import com.sit.kaikiliService.font.TextViewEuphemiaUCASRegular;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by ketan patel on 23/1/2019 - 25-1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 */

public class ProfileEditActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.top_back)
    ImageView top_back;
    @Bind(R.id.top_title)
    TextViewEuphemiaUCASRegular top_title;


    @Bind(R.id.about_profile_cb_mon)
    CheckBox about_profile_cb_mon;
    @Bind(R.id.about_profile_cb_tue)
    CheckBox about_profile_cb_tue;
    @Bind(R.id.about_profile_cb_wed)
    CheckBox about_profile_cb_wed;
    @Bind(R.id.about_profile_cb_thu)
    CheckBox about_profile_cb_thu;
    @Bind(R.id.about_profile_cb_fri)
    CheckBox about_profile_cb_fri;
    @Bind(R.id.about_profile_cb_sat)
    CheckBox about_profile_cb_sat;
    @Bind(R.id.about_profile_cb_sun)
    CheckBox about_profile_cb_sun;

    @Bind(R.id.about_profile_tv_mon)
    TextViewEuphemiaUCASRegular about_profile_tv_mon;
    @Bind(R.id.about_profile_tv_tue)
    TextViewEuphemiaUCASRegular about_profile_tv_tue;
    @Bind(R.id.about_profile_tv_wed)
    TextViewEuphemiaUCASRegular about_profile_tv_wed;
    @Bind(R.id.about_profile_tv_thu)
    TextViewEuphemiaUCASRegular about_profile_tv_thu;
    @Bind(R.id.about_profile_tv_fri)
    TextViewEuphemiaUCASRegular about_profile_tv_fri;
    @Bind(R.id.about_profile_tv_sat)
    TextViewEuphemiaUCASRegular about_profile_tv_sat;
    @Bind(R.id.about_profile_tv_sun)
    TextViewEuphemiaUCASRegular about_profile_tv_sun;

    @Bind(R.id.about_profile_tv_monStart)
    TextViewEuphemiaUCASRegular about_profile_tv_monStart;
    @Bind(R.id.about_profile_tv_tueStart)
    TextViewEuphemiaUCASRegular about_profile_tv_tueStart;
    @Bind(R.id.about_profile_tv_wedStart)
    TextViewEuphemiaUCASRegular about_profile_tv_wedStart;
    @Bind(R.id.about_profile_tv_thuStart)
    TextViewEuphemiaUCASRegular about_profile_tv_thuStart;
    @Bind(R.id.about_profile_tv_friStart)
    TextViewEuphemiaUCASRegular about_profile_tv_friStart;
    @Bind(R.id.about_profile_tv_satStart)
    TextViewEuphemiaUCASRegular about_profile_tv_satStart;
    @Bind(R.id.about_profile_tv_sunStart)
    TextViewEuphemiaUCASRegular about_profile_tv_sunStart;

    @Bind(R.id.about_profile_tv_monEnd)
    TextViewEuphemiaUCASRegular about_profile_tv_monEnd;
    @Bind(R.id.about_profile_tv_tueEnd)
    TextViewEuphemiaUCASRegular about_profile_tv_tueEnd;
    @Bind(R.id.about_profile_tv_wedEnd)
    TextViewEuphemiaUCASRegular about_profile_tv_wedEnd;
    @Bind(R.id.about_profile_tv_thuEnd)
    TextViewEuphemiaUCASRegular about_profile_tv_thuEnd;
    @Bind(R.id.about_profile_tv_friEnd)
    TextViewEuphemiaUCASRegular about_profile_tv_friEnd;
    @Bind(R.id.about_profile_tv_satEnd)
    TextViewEuphemiaUCASRegular about_profile_tv_satEnd;
    @Bind(R.id.about_profile_tv_sunEnd)
    TextViewEuphemiaUCASRegular about_profile_tv_sunEnd;

    @Bind(R.id.about_profile_cb_leisureDay)
    CheckBox about_profile_cb_leisureDay;
    @Bind(R.id.about_profile_tv_leisureDay)
    TextViewEuphemiaUCASRegular about_profile_tv_leisureDay;
    @Bind(R.id.about_profile_tv_leisureDayStartDate)
    TextViewEuphemiaUCASRegular about_profile_tv_leisureDayStartDate;
    @Bind(R.id.about_profile_tv_leisureDayStartTime)
    TextViewEuphemiaUCASRegular about_profile_tv_leisureDayStartTime;
    @Bind(R.id.about_profile_tv_leisureDayEndDate)
    TextViewEuphemiaUCASRegular about_profile_tv_leisureDayEndDate;
    @Bind(R.id.about_profile_tv_leisureDayEndTime)
    TextViewEuphemiaUCASRegular about_profile_tv_leisureDayEndTime;

    @Bind(R.id.about_profile_cb_nearByLastMin)
    CheckBox about_profile_cb_nearByLastMin;

    @Bind(R.id.about_profile_edt_about)
    EditTextEupheminUCASRegular about_profile_edt_about;
    @Bind(R.id.about_profile_edt_website)
    EditTextEupheminUCASRegular about_profile_edt_website;
    @Bind(R.id.about_profile_edt_linkedin)
    EditTextEupheminUCASRegular about_profile_edt_linkedin;
    @Bind(R.id.about_profile_tv_radius)
    TextViewEuphemiaUCASRegular about_profile_tv_radius;
    @Bind(R.id.about_profile_edt_area)
    EditTextEupheminUCASRegular about_profile_edt_area;


    @Bind(R.id.about_profile_edt_nearMiles)
    EditTextEupheminUCASRegular about_profile_edt_nearMiles;
    @Bind(R.id.about_profile_edt_nearOff)
    EditTextEupheminUCASRegular about_profile_edt_nearOff;
    @Bind(R.id.about_profile_edt_leisureDayOff)
    EditTextEupheminUCASRegular about_profile_edt_leisureDayOff;


    @Bind(R.id.about_profile_tv_backgroundCheck)
    TextViewEuphemiaUCASRegular about_profile_tv_backgroundCheck;
    @Bind(R.id.about_profile_seekbar_radius)
    DiscreteSeekBar about_profile_seekbar_radius;

    @Bind(R.id.about_profile_iv_newAdd)
    ImageView about_profile_iv_newAdd;
    @Bind(R.id.about_profile_civ_profile)
    ImageView about_profile_civ_profile;


    String[] perms = {"android.permission.CAMERA",
            "android.permission.WRITE_EXTERNAL_STORAGE",
            "android.permission.READ_EXTERNAL_STORAGE"};

    private KaikiliApplication application;
    private SharedPreferences preferences;
    private Calendar calendar;
    private int year, month, day;
    private String date;
    private int setDatePos = 0;
    protected int mRadius = 10;
    private int MAP_CODE = 120;
    private static final int PERMISSION_REQUEST_CODE = 200;
    private String imgPicturePath1, imgPicturePath2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_edit_profile );
        ButterKnife.bind( this, this );

        calendar = Calendar.getInstance();
        year = calendar.get( Calendar.YEAR );
        month = calendar.get( Calendar.MONTH );
        day = calendar.get( Calendar.DAY_OF_MONTH );

        application = (KaikiliApplication) getApplicationContext();
        preferences = application.getSharedPreferences();

        imgPicturePath1 = null;
        imgPicturePath2 = null;

        top_title.setText( "Create Profile" );
        top_back.setOnClickListener( this );
        about_profile_tv_backgroundCheck.setOnClickListener( this );
        about_profile_tv_leisureDayStartDate.setOnClickListener( this );
        about_profile_tv_leisureDayEndDate.setOnClickListener( this );
        about_profile_civ_profile.setOnClickListener( this );
        about_profile_iv_newAdd.setOnClickListener( this );

        about_profile_seekbar_radius.setNumericTransformer( new DiscreteSeekBar.NumericTransformer() {
            @Override
            public int transform(int value) {
                return value * 10;
            }
        } );
        about_profile_tv_radius.setText( Util.fromHtml( String.format( "Radius: %s Miles", mRadius ) ) );

        about_profile_seekbar_radius.setOnProgressChangeListener( new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
                int convert = value * 10;
                mRadius = convert;
                about_profile_tv_radius.setText( Util.fromHtml( String.format( "Radius: %s Miles", mRadius ) ) );
//                if (mRadiusCircle == null) return;
//                mRadiusCircle.setRadius( convert );

//                LatLng myLatLng = new LatLng( application.getLatitude(), application.getLongitude() );
//                if (mRadius > 0) {
//                    int zoom = getZoomLevel( mRadiusCircle );
//                    mGoogleMap.animateCamera( CameraUpdateFactory.newLatLngZoom( selectedCoords, zoom ) );
//                } else {
//                    mGoogleMap.animateCamera( CameraUpdateFactory.newLatLngZoom( selectedCoords, 16 ) );
//                }
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {
//                getNearbyTales( "Searching Nearest Tales .." );
            }
        } );


    }


    public void setLocation(View view) {
        Intent intent = new Intent( this, SelectLocationActivity.class );
        startActivity( intent );
    }

    @Override
    public void onClick(View view) {

        if (view == top_back) {
            finish();
        } else if (view == about_profile_tv_backgroundCheck) {
            Intent intent = new Intent( this, BackgroundFormActivity.class );
            startActivity( intent );
            finish();

        } else if (about_profile_tv_leisureDayStartDate == view) {
            showDataDialog( 1 );
        } else if (about_profile_civ_profile == view) {
            if (checkAllParmisan()) {
                selectProfileImage( 201,1 );
            } else {
                setAllParmisan();
            }
        } else if (about_profile_iv_newAdd == view) {
            if (checkAllParmisan()) {
                selectProfileImage( 205,5 );
            } else {
                setAllParmisan();
            }

        } else if (about_profile_tv_leisureDayEndDate == view) {
            showDataDialog( 2 );
        }
    }

    private void showDataDialog(int setPos) {

        calendar = Calendar.getInstance();
        year = calendar.get( Calendar.YEAR );
        month = calendar.get( Calendar.MONTH );
        day = calendar.get( Calendar.DAY_OF_MONTH );
        setDatePos = setPos;
        DatePickerDialog datePickerDialog = new DatePickerDialog( this, myDateListener, year, month, day );
        datePickerDialog.getDatePicker().setMinDate( (long) (System.currentTimeMillis()) );
        datePickerDialog.setOnDismissListener( new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                setDatePos = 0;
            }
        } );
        datePickerDialog.setOnCancelListener( new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                setDatePos = 0;
            }
        } );
        datePickerDialog.show();
        datePickerDialog.getButton( DatePickerDialog.BUTTON_NEGATIVE ).setTextColor( Color.RED );
        datePickerDialog.getButton( DatePickerDialog.BUTTON_POSITIVE ).setTextColor( Color.RED );
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
        if (setDatePos == 1) {
            about_profile_tv_leisureDayStartDate.setText( Util.getDateWithFormate( date, "yyyy-MM-dd", "MM/dd/yyyy" ) );
        } else if (setDatePos == 2) {
            about_profile_tv_leisureDayEndDate.setText( Util.getDateWithFormate( date, "yyyy-MM-dd", "MM/dd/yyyy" ) );

        }
    }

    private void selectProfileImage(int post,int imageSize) {

        Config config = new Config();
        config.setToolbarTitleRes( R.string.app_name );
        config.setSelectionMin( 1 );
        config.setSelectionLimit( imageSize );
       config.setSelectedBottomColor( "#500b02" );
        config.setTabBackgroundColor( "#D5D5D5" );
        config.setTabSelectionIndicatorColor( "#500b02" );
        config.setToolbarTitleColor( "#909090" );

        ImagePickerActivity.setConfig( config );

        Intent intent = new Intent( this, ImagePickerActivity.class );
        startActivityForResult( intent, post );

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode, resultCode, data );

        if (resultCode == Activity.RESULT_OK) {
            try {
                if (requestCode == MAP_CODE) {
//
//                    double strLatitude = (double) data.getExtras().get( "location_lat" );
//                    double strLongitude = (double) data.getExtras().get( "location_lng" );
//
//                    AppLog.Log( "receive------- Latitude", strLatitude + "  ---------" );
//                    AppLog.Log( "receive------- Longitude", strLongitude + "  ---------" );
//
//                    Geocoder geocoder;
//                    List<Address> addresses;
//                    geocoder = new Geocoder( this, Locale.getDefault() );
//
//                    addresses = geocoder.getFromLocation( strLatitude, strLongitude, 1 ); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
//
//                    String address = addresses.get( 0 ).getAddressLine( 0 ); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
//                    String city = addresses.get( 0 ).getLocality();
//                    String state = addresses.get( 0 ).getAdminArea();
//                    strCountryName = addresses.get( 0 ).getCountryName().toLowerCase();
//                    strCountryCode = addresses.get( 0 ).getCountryCode().toLowerCase();
////                        strPostalCode = addresses.get(0).getPostalCode();
////                        String knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL
//
//
//                    stBuilAddress.append( address );
////                    stBuilAddress.append(", " + city);
////                    stBuilAddress.append(", " + state);
////                        stBuilAddress.append(", " + strCountryName);
//                    tvLocation.setText( address );
//                    strLat = String.valueOf( strLatitude );
//                    strLong = String.valueOf( strLongitude );
//
//

                } else if (requestCode == 201) {

                    ArrayList<Uri> image_uris = data.getParcelableArrayListExtra( ImagePickerActivity.EXTRA_IMAGE_URIS );
                    imgPicturePath1 = image_uris.get( 0 ).toString();

                    if (imgPicturePath1 != null) {
                        File file = new File( imgPicturePath1 );
                        if (file.exists()) {
                            Bitmap bitmap = BitmapFactory.decodeFile( imgPicturePath1 );
                            about_profile_civ_profile.setImageBitmap( bitmap );
                        } else {
                            imgPicturePath1 = null;
                        }
                    }
                } else if (requestCode == 205) {

                    if (imgPicturePath1 == null) {
                        ArrayList<Uri> image_uris = data.getParcelableArrayListExtra( ImagePickerActivity.EXTRA_IMAGE_URIS );
//                        imgPicturePath2 = image_uris.get( 0 ).toString();
//
//                        if (imgPicturePath2 != null) {
//                            File file = new File( imgPicturePath2 );
//                            if (file.exists()) {
//                                Bitmap bitmap = BitmapFactory.decodeFile( imgPicturePath1 );
//                                ivImage1.setImageBitmap( bitmap );
//                            } else {
//                                imgPicturePath1 = null;
//                            }
//                        }
                    }
                }

                if (requestCode == SETTING_PERMISSION_CODE) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (checkWriteExternalPermission( perms[0] ) && checkWriteExternalPermission( perms[1] ) && checkWriteExternalPermission( perms[2] )) {

                        } else {
                            displayDialog();
                        }
                    }

                }

            } catch (Exception e) {
                // TODO: handle exception
//            Util.displayDialog(getString(R.string.app_name), getString(R.string.msg_fileNotSupport), this, false);
                e.printStackTrace();
            }
        }
    }






    private void setAllParmisan() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions( perms, PERMISSION_REQUEST_CODE );
        }
    }

    private boolean checkAllParmisan() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (checkWriteExternalPermission( perms[0] ) && checkWriteExternalPermission( perms[1] ) && checkWriteExternalPermission( perms[2] )) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }

    }


    private boolean checkWriteExternalPermission(String permissionName) {

        String permission = permissionName;
        int res = this.checkCallingOrSelfPermission( permission );
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    @Override
    public void onRequestPermissionsResult(int permsRequestCode, String[] permissions, int[] grantResults) {
//            case 200:
        if (permsRequestCode == 200) {
            boolean locationAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
            boolean cameraAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;
            boolean storageAccepted = grantResults[2] == PackageManager.PERMISSION_GRANTED;

            if (locationAccepted && cameraAccepted && storageAccepted) {
                showToast( R.string.msg_permission );
            } else {
                displayDialog();
            }
        }
    }

    public static int SETTING_PERMISSION_CODE = 110;
    private AlertDialog dialog1;
    public void displayDialog() {

        dialog1 = new AlertDialog.Builder( this )
                .setTitle( "Permission needed" )
                .setCancelable( false )
                .setMessage( "All permissions are required without access to your phone. In order to identify calls you need to change your phone permission in settings." )
                .setPositiveButton( "LET'S DO THIS", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete

                        dialog1.dismiss();
                        Intent intent = new Intent();
                        intent.setAction( Settings.ACTION_APPLICATION_DETAILS_SETTINGS );
                        Uri uri = Uri.fromParts( "package", ProfileEditActivity.this.getPackageName(), null );
                        intent.setData( uri );
                        startActivityForResult( intent, SETTING_PERMISSION_CODE );
                    }
                } )
                .setNegativeButton( "Exit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                        dialog1.dismiss();
                        finish();
                    }
                } )
                .setIcon( R.mipmap.ic_launcher )
                .show();


    }


}
