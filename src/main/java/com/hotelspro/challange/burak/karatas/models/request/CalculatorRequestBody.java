package com.hotelspro.challange.burak.karatas.models.request;

/**
 * Created by bkaratas on 05.05.2017.
 */
public class CalculatorRequestBody extends BaseRequestModel {

    private Double param1;

    private Double param2;

    public CalculatorRequestBody() {
    }

    public Double getParam1() {
        return param1;
    }

    public void setParam1(Double param1) {
        this.param1 = param1;
    }

    public Double getParam2() {
        return param2;
    }

    public void setParam2(Double param2) {
        this.param2 = param2;
    }
}
