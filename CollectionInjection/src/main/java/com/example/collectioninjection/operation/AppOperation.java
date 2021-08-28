package com.example.collectioninjection.operation;


import org.springframework.stereotype.Component;

@Component
public class AppOperation implements IIntBinaryOperator{




    @Override
    public boolean isValid(char op) {
        return op == '+';
    }

    @Override
    public int applyAsInt(int left, int right) {
        return left + right;
    }
}
