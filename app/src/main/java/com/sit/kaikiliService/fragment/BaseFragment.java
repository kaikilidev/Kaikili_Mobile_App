package com.sit.kaikiliService.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sit.kaikiliService.R;

/**
 * Created by ketan patel on 30/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    private static int MAX_CLICK_INTERVAL = 3000;
    private long mLastClickTime = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_base, container, false);
        return rootView;
    }


    public abstract void initComponents(View rootView);


    @Override
    public void onClick(View v) {

    }





}
