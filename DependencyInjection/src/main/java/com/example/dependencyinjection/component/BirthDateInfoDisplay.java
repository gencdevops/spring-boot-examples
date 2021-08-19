package com.example.dependencyinjection.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;


@Component
public class BirthDateInfoDisplay {
    private final Temporal localDate;
    private final Temporal now;


    BirthDateInfoDisplay(
            @Qualifier("getBirhDateTemporal") Temporal localDate,
            @Qualifier("now") Temporal now) {
        this.localDate = localDate;
        this.now = now;
    }

    @PostConstruct
    public void displayBirthDate() {
        System.out.println("-----------------------------------------------");

        String birthDateText = DateTimeFormatter.ofPattern("dd:MM:yyyy").format(localDate);

        System.out.println("BirthDateInfoDisplay.displayBirthDate : " + birthDateText);
        System.out.println("BirthDateInfoDisplay : " + DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss").format(now));
        System.out.println("-----------------------------------------------");

    }


}
