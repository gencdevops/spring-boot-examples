package com.example.valueannotation.component;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class FirstOperation {
    @Value("${operation.first.operand1}")
    private int a;
    @Value("${operation.first.operand2}")
    private int b;
    @Value("${operation.first.operator}")
    private String prefix;

    @PostConstruct
    public void doOperation() {
        System.out.printf("%s:%d + %d = %d%n", prefix, a, b, a + b);
    }

}
