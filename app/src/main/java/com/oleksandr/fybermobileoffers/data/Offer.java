package com.oleksandr.fybermobileoffers.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author o.dudinskyi(dudinskyj@gmail.com)
 */
public class Offer {
    private String title;
    private Integer offerId;
    private String teaser;
    private String requiredActions;
    private String link;
    private List<OfferType> offerTypes = new ArrayList<OfferType>();
    private Thumbnail thumbnail;
    private Integer payout;
    private TimeToPayout timeToPayout;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The offerId
     */
    public Integer getOfferId() {
        return offerId;
    }

    /**
     *
     * @param offerId
     * The offer_id
     */
    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    /**
     *
     * @return
     * The teaser
     */
    public String getTeaser() {
        return teaser;
    }

    /**
     *
     * @param teaser
     * The teaser
     */
    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }

    /**
     *
     * @return
     * The requiredActions
     */
    public String getRequiredActions() {
        return requiredActions;
    }

    /**
     *
     * @param requiredActions
     * The required_actions
     */
    public void setRequiredActions(String requiredActions) {
        this.requiredActions = requiredActions;
    }

    /**
     *
     * @return
     * The link
     */
    public String getLink() {
        return link;
    }

    /**
     *
     * @param link
     * The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     *
     * @return
     * The offerTypes
     */
    public List<OfferType> getOfferTypes() {
        return offerTypes;
    }

    /**
     *
     * @param offerTypes
     * The offer_types
     */
    public void setOfferTypes(List<OfferType> offerTypes) {
        this.offerTypes = offerTypes;
    }

    /**
     *
     * @return
     * The thumbnail
     */
    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    /**
     *
     * @param thumbnail
     * The thumbnail
     */
    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     *
     * @return
     * The payout
     */
    public Integer getPayout() {
        return payout;
    }

    /**
     *
     * @param payout
     * The payout
     */
    public void setPayout(Integer payout) {
        this.payout = payout;
    }

    /**
     *
     * @return
     * The timeToPayout
     */
    public TimeToPayout getTimeToPayout() {
        return timeToPayout;
    }

    /**
     *
     * @param timeToPayout
     * The time_to_payout
     */
    public void setTimeToPayout(TimeToPayout timeToPayout) {
        this.timeToPayout = timeToPayout;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
