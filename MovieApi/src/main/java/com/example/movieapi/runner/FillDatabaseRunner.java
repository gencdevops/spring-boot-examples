package com.example.movieapi.runner;

import com.example.movieapi.data.entity.Movie;
import com.example.movieapi.data.repository.IMovieRespository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Component
public class FillDatabaseRunner implements ApplicationRunner {
    private final IMovieRespository movieRespository;

    public FillDatabaseRunner(IMovieRespository movieRespository) {
        this.movieRespository = movieRespository;
    }




    @Override
    public void run(ApplicationArguments args) throws Exception {
        Movie movie = new Movie();
        movie.name = "Inseption";
        movie.sceneTime = LocalDate.now();
        movie.rating =100000;
        movie.cost = new BigDecimal(10000000);
        movie.imdb = 7.6F;

        movieRespository.save(movie);
        System.out.println("id : " + movie.id);
    }
}
