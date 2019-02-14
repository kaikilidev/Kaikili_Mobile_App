package com.sit.kaikiliService.font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;


/**
 * Created by ketan patel on 21/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 *
 */


public class ButtonEupheminUCASRegular extends Button {


    private Context context;
    private AttributeSet attrs;
    private int defStyle;

    public ButtonEupheminUCASRegular(Context context) {
        super( context );
        this.context=context;
        init();

    }

    public ButtonEupheminUCASRegular(Context context, AttributeSet attrs) {
        super( context, attrs );
        this.context=context;
        this.attrs=attrs;
        init();
    }

    public ButtonEupheminUCASRegular(Context context, AttributeSet attrs, int defStyle) {
        super( context, attrs, defStyle );
        this.context=context;
        this.attrs=attrs;
        this.defStyle=defStyle;
        init();
    }

    private void init() {
        Typeface font=Typeface.createFromAsset(getContext().getAssets(), "fonts/euphemia-ucas-regular.ttf");
        this.setTypeface(font);
    }
    @Override
    public void setTypeface(Typeface tf, int style) {
        tf=Typeface.createFromAsset(getContext().getAssets(), "fonts/euphemia-ucas-regular.ttf");
        super.setTypeface(tf, style);
    }

    @Override
    public void setTypeface(Typeface tf) {
        tf=Typeface.createFromAsset(getContext().getAssets(), "fonts/euphemia-ucas-regular.ttf");
        super.setTypeface(tf);
    }



}
