package com.hotelspro.challange.burak.karatas.controllers.validators;

import com.hotelspro.challange.burak.karatas.controllers.exceptions.BusinessException;
import com.hotelspro.challange.burak.karatas.controllers.util.CalculatorRestHelper;
import com.hotelspro.challange.burak.karatas.models.request.CalculatorRestRequest;
import com.hotelspro.challange.burak.karatas.models.request.RequestHeader;

/**
 * Created by bkaratas on 5/8/17.
 */
public class HeaderExistValidator extends AbstractValidator {

    @Override
    public void validate(CalculatorRestRequest request) throws BusinessException {
        RequestHeader header = request.getHeader();
        if (null == header)
            throw new BusinessException(CalculatorRestHelper.getBusinessErrorMessage(getSimpleClassName()));

        if (null != nextValidator)
            nextValidator.validate(request);
    }
}
