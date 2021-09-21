package com.example.movieapi.service;

import com.example.movieapi.converter.MovieConverter;
import com.example.movieapi.data.entity.Movie;
import com.example.movieapi.data.repository.IMovieRepository;
import com.example.movieapi.dto.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieAppService {
    private final IMovieRepository movieRepository;
    private final MovieConverter movieConverter;

    public MovieAppService(IMovieRepository movieRepository, MovieConverter movieConverter) {
        this.movieRepository = movieRepository;
        this.movieConverter = movieConverter;
    }

    public List<MovieDTO> findAllMovies() {
    return StreamSupport.stream(movieRepository.findAll().spliterator(), false)
            .map(movieConverter::toMovieDTO)
            .collect(Collectors.toList());

    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public long countMovie() {
        return movieRepository.count();
    }

}
