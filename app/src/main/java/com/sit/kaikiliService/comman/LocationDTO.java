package com.sit.kaikiliService.comman;

import android.location.Location;

import java.io.Serializable;


/**
 * Created by ketan patel on 21/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 *
 */

public class LocationDTO implements Serializable{
    public double lat;
    public double lng;

    public LocationDTO(Location location){
        lat = location.getLatitude();
        lng = location.getLongitude();
    }
}
