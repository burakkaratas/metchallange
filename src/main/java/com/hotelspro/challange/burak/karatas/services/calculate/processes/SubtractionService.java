package com.hotelspro.challange.burak.karatas.services.calculate.processes;

import com.hotelspro.challange.burak.karatas.services.ICalculator;

/**
 * Created by bkaratas on 05.05.2017.
 */
public class SubtractionService implements ICalculator {

    @Override
    public Double process(Double param1, Double param2) {
        return param1 - param2;
    }
}
