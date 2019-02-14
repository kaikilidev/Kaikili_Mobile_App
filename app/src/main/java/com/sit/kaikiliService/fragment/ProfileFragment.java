package com.sit.kaikiliService.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sit.kaikiliService.R;
import com.sit.kaikiliService.activity.HomeScreenActivity;
import com.sit.kaikiliService.adapter.ImageViewPagetAdapter;
import com.sit.kaikiliService.comman.CircularImageView;
import com.sit.kaikiliService.font.CirclePageIndicator;
import com.sit.kaikiliService.font.TextViewEuphemiaUCASRegular;
import com.sit.kaikiliService.font.TextViewReadMoreEuphemiaUCASRegular;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by ketan patel on 30/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 */

public class ProfileFragment extends BaseFragment {

    @Bind(R.id.profile_frag_tv_userAbout )TextViewReadMoreEuphemiaUCASRegular profile_frag_tv_userAbout;
    @Bind(R.id.profile_frag_civ_profile )CircularImageView profile_frag_civ_profile;
    @Bind(R.id.profile_frag_tv_userName )TextViewEuphemiaUCASRegular profile_frag_tv_userName;
    @Bind(R.id.profile_frag_viewPager )ViewPager profile_frag_viewPager;
    @Bind(R.id.profile_frag_indicator )CirclePageIndicator profile_frag_indicator;
    @Bind(R.id.profile_frag_tv_website )TextViewEuphemiaUCASRegular profile_frag_tv_website;
    @Bind(R.id.profile_frag_tv_email )TextViewEuphemiaUCASRegular profile_frag_tv_email;
    @Bind(R.id.profile_frag_tv_phone )TextViewEuphemiaUCASRegular profile_frag_tv_phone;
    @Bind(R.id.profile_frag_tv_radius )TextViewEuphemiaUCASRegular profile_frag_tv_radius;
    @Bind(R.id.profile_frag_tv_Linkedin )TextViewEuphemiaUCASRegular profile_frag_tv_Linkedin;
    @Bind(R.id.profile_frag_tv_serviceArea )TextViewEuphemiaUCASRegular profile_frag_tv_serviceArea;

    @Bind(R.id.profile_frag_cb_mon)
    CheckBox profile_frag_cb_mon;
    @Bind(R.id.profile_frag_cb_tue)
    CheckBox profile_frag_cb_tue;
    @Bind(R.id.profile_frag_cb_wed)
    CheckBox profile_frag_cb_wed;
    @Bind(R.id.profile_frag_cb_thu)
    CheckBox profile_frag_cb_thu;
    @Bind(R.id.profile_frag_cb_fri)
    CheckBox profile_frag_cb_fri;
    @Bind(R.id.profile_frag_cb_sat)
    CheckBox profile_frag_cb_sat;
    @Bind(R.id.profile_frag_cb_sun)
    CheckBox profile_frag_cb_sun;

    @Bind(R.id.profile_frag_tv_mon)
    TextViewEuphemiaUCASRegular profile_frag_tv_mon;
    @Bind(R.id.profile_frag_tv_tue)
    TextViewEuphemiaUCASRegular profile_frag_tv_tue;
    @Bind(R.id.profile_frag_tv_wed)
    TextViewEuphemiaUCASRegular profile_frag_tv_wed;
    @Bind(R.id.profile_frag_tv_thu)
    TextViewEuphemiaUCASRegular profile_frag_tv_thu;
    @Bind(R.id.profile_frag_tv_fri)
    TextViewEuphemiaUCASRegular profile_frag_tv_fri;
    @Bind(R.id.profile_frag_tv_sat)
    TextViewEuphemiaUCASRegular profile_frag_tv_sat;
    @Bind(R.id.profile_frag_tv_sun)
    TextViewEuphemiaUCASRegular profile_frag_tv_sun;

