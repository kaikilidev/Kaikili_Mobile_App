package com.sit.kaikiliService.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sit.kaikiliService.R;
import com.sit.kaikiliService.adapter.ServiceListAdapter;
import com.sit.kaikiliService.model.ServiceModel;
import java.util.ArrayList;
import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by ketan patel on 30/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 */

public class ScheduledServicesFragment extends BaseFragment {


    @Bind(R.id.scheduled_services_fgm_recyclerView )RecyclerView scheduled_services_fgm_recyclerView;

    private ServiceListAdapter adapter;
    private ArrayList<ServiceModel> serviceDataList;

    public ScheduledServicesFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_scheduled_services, container, false);
     //   initToolbar();
        ButterKnife.bind( this, rootView );

        initComponents(rootView);
        return rootView;
    }


    @Override
    public void initComponents(View rootView) {

        LinearLayoutManager mLayoutManager = new LinearLayoutManager( getActivity() );
        adapter = new ServiceListAdapter( getActivity());
        scheduled_services_fgm_recyclerView.setLayoutManager( mLayoutManager );
        scheduled_services_fgm_recyclerView.setAdapter( adapter );

        serviceDataList = new ArrayList<>();
        ServiceModel model = new ServiceModel();
        model.setServiceId("1" );
        model.setServiceName( "TV Mount Installation" );
        model.setServiceTime( "01/10/2019 10 AM to 12 PM" );
        serviceDataList.add(model);
        model.setServiceId("2" );
        model.setServiceName( "Interior Painting" );
        model.setServiceTime( "01/11/2019 10 AM to 12 PM" );
        serviceDataList.add(model);
        model.setServiceId("3" );
        model.setServiceName( "Lawn Mowing" );
        model.setServiceTime( "01/11/2019 2 PM to 4 PM" );
        serviceDataList.add(model);
        model.setServiceId("4" );
        model.setServiceName( "Dishwasher Installation" );
        model.setServiceTime( "01/12/2019 10 AM to 12 PM" );
        serviceDataList.add(model);
        model.setServiceId("5" );
        model.setServiceName( "Carpet Cleaning" );
        model.setServiceTime( "01/12/2019 10 AM to 12 PM" );
        serviceDataList.add(model);
        adapter.setList( serviceDataList );

    }

}
