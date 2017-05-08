package com.hotelspro.challange.burak.karatas.models.response;

/**
 * Created by bkaratas on 5/8/17.
 */
public class CalculatorResponseBodyWithError extends CalculatorResponseBody {

    private String errorDescription;

    public CalculatorResponseBodyWithError() {
    }

    public CalculatorResponseBodyWithError(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
