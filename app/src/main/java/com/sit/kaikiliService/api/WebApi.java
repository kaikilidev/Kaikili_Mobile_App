package com.sit.kaikiliService.api;


import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.mime.TypedFile;

/**
 * Created by ketan patel on 9/2/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 *
 */

public interface WebApi {

      public static final String BASE_URL = "http://157.230.188.53:3000/subservices/";

    public static final String URL = "/{tag}";


    //LOGIN
    public static final String TAG = "tag";




    @GET(URL)
    void getAllAddService(@Path(TAG) String tag,
                     Callback<GetAllServiceAPI> callback
    );



}
