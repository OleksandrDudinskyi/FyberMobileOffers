package com.oleksandr.fybermobileoffers.network;

import com.oleksandr.fybermobileoffers.data.OffersResponse;

import java.util.Map;

import retrofit.http.GET;
import retrofit.http.QueryMap;
import rx.Observable;

/**
 * @author o.dudinskyi(dudinskyj@gmail.com)
 */
public interface RestOffers {
    @GET("/feed/v1/offers.json")
    Observable<OffersResponse> getOffers(@QueryMap Map<String, String> params);

}
