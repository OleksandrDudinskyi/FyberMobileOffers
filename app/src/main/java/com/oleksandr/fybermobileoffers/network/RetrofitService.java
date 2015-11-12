package com.oleksandr.fybermobileoffers.network;

import retrofit.RestAdapter;

/**
 * @author o.dudinskyi(dudinskyj@gmail.com)
 */
public class RetrofitService {
    public static final String API_BASE_URL = "http://api.fyber.com/";
    RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(API_BASE_URL).build();


}
