package com.example.createobjectautowithcomponent.component;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateAndTimeDisplay {
    public DateAndTimeDisplay() {
        System.out.println("DateAndTimeDisplay . DateAndTimeDisplay() ");
    }

    @PostConstruct
    public void DisplayTime() {
        LocalTime now = LocalTime.now();

        String nowText = DateTimeFormatter.ofPattern("hh:mm:ss").format(now);

        System.out.println("DateAndTimeDisplay.DisplayTime : " + nowText);
    }

    @PostConstruct
    public void DisplayDate() {
        LocalDate today = LocalDate.now();

        String nowText = DateTimeFormatter.ofPattern("dd:MM:yyyy").format(today);

        System.out.println("DateAndTimeDisplay.DisplayDate : " + nowText);
    }

}
