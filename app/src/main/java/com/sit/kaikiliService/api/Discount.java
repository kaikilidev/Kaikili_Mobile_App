package com.sit.kaikiliService.api;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ketan patel on 9/2/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 *
 */

@JsonObject
public class Discount implements Serializable {

    @JsonField
    private String ds_id;

    @JsonField
    private String ds_title;

    @JsonField
    private String ds_rate_num_field;

    @JsonField
    private String ds_check_box;

    public String getDs_id() {
        return ds_id;
    }

    public void setDs_id(String ds_id) {
        this.ds_id = ds_id;
    }

    public String getDs_title() {
        return ds_title;
    }

    public void setDs_title(String ds_title) {
        this.ds_title = ds_title;
    }

    public String getDs_rate_num_field() {
        return ds_rate_num_field;
    }

    public void setDs_rate_num_field(String ds_rate_num_field) {
        this.ds_rate_num_field = ds_rate_num_field;
    }

    public String getDs_check_box() {
        return ds_check_box;
    }

    public void setDs_check_box(String ds_check_box) {
        this.ds_check_box = ds_check_box;
    }
}
