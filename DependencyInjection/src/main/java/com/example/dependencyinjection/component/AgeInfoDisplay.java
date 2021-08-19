package com.example.dependencyinjection.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

@Component
public class AgeInfoDisplay {
    private final Temporal temporal;
    private final Temporal today;
    private final Temporal now;

    public AgeInfoDisplay(@Qualifier("getBirhDateTemporal") Temporal localDate,
                          @Qualifier("todayTemporal") Temporal today,
                          @Qualifier("nowTemporal") Temporal now) {
        this.temporal = localDate;
        this.today = today;
        this.now = now;
    }

    @PostConstruct
    public void displayGetAge() throws InterruptedException {
        System.out.println("AgeInfoDisplay : " + DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss").format(now));
        Long age = ChronoUnit.DAYS.between(temporal, today) / 365;

        Thread.sleep(5000);



        System.out.printf("age : %d\n", age);
    }
}
