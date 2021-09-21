package com.example.movieapi.data.repository;

import com.example.movieapi.data.entity.Movie;
import org.csystem.util.data.repository.ICrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface IMovieRepository extends ICrudRepository<Movie, Long> {
Iterable<Movie> findMoviesByYear(int year);
Iterable<Movie> findMoviesByMonthYear(int month, int year);
}
