package com.sit.kaikiliService.api;

import android.os.Parcel;
import android.os.Parcelable;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.io.Serializable;

/**
 * Created by ketan patel on 9/2/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 *
 */

@JsonObject
public class CompsItme implements Serializable {

    @JsonField
    private String cc_id;

    @JsonField
    private String cc_title;

    @JsonField
    private String cc_rate_num_field;

    @JsonField
    private String cc_check_box;



    public String getCc_id() {
        return cc_id;
    }

    public void setCc_id(String cc_id) {
        this.cc_id = cc_id;
    }

    public String getCc_title() {
        return cc_title;
    }

    public void setCc_title(String cc_title) {
        this.cc_title = cc_title;
    }

    public String getCc_rate_num_field() {
        return cc_rate_num_field;
    }

    public void setCc_rate_num_field(String cc_rate_num_field) {
        this.cc_rate_num_field = cc_rate_num_field;
    }

    public String getCc_check_box() {
        return cc_check_box;
    }

    public void setCc_check_box(String cc_check_box) {
        this.cc_check_box = cc_check_box;
    }

}
