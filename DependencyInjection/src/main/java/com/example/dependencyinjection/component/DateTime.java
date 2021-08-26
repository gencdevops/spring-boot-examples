package com.example.dependencyinjection.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

@Component("myDateTime")
@Scope("prototype")
public class DateTime {
    private final Temporal date;
    private final Temporal time;

    public DateTime(@Qualifier("today")Temporal date,
                    @Qualifier("timeNow") Temporal time) {
        this.date = date;
        this.time = time;
    }

    public String toDateString() {
        return DateTimeFormatter.ofPattern("dd:MM:yyyy").format(date);
    }
    public String toTimeString() {
        return DateTimeFormatter.ofPattern("hh:mm:ss").format(time);
    }

    @Override
    public String toString() {
        return toDateString() + " " +  toTimeString();
    }
}
