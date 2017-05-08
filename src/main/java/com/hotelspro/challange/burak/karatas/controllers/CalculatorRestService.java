package com.hotelspro.challange.burak.karatas.controllers;

import com.hotelspro.challange.burak.karatas.controllers.util.CalculatorRestHelper;
import com.hotelspro.challange.burak.karatas.controllers.validators.IValidator;
import com.hotelspro.challange.burak.karatas.controllers.validators.ValidatorGenerator;
import com.hotelspro.challange.burak.karatas.controllers.exceptions.BusinessException;
import com.hotelspro.challange.burak.karatas.models.enums.CalculateResponseStatus;
import com.hotelspro.challange.burak.karatas.models.enums.CalculateType;
import com.hotelspro.challange.burak.karatas.models.request.CalculatorRestRequest;
import com.hotelspro.challange.burak.karatas.models.response.*;
import com.hotelspro.challange.burak.karatas.models.response.builder.CalculatorResponseBuilder;
import com.hotelspro.challange.burak.karatas.services.CalculatorService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.hotelspro.challange.burak.karatas.models.enums.CalculateType.ADDITION;

/**
 * Created by bkaratas on 05.05.2017.
 */
@RestController
@RequestMapping("calc")
public class CalculatorRestService {

    private static final Logger LOGGER = Logger.getLogger(CalculatorRestService.class);

    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping(value = "addition", method = RequestMethod.POST)
    public CalculatorRestResponse additionMethod(@RequestBody CalculatorRestRequest requestModel) {
        try {
            validateRestRequest(requestModel, CalculateType.ADDITION);
        } catch (BusinessException e) {
            LOGGER.error(e.getMessage());
            return failedResponsePrepare(requestModel, e);
        }
        return calculateViaService(requestModel, ADDITION);
    }

    @RequestMapping(value = "subtraction", method = RequestMethod.POST)
    public CalculatorRestResponse subtractionMethod(@RequestBody CalculatorRestRequest requestModel) {
        try {
            validateRestRequest(requestModel, CalculateType.SUBSTRACTION);
        } catch (BusinessException e) {
            LOGGER.error(e.getMessage());
            return failedResponsePrepare(requestModel, e);
        }
        return calculateViaService(requestModel, CalculateType.SUBSTRACTION);
    }

    @RequestMapping(value = "division", method = RequestMethod.POST)
    public CalculatorRestResponse divisionMethod(@RequestBody CalculatorRestRequest requestModel) {
        try {
            validateRestRequest(requestModel, CalculateType.DIVISION);
        } catch (BusinessException e) {
            LOGGER.error(e.getMessage());
            return failedResponsePrepare(requestModel, e);
        }
        return calculateViaService(requestModel, CalculateType.DIVISION);
    }

    @RequestMapping(value = "multiply", method = RequestMethod.POST)
    public CalculatorRestResponse multiplyMethod(@RequestBody CalculatorRestRequest requestModel) {
        try {
            validateRestRequest(requestModel, CalculateType.MULTIPLY);
        } catch (BusinessException e) {
            LOGGER.error(e.getMessage());
            return failedResponsePrepare(requestModel, e);
        }
        return calculateViaService(requestModel, CalculateType.MULTIPLY);
    }

    @RequestMapping(value = "pow", method = RequestMethod.POST)
    public CalculatorRestResponse powMethod(@RequestBody CalculatorRestRequest requestModel) {
        try {
            validateRestRequest(requestModel, CalculateType.POW);
        } catch (BusinessException e) {
            LOGGER.error(e.getMessage());
            return failedResponsePrepare(requestModel, e);
        }
        return calculateViaService(requestModel, CalculateType.POW);
    }

    private CalculatorRestResponse calculateViaService(CalculatorRestRequest requestModel, CalculateType calculateType) {

        String user = requestModel.getHeader().getUser();
        ResponseHeader responseHeader = CalculatorRestHelper.prepareResponseHeader(user, CalculateResponseStatus.SUCCESS);

        Double param1 = requestModel.getBody().getParam1();
        Double param2 = requestModel.getBody().getParam2();
        Double result = calculatorService.calculate(param1, param2, calculateType);

        CalculatorResponseBodyWithSuccess calculatorResponseBody = new CalculatorResponseBodyWithSuccess();
        calculatorResponseBody.setResult(result);

        return new CalculatorResponseBuilder().setHeader(responseHeader).setBody(calculatorResponseBody).build();
    }

    private void validateRestRequest(CalculatorRestRequest requestModel, CalculateType calculateType) throws BusinessException {
        IValidator validator = null;
        switch (calculateType) {
            case ADDITION:
            case SUBSTRACTION:
            case MULTIPLY:
            case POW:
                validator = ValidatorGenerator.getBaseValidator();
                validator.validate(requestModel);
                break;
            case DIVISION:
                validator = ValidatorGenerator.getDivisionValidator();
                validator.validate(requestModel);
                break;
            default:
        }
    }

    private CalculatorRestResponse failedResponsePrepare(CalculatorRestRequest requestModel, BusinessException e) {
        String user = null;
        if (null != requestModel.getHeader() && null != requestModel.getHeader().getUser())
            user = requestModel.getHeader().getUser();
        ResponseHeader responseHeader = CalculatorRestHelper.prepareResponseHeader(user, CalculateResponseStatus.FAILED);
        CalculatorResponseBodyWithError calculatorResponseBodyWithError = new CalculatorResponseBodyWithError();
        calculatorResponseBodyWithError.setErrorDescription(e.getMessage());
        return new CalculatorResponseBuilder().setHeader(responseHeader).setBody(calculatorResponseBodyWithError).build();
    }

}