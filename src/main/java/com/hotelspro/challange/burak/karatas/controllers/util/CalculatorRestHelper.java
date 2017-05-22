package com.hotelspro.challange.burak.karatas.controllers.util;

import com.hotelspro.challange.burak.karatas.controllers.exceptions.BusinessException;
import com.hotelspro.challange.burak.karatas.controllers.validators.IValidator;
import com.hotelspro.challange.burak.karatas.controllers.validators.ValidatorGenerator;
import com.hotelspro.challange.burak.karatas.models.enums.CalculateResponseStatus;
import com.hotelspro.challange.burak.karatas.models.enums.CalculateType;
import com.hotelspro.challange.burak.karatas.models.request.CalculatorRestRequest;
import com.hotelspro.challange.burak.karatas.models.response.CalculatorResponseBodyWithError;
import com.hotelspro.challange.burak.karatas.models.response.CalculatorResponseBodyWithSuccess;
import com.hotelspro.challange.burak.karatas.models.response.CalculatorRestResponse;
import com.hotelspro.challange.burak.karatas.models.response.ResponseHeader;
import com.hotelspro.challange.burak.karatas.models.response.builder.CalculatorResponseBuilder;

import java.util.Date;

/**
 * Created by bkaratas on 5/8/17.
 */
public class CalculatorRestHelper {

    public static ResponseHeader prepareResponseHeader(String user, CalculateResponseStatus status) {
        ResponseHeader result = new ResponseHeader();
        result.setResponseDate(new Date());
        result.setResponseStatus(status);
        result.setRequestedUser(user);
        return result;
    }

    public static CalculatorRestResponse failedResponsePrepare(CalculatorRestRequest requestModel, BusinessException e) {
        String user = null;
        if (null != requestModel.getHeader() && null != requestModel.getHeader().getUser())
            user = requestModel.getHeader().getUser();
        ResponseHeader responseHeader = CalculatorRestHelper.prepareResponseHeader(user, CalculateResponseStatus.FAILED);
        CalculatorResponseBodyWithError calculatorResponseBodyWithError = new CalculatorResponseBodyWithError();
        calculatorResponseBodyWithError.setErrorDescription(e.getMessage());
        return new CalculatorResponseBuilder().setHeader(responseHeader).setBody(calculatorResponseBodyWithError).build();
    }

    public static String getBusinessErrorMessage(String className) {
        return className + " is break validator chain !!";
    }

    public static IValidator getValidatorForCalculateType(CalculateType calculateType) {
        switch (calculateType) {
            case ADDITION:
            case SUBSTRACTION:
            case MULTIPLY:
            case POW:
                return ValidatorGenerator.getBaseValidator();
            case DIVISION:
                return ValidatorGenerator.getDivisionValidator();
            default:
        }
        return ValidatorGenerator.getBaseValidator();
    }

}
