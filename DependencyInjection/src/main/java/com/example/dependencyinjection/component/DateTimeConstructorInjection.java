package com.example.dependencyinjection.component;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DateTimeConstructorInjection {
    private final DateTime dateTime;

    public DateTimeConstructorInjection(@Qualifier("myDateTime") DateTime dateTime) {
        this.dateTime = dateTime;
    }

    @PostConstruct
    public void displayDateTime() {
        System.out.println("-----------------------------------------------");
        System.out.println("DateTimeConstructorInjection" + dateTime);
        System.out.println("-----------------------------------------------");

    }
}
