package com.sit.kaikiliService.api;

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
public class Size implements Serializable {

    @JsonField
    private String sz_id;

    @JsonField
    private String sz_title;

    @JsonField
    private String sz_rate_num_field;

    public String getSz_id() {
        return sz_id;
    }

    public void setSz_id(String sz_id) {
        this.sz_id = sz_id;
    }

    public String getSz_title() {
        return sz_title;
    }

    public void setSz_title(String sz_title) {
        this.sz_title = sz_title;
    }

    public String getSz_rate_num_field() {
        return sz_rate_num_field;
    }

    public void setSz_rate_num_field(String sz_rate_num_field) {
        this.sz_rate_num_field = sz_rate_num_field;
    }
}
