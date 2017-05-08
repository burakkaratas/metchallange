package com.hotelspro.challange.burak.karatas.controllers.util;

import com.hotelspro.challange.burak.karatas.models.enums.CalculateResponseStatus;
import com.hotelspro.challange.burak.karatas.models.response.ResponseHeader;

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

    public static String getBusinessErrorMessage(String className){
        return className + " is break validator chain !!";
    }

}
