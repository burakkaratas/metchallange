package com.hotelspro.challange.burak.karatas.controllers.validators;

import com.hotelspro.challange.burak.karatas.controllers.util.CalculatorRestHelper;
import com.hotelspro.challange.burak.karatas.controllers.exceptions.BusinessException;
import com.hotelspro.challange.burak.karatas.models.request.CalculatorRestRequest;

/**
 * Created by bkaratas on 5/8/17.
 */
public class NullCheckValidator extends AbstractValidator {

    @Override
    public void validate(CalculatorRestRequest request) throws BusinessException {
        Double param1 = request.getBody().getParam1();
        Double param2 = request.getBody().getParam2();

        if (null == param1 || null == param2)
            throw new BusinessException(CalculatorRestHelper.getBusinessErrorMessage(NullCheckValidator.class.getSimpleName()));

        if (null != nextValidator)
            nextValidator.validate(request);
    }
}
