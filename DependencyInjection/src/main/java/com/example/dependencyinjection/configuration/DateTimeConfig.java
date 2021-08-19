package com.example.dependencyinjection.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

@Configuration
public class DateTimeConfig {
    public DateTimeConfig() {
        System.out.println("datetimeconfig constructor");
    }

    @Bean // Bean ismi vermezsek default olarak metot ismi ile aynı olur
    public Temporal getBirhDateTemporal() {
        System.out.println("DateTimeConfig.getBirthDateTemporal LocalDate döndü : " );
        return LocalDate.of(1994,12, 7);
    }

    @Bean("todayTemporal")
    @Scope("prototype")
    public Temporal createTodayTemporal() {
        return LocalDate.now();
    }

    @Bean("nowTemporal")
    @Scope("prototype")
    public Temporal createNowTemporal() {
        System.out.println("DateTimeConfig.createNowTemporal");
        return LocalDateTime.now();
    }


}
