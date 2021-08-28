package com.example.collectioninjection.configuration;


import com.example.collectioninjection.calculator.MyCalculator;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyCalcuratorConfig {
    private final MyCalculator myCalculator;

    public MyCalcuratorConfig(MyCalculator myCalcurator) {
        this.myCalculator = myCalcurator;
    }

    @Bean
    public ApplicationRunner runCalculator() {
        return args -> myCalculator.calculate();
    }

}
