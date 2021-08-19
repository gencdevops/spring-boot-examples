package com.example.dependencyinjection.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DateTimeConfig {
    public DateTimeConfig() {
        System.out.println("datetimeconfig constructor");
    }

    @Bean
    public LocalDate getBirhDate() {
        System.out.println("DateTimeConfig.getBirthDate LocalDate döndü : " );
        return LocalDate.of(1994,12, 7);
    }


}
