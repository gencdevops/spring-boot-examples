package com.example.movieapi.service;

import com.example.movieapi.data.entity.Movie;
import com.example.movieapi.data.repository.IMovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieAppService {
    private final IMovieRepository movieRepository;

    public MovieAppService(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAllMovies() {
        return StreamSupport.stream(movieRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

}
