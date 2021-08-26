package com.example.applicationrunner.component.runner;


import com.example.applicationrunner.component.SecondOperation;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SecondOperationRunner implements ApplicationRunner {
    private final SecondOperation secondOperation;

    public SecondOperationRunner(SecondOperation secondOperation) {
        this.secondOperation = secondOperation;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
    secondOperation.doOperation();
    }
}
