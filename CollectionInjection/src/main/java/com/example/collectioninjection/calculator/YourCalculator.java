package com.example.collectioninjection.calculator;

import com.example.collectioninjection.operation.SampleCalculator;
import com.example.collectioninjection.parameter.ParamaterInfo;
import org.springframework.stereotype.Component;

@Component
public class YourCalculator {
    private final SampleCalculator calculator;
    private final ParamaterInfo paramaterInfo;


    public YourCalculator(SampleCalculator calculator, ParamaterInfo paramaterInfo) {
        this.calculator = calculator;
        this.paramaterInfo = paramaterInfo;
    }


    public void calculate(){
    calculator.calculateForAll(paramaterInfo.a, paramaterInfo.b, paramaterInfo.op);
    }

}
