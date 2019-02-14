package com.sit.kaikiliService.camera;

import android.util.Log;

import com.sit.kaikiliService.R;


/**
 * Created by ketan patel on 26/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 *
 */

public class Config {

    private int toolbarTitleRes = R.string.toolbar_title;

    private String  tabBackgroundColor = "";
    private String  toolbarTitleColor = "";
    private String  tabSelectionIndicatorColor = "";

    private String  selectedBottomColor ="";

    private int selectionLimit = Integer.MAX_VALUE;
    private int selectionMin = 0;

    private int cameraHeight = R.dimen.ted_picker_camera_height;

    private int cameraBtnImage = R.drawable.ic_camera;
    private int cameraBtnBackground = R.drawable.btn_bg;

    private int selectedCloseImage = R.drawable.ic_clear;
    private int selectedBottomHeight = R.dimen.ted_picker_selected_image_height;

    private int savedDirectoryName = R.string.default_directory;


    private boolean flashOn = false;

    public int getCameraHeight() {
        return cameraHeight;
    }

    public void setCameraHeight(int dimenRes) {
        if (dimenRes <= 0)
            throw new IllegalArgumentException("Invalid value for cameraHeight");

        this.cameraHeight = dimenRes;
    }

    public int getSavedDirectoryName() {
        return savedDirectoryName;
    }

    public void setSavedDirectoryName(int stringRes) {
        if (stringRes <= 0)
            throw new IllegalArgumentException("Invalid value for savedDirectoryName");

        this.savedDirectoryName = stringRes;
    }

    public int getSelectedBottomHeight() {
        return selectedBottomHeight;
    }

    public void setSelectedBottomHeight(int dimenRes) {
        if (dimenRes <= 0)
            throw new IllegalArgumentException("Invalid value for selectedBottomHeight");

        this.selectedBottomHeight = dimenRes;
    }

    public String getSelectedBottomColor() {
        return selectedBottomColor;
    }

    public void setSelectedBottomColor(String colorRes) {
        Log.v("color res",colorRes+"  get");

        if (colorRes.length() <= 0)
            throw new IllegalArgumentException("Invalid value for selectedBottomColor");

        this.selectedBottomColor = colorRes;
    }

    public int getToolbarTitleRes() {
        return toolbarTitleRes;
    }

    public void setToolbarTitleRes(int toolbarTitleRes) {
        if (toolbarTitleRes <= 0)
            throw new IllegalArgumentException("Invalid value for toolbarTitleRes");

        this.toolbarTitleRes = toolbarTitleRes;
    }


    public String getTabBackgroundColor() {
        return tabBackgroundColor;
    }

    public void setTabBackgroundColor(String colorRes) {
        if (colorRes.length() <= 0)
            throw new IllegalArgumentException("Invalid value for tabBackgroundColor");


        this.tabBackgroundColor = colorRes;

    }


    public void setToolbarTitleColor( String  colorRes) {
        if (colorRes.length() <= 0)
            throw new IllegalArgumentException("Invalid value for tabBackgroundColor");

        this.toolbarTitleColor = colorRes;

    }

    public String getToolbarTitleColor() {
        return toolbarTitleColor;
    }


    public String  getTabSelectionIndicatorColor() {
        return tabSelectionIndicatorColor;
    }

    /**
     * Sets selected tab indicator color.
     */
    public void setTabSelectionIndicatorColor(String  colorRes) {
        if (colorRes.length() <= 0) throw new IllegalArgumentException("Invalid value for tabSelectionIndicatorColor");


        this.tabSelectionIndicatorColor = colorRes;

    }

    public int getSelectionLimit() {
        return selectionLimit;
    }

    /**
     * Limit the number of images that can be selected. By default the user can
     * select infinite number of images.
     *
     * @param selectionLimit
     */
    public void setSelectionLimit(int selectionLimit) {
        this.selectionLimit = selectionLimit;

    }

    public int getSelectionMin() {
        return selectionMin;
    }

    public void setSelectionMin(int selectionmin) {
        selectionMin = selectionmin;

    }


    public int getCameraBtnImage() {
        return cameraBtnImage;
    }

    public void setCameraBtnImage(int drawableRes) {
        if (drawableRes <= 0) throw new IllegalArgumentException("Invalid value for cameraBtnImage");
        this.cameraBtnImage = drawableRes;
    }

    public int getCameraBtnBackground() {
        return cameraBtnBackground;
    }

    public void setCameraBtnBackground( int drawableRes) {
        if (drawableRes <= 0) throw new IllegalArgumentException("Invalid value for cameraBtnBackground");
        this.cameraBtnBackground = drawableRes;
    }


    public int getSelectedCloseImage() {
        return selectedCloseImage;
    }

    public void setSelectedCloseImage(int drawableRes) {
        if (drawableRes <= 0) throw new IllegalArgumentException("Invalid value for selectedCloseImage");

        this.selectedCloseImage = drawableRes;
    }


    public boolean isFlashOn(){
        return flashOn;
    }

    public void setFlashOn(boolean flashOn){
        this.flashOn = flashOn;
    }
}
