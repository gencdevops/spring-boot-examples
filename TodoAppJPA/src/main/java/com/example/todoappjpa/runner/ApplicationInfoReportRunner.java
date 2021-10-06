package com.example.todoappjpa.runner;

import com.example.todoappjpa.data.repository.ITodoRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class ApplicationInfoReportRunner implements ApplicationRunner {
    private final ApplicationContext applicationContext;

    public ApplicationInfoReportRunner(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("---------------");
        System.out.println("Todos:");
        ITodoRepository todoRepository = applicationContext.getBean(ITodoRepository.class);
        todoRepository.findAll().forEach(td -> System.out.println(td.title));
        System.out.println("---------------");
        System.out.println("Application name : "+ applicationContext.getApplicationName());
        System.out.println("----------------");
        System.out.println("Application id : " + applicationContext.getId());
        System.out.println("-----------------");
        System.out.println("Bean/Component info:");
        System.out.println("Bean definition count : " + applicationContext.getBeanDefinitionCount());
        System.out.println("Beans name : ");
        Stream.of(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println("----------------");


    }
}
