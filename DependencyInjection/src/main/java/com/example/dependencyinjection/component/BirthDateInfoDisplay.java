package com.example.dependencyinjection.component;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Component
public class BirthDateInfoDisplay {
    private final LocalDate localDate;


    BirthDateInfoDisplay(LocalDate localDate) {
        this.localDate = localDate;
    }

    @PostConstruct
    public void displayBirthDate() {
        String birthDateText = DateTimeFormatter.ofPattern("dd:MM:yyyy").format(localDate);
        System.out.println("BirthDateInfoDisplay.displayBirthDate : " + birthDateText);

    }




}
