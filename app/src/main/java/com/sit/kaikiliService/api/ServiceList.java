package com.sit.kaikiliService.api;

import android.os.Parcel;
import android.os.Parcelable;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ketan patel on 9/2/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 */

@JsonObject
public class ServiceList implements Serializable {

    @JsonField
    private String _id;

    @JsonField
    private String sr_id;

    @JsonField
    private String sr_title;

    @JsonField
    private String sr_availability;

    @JsonField
    private String sr_refresh;

    @JsonField
    private String sr_type;

    @JsonField
    private String notes;

    @JsonField
    private ArrayList<CompsItme> cost_comps_pro_rated = new ArrayList<>(  );

    public ArrayList<CompsItme> getCost_comps_pro_rated() {
        return cost_comps_pro_rated;
    }

    public void setCost_comps_pro_rated(ArrayList<CompsItme> cost_comps_pro_rated) {
        this.cost_comps_pro_rated = cost_comps_pro_rated;
    }

    public ArrayList<CompsItme> getCost_comps_per_item() {
        return cost_comps_per_item;
    }

    public void setCost_comps_per_item(ArrayList<CompsItme> cost_comps_per_item) {
        this.cost_comps_per_item = cost_comps_per_item;
    }

    @JsonField
    private ArrayList<CompsItme> cost_comps_per_item = new ArrayList<>();

    @JsonField
    private Discount discount;

    @JsonField
    private Size size;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getSr_id() {
        return sr_id;
    }

    public void setSr_id(String sr_id) {
        this.sr_id = sr_id;
    }

    public String getSr_title() {
        return sr_title;
    }

    public void setSr_title(String sr_title) {
        this.sr_title = sr_title;
    }

    public String getSr_availability() {
        return sr_availability;
    }

    public void setSr_availability(String sr_availability) {
        this.sr_availability = sr_availability;
    }

    public String getSr_refresh() {
        return sr_refresh;
    }

    public void setSr_refresh(String sr_refresh) {
        this.sr_refresh = sr_refresh;
    }

    public String getSr_type() {
        return sr_type;
    }

    public void setSr_type(String sr_type) {
        this.sr_type = sr_type;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }



    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

}
