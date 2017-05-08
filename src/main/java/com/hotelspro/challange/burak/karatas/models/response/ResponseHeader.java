package com.hotelspro.challange.burak.karatas.models.response;

import com.hotelspro.challange.burak.karatas.models.enums.CalculateResponseStatus;

import java.util.Date;

/**
 * Created by bkaratas on 5/8/17.
 */
public class ResponseHeader {
    private CalculateResponseStatus responseStatus;
    private String requestedUser;
    private Date responseDate;

    public ResponseHeader() {
    }

    public ResponseHeader(CalculateResponseStatus responseStatus, String requestedUser, Date responseDate) {
        this.responseStatus = responseStatus;
        this.requestedUser = requestedUser;
        this.responseDate = responseDate;
    }

    public CalculateResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(CalculateResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getRequestedUser() {
        return requestedUser;
    }

    public void setRequestedUser(String requestedUser) {
        this.requestedUser = requestedUser;
    }

    public Date getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(Date responseDate) {
        this.responseDate = responseDate;
    }
}
