package com.example.movieserviceappjdbc.data.repository;

import com.example.movieserviceappjdbc.data.entity.Movie;
import org.csystem.util.data.repository.ICrudRepository;

import java.util.Optional;

public interface IMovieRepository extends ICrudRepository<Movie, Long> {
Iterable<Movie> findMoviesByYear(int year);
Iterable<Movie> findMoviesByMonthYear(int month, int year);

}
