package com.example.collectioninjection.parameter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ParamaterInfo {

    @Value("${paracalc.a}")
    public int a;
    @Value("${paracalc.b}")
    public int b;
    @Value("${paracalc.op:*}")
    public char op;







}
