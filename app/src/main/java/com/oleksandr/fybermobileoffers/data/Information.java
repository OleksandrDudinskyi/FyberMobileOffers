package com.oleksandr.fybermobileoffers.data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author o.dudinskyi(dudinskyj@gmail.com)
 */
public class Information {
    private String appName;
    private Integer appid;
    private String virtualCurrency;
    private String country;
    private String language;
    private String supportUrl;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The appName
     */
    public String getAppName() {
        return appName;
    }

    /**
     *
     * @param appName
     * The app_name
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     *
     * @return
     * The appid
     */
    public Integer getAppid() {
        return appid;
    }

    /**
     *
     * @param appid
     * The appid
     */
    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    /**
     *
     * @return
     * The virtualCurrency
     */
    public String getVirtualCurrency() {
        return virtualCurrency;
    }

    /**
     *
     * @param virtualCurrency
     * The virtual_currency
     */
    public void setVirtualCurrency(String virtualCurrency) {
        this.virtualCurrency = virtualCurrency;
    }

    /**
     *
     * @return
     * The country
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     * The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     * The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     *
     * @param language
     * The language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     *
     * @return
     * The supportUrl
     */
    public String getSupportUrl() {
        return supportUrl;
    }

    /**
     *
     * @param supportUrl
     * The support_url
     */
    public void setSupportUrl(String supportUrl) {
        this.supportUrl = supportUrl;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
