package com.hotelspro.challange.burak.karatas.models.response;

import com.hotelspro.challange.burak.karatas.models.response.CalculatorResponseBody;

/**
 * Created by bkaratas on 5/8/17.
 */
public class CalculatorResponseBodyWithSuccess extends CalculatorResponseBody {

    private Double result;

    public void setResult(Double result) {
        this.result = result;
    }

    public Double getResult() {
        return result;
    }
}
