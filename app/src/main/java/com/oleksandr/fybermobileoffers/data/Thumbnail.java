package com.oleksandr.fybermobileoffers.data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author o.dudinskyi(dudinskyj@gmail.com)
 */
public class Thumbnail {
    private String lowres;
    private String hires;
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     *
     * @return
     * The lowres
     */
    public String getLowres() {
        return lowres;
    }

    /**
     *
     * @param lowres
     * The lowres
     */
    public void setLowres(String lowres) {
        this.lowres = lowres;
    }

    /**
     *
     * @return
     * The hires
     */
    public String getHires() {
        return hires;
    }

    /**
     *
     * @param hires
     * The hires
     */
    public void setHires(String hires) {
        this.hires = hires;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
