package com.hotelspro.challange.burak.karatas.models.enums;

/**
 * Created by bkaratas on 5/8/17.
 */
public enum CalculateResponseStatus {
    FAILED(-1), SUCCESS(0);

    CalculateResponseStatus(int i) {

    }

    CalculateResponseStatus getFrom(String stringStatuss) {
        switch (stringStatuss) {
            case "FAILED":
                return FAILED;
            case "SUCCESS":
                return SUCCESS;
        }
        return null;
    }
}
