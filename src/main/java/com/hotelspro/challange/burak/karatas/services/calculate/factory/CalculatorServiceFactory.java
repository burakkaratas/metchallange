package com.hotelspro.challange.burak.karatas.services.calculate.factory;

import com.hotelspro.challange.burak.karatas.models.enums.CalculateType;
import com.hotelspro.challange.burak.karatas.services.ICalculator;
import com.hotelspro.challange.burak.karatas.services.calculate.processes.*;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

/**
 * Created by bkaratas on 05.05.2017.
 */
@Service
@ApplicationScope
public class CalculatorServiceFactory {

    public ICalculator getCalculatorImplementation(CalculateType calculateType) {

        switch (calculateType) {
            case ADDITION:
                return new AdditionService();
            case DIVISION:
                return new DivisionService();
            case MULTIPLY:
                return new MultiplySercice();
            case SUBSTRACTION:
                return new SubtractionService();
            case POW:
                return new PowService();
        }
        return null;
    }
}
