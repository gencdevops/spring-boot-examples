package com.example.collectioninjection.calculator;

import com.example.collectioninjection.operation.SampleCalculator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class MyCalculator {
    private final SampleCalculator sampleCalculator;

    @Value("${mycalc.a}")
    private int a;
    @Value("${mycalc.b}")
    private int b;
    @Value("${mycalc.op}")
    private char op;



    public MyCalculator(SampleCalculator sampleCalculator) {
        this.sampleCalculator = sampleCalculator;
    }

    public void calculate() {
    sampleCalculator.calculate(a,b,op);
    }

}
