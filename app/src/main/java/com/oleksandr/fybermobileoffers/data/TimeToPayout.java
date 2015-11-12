package com.oleksandr.fybermobileoffers.data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author o.dudinskyi(dudinskyj@gmail.com)
 */
public class TimeToPayout {
    private Integer amount;
    private String readable;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The amount
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     *
     * @param amount
     * The amount
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
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
