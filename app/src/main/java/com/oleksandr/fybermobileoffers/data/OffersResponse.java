package com.oleksandr.fybermobileoffers.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author o.dudinskyi(dudinskyj@gmail.com)
 */
public class OffersResponse {
    private String code;
    private String message;
    private Integer count;
    private Integer pages;
    private Information information;
    private List<Offer> offers = new ArrayList<Offer>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The code
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     * The code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     * The message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     * The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     *
     * @param count
     * The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     *
     * @return
     * The pages
     */
    public Integer getPages() {
        return pages;
    }

    /**
     *
     * @param pages
     * The pages
     */
    public void setPages(Integer pages) {
        this.pages = pages;
    }

    /**
     *
     * @return
     * The information
     */
    public Information getInformation() {
        return information;
    }

    /**
     *
     * @param information
     * The information
     */
    public void setInformation(Information information) {
        this.information = information;
    }

    /**
     *
     * @return
     * The offers
     */
    public List<Offer> getOffers() {
        return offers;
    }

    /**
     *
     * @param offers
     * The offers
     */
    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
