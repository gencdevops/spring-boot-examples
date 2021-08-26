package com.example.applicationrunner.configuration;


import com.example.applicationrunner.component.runner.ThirdOperation;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationRunnerConfig {
 private final ThirdOperation thirdOperation;

    public ApplicationRunnerConfig(ThirdOperation thirdOperation) {
        this.thirdOperation = thirdOperation;
    }

    @Bean
    public ApplicationRunner runThirdOperation() {
        return args -> thirdOperation.doOperation();
    }
}
