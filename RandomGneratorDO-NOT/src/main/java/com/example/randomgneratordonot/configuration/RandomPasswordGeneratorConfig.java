package com.example.randomgneratordonot.configuration;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Configuration
public class RandomPasswordGeneratorConfig {
    private final FileOutputStream fileOutputStreamFirst1;
    private final FileOutputStream fileOutputStreamFirst2;

    private void runForFirstCallback() throws InterruptedException, IOException {
        var dos = new DataOutputStream(fileOutputStreamFirst1);

    for(int i = 0; i < count; ++i) {
        dos.writeUTF(i + "");
        Thread.sleep(1000);
     }
    }

    private void runForSecondCallback() throws InterruptedException, IOException{
        var dos = new DataOutputStream(fileOutputStreamFirst2);

        for(int i = 0; i < count; ++i) {
            dos.writeUTF(i + "");
            Thread.sleep(1000);
        }
    }

    public RandomPasswordGeneratorConfig(@Qualifier("first") FileOutputStream fileOutputStreamFirst1,
                                         @Qualifier("second") FileOutputStream fileOutputStreamFirst2) {
        this.fileOutputStreamFirst1 = fileOutputStreamFirst1;
        this.fileOutputStreamFirst2 = fileOutputStreamFirst2;
    }
    @Value("${timeout}")
    private long timeout;

    @Value("${count}")
    private int count;

    @Bean
    public ApplicationRunner runForFirstFile() {
    return args -> runForFirstCallback();
    }

   @Bean
    public ApplicationRunner runForSecondFile() {
    return args -> runForSecondCallback();
    }



}
