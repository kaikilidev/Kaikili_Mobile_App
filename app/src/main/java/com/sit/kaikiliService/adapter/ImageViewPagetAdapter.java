package com.sit.kaikiliService.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sit.kaikiliService.R;
import com.sit.kaikiliService.font.TouchImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by ketan patel on 2/2/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 */


public class ImageViewPagetAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<String> multipaleDataList;


    public ImageViewPagetAdapter(Context act, ArrayList<String> multipaleDataList) {

        this.context = act;
        this.multipaleDataList = multipaleDataList;

//        Log.e("-------------------", multipaleDataList.size() + "  size");
    }

    public int getCount() {
        return multipaleDataList.size();
    }

//    @Override
//    public boolean isViewFromObject(View view, Object object) {
//        return view == object;
//    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

//        int setPos = position;
        int setPos = position ;

        LayoutInflater li = LayoutInflater.from(context);
//        View view = li.inflate( R )
        View view = li.inflate(R.layout.new_image_view, null);

        final TouchImageView imageView = (TouchImageView) view.findViewById(R.id.zoom_imageview);
//        application.getmLoader().displayImage(multipaleDataList.get(setPos).getContentImage(), imageView, application.getImageOptions());

        Picasso.with(context).load(multipaleDataList.get(position).toString())
               .into(imageView);
//         .memoryPolicy( MemoryPolicy.NO_CACHE)

        container.addView(view);
        return view;
    }



    @Override
    public int getItemPosition(Object object) {
        // TODO Auto-generated method stub
        // return super.getItemPosition(object);
        return super.POSITION_NONE;
    }

    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView((View) arg2);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == ((View) arg1);
    }


}
