package com.example.movieapi.runner;

import com.example.movieapi.data.entity.Movie;
import com.example.movieapi.data.repository.IMovieRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;


@Component
public class FillDatabaseRunner implements ApplicationRunner {
    private final IMovieRepository movieRespository;

    public FillDatabaseRunner(IMovieRepository movieRespository) {
        this.movieRespository = movieRespository;
    }




    @Override
    public void run(ApplicationArguments args) throws Exception {
      movieRespository.findAll().forEach(System.out::println);

   }
}
