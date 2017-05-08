package com.hotelspro.challange.burak.karatas.models.enums;

/**
 * Created by bkaratas on 05.05.2017.
 */
public enum CalculateType {
    ADDITION, SUBSTRACTION, DIVISION, MULTIPLY, POW;

    public CalculateType getFrom(String calculate) {

        switch (calculate) {
            case "ADDITION":
                return ADDITION;
            case "SUBSTRACTION":
                return SUBSTRACTION;
            case "DIVISION":
                return DIVISION;
            case "MULTIPLY":
                return MULTIPLY;
            case "POW":
                return POW;
        }
        return null;
    }
}
