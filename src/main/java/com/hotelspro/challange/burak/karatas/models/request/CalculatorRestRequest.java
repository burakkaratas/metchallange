package com.hotelspro.challange.burak.karatas.models.request;

/**
 * Created by bkaratas on 5/8/17.
 */
public class CalculatorRestRequest {
    private RequestHeader header;
    private CalculatorRequestBody body;

    public CalculatorRestRequest() {
    }

    public CalculatorRestRequest(RequestHeader header, CalculatorRequestBody body) {
        this.header = header;
        this.body = body;
    }

    public RequestHeader getHeader() {
        return header;
    }

    public void setHeader(RequestHeader header) {
        this.header = header;
    }

    public CalculatorRequestBody getBody() {
        return body;
    }

    public void setBody(CalculatorRequestBody body) {
        this.body = body;
    }
}
