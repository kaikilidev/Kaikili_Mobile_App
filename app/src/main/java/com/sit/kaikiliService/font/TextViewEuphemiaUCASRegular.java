package com.sit.kaikiliService.font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;


/**
 * Created by ketan patel on 21/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 *
 */


public class TextViewEuphemiaUCASRegular extends TextView {

    public TextViewEuphemiaUCASRegular(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public TextViewEuphemiaUCASRegular(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public TextViewEuphemiaUCASRegular(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface mtypeFace = Typeface.createFromAsset(context.getAssets(),
                "fonts/euphemia-ucas-regular.ttf");
//        Typeface customFont = FontCache.getTypeface("SourceSansPro-Regular.ttf", context);
        setTypeface(mtypeFace);
    }
}

