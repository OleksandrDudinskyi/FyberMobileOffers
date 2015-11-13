package com.oleksandr.fybermobileoffers;

import android.app.Application;

/**
 * @author o.dudinskyi(dudinskyj@gmail.com)
 */
public class OffersApplication extends Application {
    private static OffersApplication mSingleton;

    @Override
    public void onCreate() {
        super.onCreate();
        mSingleton = this;
    }

    public static OffersApplication getInstance() {
        return mSingleton;
    }
}