    @Bind(R.id.profile_frag_tv_monStart)
    TextViewEuphemiaUCASRegular profile_frag_tv_monStart;
    @Bind(R.id.profile_frag_tv_tueStart)
    TextViewEuphemiaUCASRegular profile_frag_tv_tueStart;
    @Bind(R.id.profile_frag_tv_wedStart)
    TextViewEuphemiaUCASRegular profile_frag_tv_wedStart;
    @Bind(R.id.profile_frag_tv_thuStart)
    TextViewEuphemiaUCASRegular profile_frag_tv_thuStart;
    @Bind(R.id.profile_frag_tv_friStart)
    TextViewEuphemiaUCASRegular profile_frag_tv_friStart;
    @Bind(R.id.profile_frag_tv_satStart)
    TextViewEuphemiaUCASRegular profile_frag_tv_satStart;
    @Bind(R.id.profile_frag_tv_sunStart)
    TextViewEuphemiaUCASRegular profile_frag_tv_sunStart;

    @Bind(R.id.profile_frag_tv_monEnd)
    TextViewEuphemiaUCASRegular profile_frag_tv_monEnd;
    @Bind(R.id.profile_frag_tv_tueEnd)
    TextViewEuphemiaUCASRegular profile_frag_tv_tueEnd;
    @Bind(R.id.profile_frag_tv_wedEnd)
    TextViewEuphemiaUCASRegular profile_frag_tv_wedEnd;
    @Bind(R.id.profile_frag_tv_thuEnd)
    TextViewEuphemiaUCASRegular profile_frag_tv_thuEnd;
    @Bind(R.id.profile_frag_tv_friEnd)
    TextViewEuphemiaUCASRegular profile_frag_tv_friEnd;
    @Bind(R.id.profile_frag_tv_satEnd)
    TextViewEuphemiaUCASRegular profile_frag_tv_satEnd;
    @Bind(R.id.profile_frag_tv_sunEnd)
    TextViewEuphemiaUCASRegular profile_frag_tv_sunEnd;

    @Bind(R.id.profile_frag_cb_leisureDay)
    CheckBox profile_frag_cb_leisureDay;
    @Bind(R.id.profile_frag_tv_leisureDay)
    TextViewEuphemiaUCASRegular profile_frag_tv_leisureDay;
    @Bind(R.id.profile_frag_tv_leisureDayStartDate)
    TextViewEuphemiaUCASRegular profile_frag_tv_leisureDayStartDate;
    @Bind(R.id.profile_frag_tv_leisureDayStartTime)
    TextViewEuphemiaUCASRegular profile_frag_tv_leisureDayStartTime;
    @Bind(R.id.profile_frag_tv_leisureDayEndDate)
    TextViewEuphemiaUCASRegular profile_frag_tv_leisureDayEndDate;
    @Bind(R.id.profile_frag_tv_leisureDayEndTime)
    TextViewEuphemiaUCASRegular profile_frag_tv_leisureDayEndTime;

    @Bind(R.id.profile_frag_cb_nearByLastMin)
    CheckBox profile_frag_cb_nearByLastMin;

    private int postion = 0;

    public ProfileFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate( R.layout.fragment_profile, container, false );
        ButterKnife.bind( this,rootView);
        initComponents( rootView );
        return rootView;
    }




    @Override
    public void initComponents(View rootView) {

        ArrayList<String> imageURL = new ArrayList<>();
        imageURL.add( "https://certapro.com/wp-content/uploads/cache//Screen-Shot-2018-04-02-at-10_49_06-PM/2936591281.png" );
        imageURL.add( "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7S_Uqp2RaN1cp3ow1Nevm3ZYXlX4UFLHT8K5g2oz3UAF3LdVx" );
        imageURL.add( "https://certapro.com/wp-content/uploads/cache//z_footer/3313024203.jpg" );
        imageURL.add( "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSSTIovt6zDyWa2npaou3H77DTSO-UoPLQ4bW9MQoHDIDYWSyrnnA" );
        imageURL.add( "https://mydecorative.com/wp-content/uploads/2018/12/interior-painting-tips.jpg" );

        ImageViewPagetAdapter adapter = new ImageViewPagetAdapter(getActivity(), imageURL);
        profile_frag_viewPager.setAdapter(adapter);
        profile_frag_viewPager.setCurrentItem(postion);
        profile_frag_indicator.setViewPager(profile_frag_viewPager);

    }

}
