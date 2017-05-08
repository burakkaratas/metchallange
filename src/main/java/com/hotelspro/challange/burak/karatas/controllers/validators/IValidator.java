package com.hotelspro.challange.burak.karatas.controllers.validators;

import com.hotelspro.challange.burak.karatas.controllers.exceptions.BusinessException;
import com.hotelspro.challange.burak.karatas.models.request.CalculatorRestRequest;

/**
 * Created by bkaratas on 5/8/17.
 */
public interface IValidator {
    void validate(CalculatorRestRequest request) throws BusinessException;
}
