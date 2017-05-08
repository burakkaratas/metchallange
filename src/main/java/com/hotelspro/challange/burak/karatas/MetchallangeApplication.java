package com.hotelspro.challange.burak.karatas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MetchallangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetchallangeApplication.class, args);
    }

}
