package com.example.applicationrunner.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SecondOperation {
    @Value("${operation.second.operand1:80}")
    private int a;
    @Value("${operation.second.operand2}")
    private int b;
    @Value("${operation.second.operator}")
    private String prefix;

    @PostConstruct
    public void doOperation() {
        System.out.printf("%s:%d + %d = %d%n", prefix, a, b, a + b);
    }
}
