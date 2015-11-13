package com.oleksandr.fybermobileoffers.network;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.oleksandr.fybermobileoffers.OffersApplication;
import com.oleksandr.fybermobileoffers.data.AdvertisingData;
import com.oleksandr.fybermobileoffers.data.OffersResponse;

import java.io.IOException;
import java.util.Map;

import retrofit.RestAdapter;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

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

    public Observable<OffersResponse> getOffers(final Map<String, String> params) {
        return getAdvertisingData().flatMap(new Func1<AdvertisingData, Observable<OffersResponse>>() {
            @Override
            public Observable<OffersResponse> call(AdvertisingData advertisingData) {
                params.put(QueryParams.GOOGLE_AD_ID, advertisingData.getId());
                params.put(QueryParams.GOOGLE_AD_ID_TRACKING, Boolean.toString(advertisingData.isLimitAdTrackingEnabled()));
                return mRestAdapter.create(RestOffers.class).getOffers(params);
            }
        });
    }

    public Observable<AdvertisingData> getAdvertisingData() {
        return Observable.create(new Observable.OnSubscribe<AdvertisingData>() {
            @Override
            public void call(Subscriber<? super AdvertisingData> subscriber) {
                AdvertisingIdClient.Info info;
                try {
                    info = AdvertisingIdClient.getAdvertisingIdInfo(OffersApplication.getInstance().getApplicationContext());
                    subscriber.onNext(new AdvertisingData(info.getId(), info.isLimitAdTrackingEnabled()));
                } catch (IOException | GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException e) {
                    subscriber.onNext(new AdvertisingData());
                    e.printStackTrace();
                }
                subscriber.onCompleted();
            }
        });
    }
}
