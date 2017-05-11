package com.hotelspro.challange.burak.karatas.controllers.validators;

import com.hotelspro.challange.burak.karatas.controllers.exceptions.BusinessException;
import com.hotelspro.challange.burak.karatas.controllers.util.CalculatorRestHelper;
import com.hotelspro.challange.burak.karatas.models.request.CalculatorRequestBody;
import com.hotelspro.challange.burak.karatas.models.request.CalculatorRestRequest;

/**
 * Created by bkaratas on 5/8/17.
 */
public class BodyExistValidator extends AbstractValidator {

    @Override
    public void validate(CalculatorRestRequest request) throws BusinessException {
        CalculatorRequestBody body = request.getBody();
        if (null == body)
            throw new BusinessException(CalculatorRestHelper.getBusinessErrorMessage(BodyExistValidator.class.getSimpleName()));

        if (null != nextValidator)
            nextValidator.validate(request);
    }
}
