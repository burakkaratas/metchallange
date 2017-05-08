package com.hotelspro.challange.burak.karatas.models.response.builder;

import com.hotelspro.challange.burak.karatas.models.response.CalculatorResponseBody;
import com.hotelspro.challange.burak.karatas.models.response.CalculatorRestResponse;
import com.hotelspro.challange.burak.karatas.models.response.ResponseHeader;

/**
 * Created by bkaratas on 5/8/17.
 */
public class CalculatorResponseBuilder {

    private ResponseHeader header;

    private CalculatorResponseBody body;

    public CalculatorResponseBuilder() {
    }

    public CalculatorResponseBuilder setHeader(ResponseHeader header) {
        this.header = header;
        return this;
    }

    public CalculatorResponseBuilder setBody(CalculatorResponseBody body) {
        this.body = body;
        return this;
    }

    public CalculatorRestResponse build() {
        CalculatorRestResponse result = new CalculatorRestResponse();
        result.setHeader(this.header);
        result.setBody(this.body);
        return result;
    }
}
