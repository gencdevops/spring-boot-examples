package com.example.collectioninjection.operation;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class SampleCalculator {
    private final Collection<IIntBinaryOperator> operations;

    public void throwException() {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    public SampleCalculator(Collection<IIntBinaryOperator> operations) {
        this.operations = operations;
        System.out.println(operations.getClass().getName() + " size : " + operations.size());
    }


    public void calculate(int a, int b, char op) {
        operations.stream()
                .filter(ib -> ib.isValid(op))
                .findFirst()
                .ifPresentOrElse(ib -> System.out.printf("%d %c %d = %d", a, op, b, ib.applyAsInt(a, b))
                        , this::throwException);
    }

    public void calculateForAll(int a, int b, char op) {
        operations.stream()
                .filter(ib -> ib.isValid(op))
                .forEach(ib -> System.out.printf("%d %c %d = %d", a, op, b, ib.applyAsInt(a, b)));
    }
}
