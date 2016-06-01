package com.jmat.skripsicall.support.transfer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmat.skripsicall.support.AppConstants;
import com.jmat.skripsicall.support.Notification;


import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by User on 2/28/2016.
 */
@XmlRootElement
public class EnvelopeTransfer<T> {

    private final String apiVerison = AppConstants.API_VERSION;
    private List<Notification> notifications;
    private T Data;

    public EnvelopeTransfer() {
    }

    public EnvelopeTransfer(T data) {
        Data = data;
    }

    @JsonProperty("api_verison")
    public String getApiVerison() {
        return apiVerison;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    @JsonProperty("data")
    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }
}
