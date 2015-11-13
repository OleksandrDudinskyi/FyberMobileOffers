package com.oleksandr.fybermobileoffers.data;

/**
 * @author o.dudinskyi(dudinskyj@gmail.com)
 */
public class AdvertisingData {
    private String mId;

    public String getId() {
        return mId;
    }

    public void setId(String mId) {
        this.mId = mId;
    }

    public boolean isLimitAdTrackingEnabled() {
        return isLimitAdTrackingEnabled;
    }

    public void setIsLimitAdTrackingEnabled(boolean isLimitAdTrackingEnabled) {
        this.isLimitAdTrackingEnabled = isLimitAdTrackingEnabled;
    }

    public AdvertisingData() {
        mId = "";
        isLimitAdTrackingEnabled = false;
    }

    public AdvertisingData(String mDd, boolean isLimitAdTrackingEnabled) {

        this.mId = mDd;
        this.isLimitAdTrackingEnabled = isLimitAdTrackingEnabled;
    }

    private boolean isLimitAdTrackingEnabled;
}
