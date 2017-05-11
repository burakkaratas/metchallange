package com.hotelspro.challange.burak.karatas.services;

import com.hotelspro.challange.burak.karatas.models.enums.CalculateType;
import com.hotelspro.challange.burak.karatas.services.calculate.factory.CalculatorServiceFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by bkaratas on 05.05.2017.
 */
@Service
public class CalculatorService {

    private static final Logger LOGGER = Logger.getLogger(CalculatorService.class);

    @Autowired
    private CalculatorServiceFactory serviceFactory;

    @Cacheable(value = "calculateCache")
    public Double calculate(Double param1, Double param2, CalculateType calculateType) {
        LOGGER.info(param1 + " and " + param2 + " will be calculate, operation :: " + calculateType);

        Double result = serviceFactory.getCalculatorImplementation(calculateType).process(param1, param2);

        LOGGER.info(param1 + " and " + param2 + " was calculated, operation :: " + calculateType + ", result :: " + result);

        return result;
    }

}
