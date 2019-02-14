package com.sit.kaikiliService.font;

import android.support.annotation.ColorRes;


/**
 * Created by ketan patel on 23/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 *
 */


public interface VerificationAction {
    void setFigures(int figures);
    void setVerCodeMargin(int margin);
    void setBottomSelectedColor(@ColorRes int bottomSelectedColor);
    void setBottomNormalColor(@ColorRes int bottomNormalColor);
    void setSelectedBackgroundColor(@ColorRes int selectedBackground);
    void setBottomLineHeight(int bottomLineHeight);
    void setOnVerificationCodeChangedListener(OnVerificationCodeChangedListener listener);
    interface OnVerificationCodeChangedListener {
        void onVerCodeChanged(CharSequence s, int start, int before, int count);
        void onInputCompleted(CharSequence s);
    }
}
