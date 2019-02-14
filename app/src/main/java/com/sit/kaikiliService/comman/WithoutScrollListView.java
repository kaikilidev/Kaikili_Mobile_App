package com.sit.kaikiliService.comman;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Admin on 3/7/2016.
 */
public class WithoutScrollListView extends ListView
{

    public WithoutScrollListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        removeSelector();
    }

    public WithoutScrollListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        removeSelector();
    }


    public WithoutScrollListView(Context context) {
        super(context);
        removeSelector();
    }

    public void removeSelector() {
        setSelector(android.R.color.transparent); // optional
//        setSelector(R.color.bg_blu); // optional
        // TODO solution for double tap selector needed.

    }


    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightMeasureSpec_custom = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec_custom);
        ViewGroup.LayoutParams params = getLayoutParams();
        params.height = getMeasuredHeight();
    }





}