package com.example.dependencyinjection.component;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DateTimeFieldInjection {
    @Autowired
    private  DateTime dateTime;

    @PostConstruct
    public void displayDateTime() {
        System.out.println("-----------------------------------------------");
        System.out.println("DateTimeFieldInjection" + dateTime);
        System.out.println("-----------------------------------------------");

    }



}
