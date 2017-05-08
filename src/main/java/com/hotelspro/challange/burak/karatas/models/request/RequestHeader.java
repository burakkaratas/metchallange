package com.hotelspro.challange.burak.karatas.models.request;

/**
 * Created by bkaratas on 5/8/17.
 */
public class RequestHeader {
    private String user;
    private String token;
    private String client;

    public RequestHeader() {
    }

    public RequestHeader(String user, String token, String client) {
        this.user = user;
        this.token = token;
        this.client = client;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
