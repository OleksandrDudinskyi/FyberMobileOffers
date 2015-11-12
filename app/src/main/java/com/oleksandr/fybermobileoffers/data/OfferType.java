package com.oleksandr.fybermobileoffers.data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author o.dudinskyi(dudinskyj@gmail.com)
 */
public class OfferType {
    private Integer offerTypeId;
    private String readable;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The offerTypeId
     */
    public Integer getOfferTypeId() {
        return offerTypeId;
    }

    /**
     *
     * @param offerTypeId
     * The offer_type_id
     */
    public void setOfferTypeId(Integer offerTypeId) {
        this.offerTypeId = offerTypeId;
    }

    /**
     *
     * @return
     * The readable
     */
    public String getReadable() {
        return readable;
    }

    /**
     *
     * @param readable
     * The readable
     */
    public void setReadable(String readable) {
        this.readable = readable;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
