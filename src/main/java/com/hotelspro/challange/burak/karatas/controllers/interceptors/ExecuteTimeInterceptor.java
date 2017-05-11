package com.hotelspro.challange.burak.karatas.controllers.interceptors;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by bkaratas on 5/8/17.
 */
@Component
public class ExecuteTimeInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = Logger.getLogger(ExecuteTimeInterceptor.class);
    private static final String START_TIME_PRE_ATTRIBUTE_NAME = "startTimePre";
    private static final String START_TIME_POST_ATTRIBUTE_NAME = "startTimePost";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute(START_TIME_PRE_ATTRIBUTE_NAME, System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (long) request.getAttribute(START_TIME_PRE_ATTRIBUTE_NAME);
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;
        LOGGER.info(request.getRequestURI() + " endpoint response time :: " + executeTime + " ms" + " at postHandle");
        request.setAttribute(START_TIME_POST_ATTRIBUTE_NAME, System.currentTimeMillis());
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        long startTime = (long) httpServletRequest.getAttribute(START_TIME_POST_ATTRIBUTE_NAME);
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;
        LOGGER.info(httpServletRequest.getRequestURI() + " endpoint response time :: " + executeTime + " ms"  + " at afterCompletation");
    }

}
