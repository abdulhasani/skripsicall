package com.jmat.skripsicall.support.wrapper;





import com.jmat.skripsicall.support.AppConstants;
import com.jmat.skripsicall.support.Notification;

import java.util.List;

/**
 * Created by User on 2/28/2016.
 */
public class ResponseWrapper<T> {
    private final String apiVersion= AppConstants.API_VERSION;

    private List<Notification> notifications;

    private T Data;

    public ResponseWrapper() {
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }
}
