package com.example.movieapi.data.repository;

import com.example.movieapi.data.entity.Movie;
import org.csystem.util.data.repository.ICrudRepository;

import java.util.Optional;

public interface IMovieRespository extends ICrudRepository<Movie, Long> {
Iterable<Movie> findMoviesByYear(int year);
Iterable<Movie> findMoviesByMonthYear(int month, int year);
}
