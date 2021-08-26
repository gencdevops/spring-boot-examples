package com.example.applicationrunner.component.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class ThirdOperation {
    @Value("90")
    private int a;
    @Value("${operation.second.operand2}")
    private int b;
    @Value("Third")
    private String prefix;


    public void doOperation() {
        System.out.printf("%s:%d + %d = %d%n", prefix, a, b, a + b);
    }
}
