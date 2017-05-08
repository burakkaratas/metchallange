package com.hotelspro.challange.burak.karatas.configuration;

import com.hotelspro.challange.burak.karatas.controllers.interceptors.ExecuteTimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by bkaratas on 5/8/17.
 */
@Configuration
@ComponentScan("com.hotelspro.challange")
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Autowired
    ExecuteTimeInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }
}
