package com.sit.kaikiliService.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sit.kaikiliService.R;
import com.sit.kaikiliService.activity.CashOutActivity;
import com.sit.kaikiliService.adapter.EarningsListAdapter;
import com.sit.kaikiliService.font.TextViewEuphemiaUCASRegular;
import com.sit.kaikiliService.model.EarningsModel;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by ketan patel on 30/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 */

public class EarningsFragment extends BaseFragment {


    @Bind(R.id.fag_earnings_listView )ListView fag_earnings_listView;
    @Bind(R.id.fag_earnings_tv_amount )TextViewEuphemiaUCASRegular fag_earnings_tv_amount;
    @Bind(R.id.fag_earnings_tv_cashOut )TextViewEuphemiaUCASRegular fag_earnings_tv_cashOut;

    private EarningsListAdapter adapter;
    private ArrayList<EarningsModel> earningList;

    public EarningsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_earnings, container, false);
        ButterKnife.bind( this,rootView);
        initComponents(rootView);
        return rootView;
    }



    @Override
    public void initComponents(View rootView) {
        adapter = new EarningsListAdapter( getActivity());
        fag_earnings_listView.setAdapter(adapter);

        fag_earnings_tv_cashOut.setOnClickListener( this );

        earningList = new ArrayList<>();

        EarningsModel model = new EarningsModel();
        model.setId("1");
        model.setName( "TV Mount Installation" );
        model.setTime( "01/10/2019 10 AM to 12 PM" );
        model.setAmount( "$100.00" );
        earningList.add(model);

        EarningsModel model1 = new EarningsModel();
        model1.setId("2");
        model1.setName( "Interior Painting" );
        model1.setTime( "01/09/2019 11 AM to 2 PM" );
        model1.setAmount( "$85.00" );
        earningList.add(model1);

        EarningsModel model2 = new EarningsModel();
        model2.setId("3");
        model2.setName( "TV Mount Installation" );
        model2.setTime( "01/10/2019 11 AM to 12 PM" );
        model2.setAmount( "$90.00" );
        earningList.add(model2);

        EarningsModel model3 = new EarningsModel();
        model3.setId("3");
        model3.setName( "TV Mount Installation" );
        model3.setTime( "01/10/2019 11 AM to 12 PM" );
        model3.setAmount( "$160.00" );
        earningList.add(model3);

        EarningsModel model4 = new EarningsModel();
        model4.setId("4");
        model4.setName( "Interior Painting" );
        model4.setTime( "01/10/2019 11 AM to 12 PM" );
        model4.setAmount( "$100.00" );
        earningList.add(model4);

        adapter.setList( earningList);

    }


    @Override
    public void onClick(View v) {
        if(v==fag_earnings_tv_cashOut){
            Intent intent = new Intent( getActivity(),CashOutActivity.class );
            getActivity().startActivity(intent);

        }

    }
}
