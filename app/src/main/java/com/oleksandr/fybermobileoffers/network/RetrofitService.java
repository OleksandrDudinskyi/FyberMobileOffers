package com.oleksandr.fybermobileoffers.network;

import com.oleksandr.fybermobileoffers.data.OffersResponse;

import java.util.Map;

import retrofit.RestAdapter;
import rx.Observable;

/**
 * @author o.dudinskyi(dudinskyj@gmail.com)
 */
public class RetrofitService {
    public static final String API_BASE_URL = "http://api.fyber.com/";
    private RestAdapter mRestAdapter;

    public RetrofitService() {
        mRestAdapter = new RestAdapter.Builder()
                .setEndpoint(API_BASE_URL).
                        setLogLevel(RestAdapter.LogLevel.FULL).build();
    }

    public Observable<OffersResponse> getOffers(Map<String, String> params) {
        return mRestAdapter.create(RestOffers.class).getOffers(params);
    }
}
