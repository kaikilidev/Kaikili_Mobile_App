package com.sit.kaikiliService.camera.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by ketan patel on 26/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 *
 */

public class CustomSquareFrameLayout extends FrameLayout {


    public CustomSquareFrameLayout(Context context) {
        super(context);
    }

    public CustomSquareFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);


    }


    //Squares the thumbnail
    @Override
    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, widthMeasureSpec);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, w, oldw, oldh);

    }
}
