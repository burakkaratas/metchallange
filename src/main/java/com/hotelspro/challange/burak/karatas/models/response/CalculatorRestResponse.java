package com.hotelspro.challange.burak.karatas.models.response;

/**
 * Created by bkaratas on 5/8/17.
 */
public class CalculatorRestResponse {

    private ResponseHeader header;
    private CalculatorResponseBody body;

    public CalculatorRestResponse() {
    }

    public CalculatorRestResponse(ResponseHeader header, CalculatorResponseBody body) {
        this.header = header;
        this.body = body;
    }

    public ResponseHeader getHeader() {
        return header;
    }

    public void setHeader(ResponseHeader header) {
        this.header = header;
    }

    public CalculatorResponseBody getBody() {
        return body;
    }

    public void setBody(CalculatorResponseBody body) {
        this.body = body;
    }
}
