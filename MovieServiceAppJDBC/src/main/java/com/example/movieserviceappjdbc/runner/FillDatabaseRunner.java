package com.example.movieserviceappjdbc.runner;

import com.example.movieserviceappjdbc.data.entity.Movie;
import com.example.movieserviceappjdbc.data.repository.IMovieRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class FillDatabaseRunner implements ApplicationRunner {




    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
