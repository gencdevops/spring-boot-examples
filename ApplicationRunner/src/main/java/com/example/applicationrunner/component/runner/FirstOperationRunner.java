package com.example.applicationrunner.component.runner;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class FirstOperationRunner implements ApplicationRunner {
    @Value("${operation.first.operand1}")
    private int a;
    @Value("${operation.first.operand2}")
    private int b;
    @Value("${operation.first.operator}")
    private String prefix;

    @Override
    public void run(ApplicationArguments args) {
        System.out.printf("%s:%d + %d = %d%n", prefix, a, b, a + b);
    }

}
