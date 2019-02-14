package com.sit.kaikiliService.camera.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by ketan patel on 26/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 *
 */

public class CustomSquareImageView extends ImageView {



    public CustomSquareImageView(Context context) {
        super(context);
    }

    public CustomSquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);


    }



    //Squares the thumbnail
    @Override
    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec){
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
         setMeasuredDimension(widthMeasureSpec, widthMeasureSpec);

    }




}
