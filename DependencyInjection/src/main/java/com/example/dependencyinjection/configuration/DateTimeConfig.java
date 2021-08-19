package com.example.dependencyinjection.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;

@Configuration
public class DateTimeConfig {
    public DateTimeConfig() {
        System.out.println("datetimeconfig constructor");
    }

    @Bean // Bean ismi vermezsek default olarak metot ismi ile aynı olur
    public Temporal getBirhDateTemporal() {
        System.out.println("-----------------------------------------------");

        System.out.println("DateTimeConfig.getBirthDateTemporal LocalDate döndü : " );
        System.out.println("-----------------------------------------------");

        return LocalDate.of(1994,12, 7);

    }

    @Bean("today")
    @Scope("prototype")
    public Temporal createToday() {
        return LocalDate.now();
    }

    @Bean("now")
    @Scope("prototype")
    public Temporal createNow() {
        System.out.println("-----------------------------------------------");

        System.out.println("DateTimeConfig.createNow");
        System.out.println("-----------------------------------------------");

        return LocalDateTime.now();
    }

    @Bean("timeNow")
    @Scope("prototype")
    public Temporal createTimeNow() {
        return LocalTime.now();
    }



}
