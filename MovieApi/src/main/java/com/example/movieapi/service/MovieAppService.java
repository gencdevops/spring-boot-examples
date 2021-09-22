package com.example.movieapi.service;

import com.example.movieapi.converter.MovieConverter;
import com.example.movieapi.data.dataaccesslayer.MovieAppDAL;
import com.example.movieapi.data.entity.Movie;
import com.example.movieapi.dto.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieAppService {
   private final MovieAppDAL movieAppDAL;
    private final MovieConverter movieConverter;

    public MovieAppService(MovieAppDAL movieAppDal, MovieConverter movieConverter) {
        this.movieAppDAL = movieAppDal;
        this.movieConverter = movieConverter;
    }

    public List<MovieDTO> findAllMovies() {
        return StreamSupport.stream(movieAppDAL.findAllMovies().spliterator(), false)
                .map(movieConverter::toMovieDTO)
                .collect(Collectors.toList());

    }
    public long countMovies() {
        return movieAppDAL.countMovies();
    }


    public Movie saveMovie(Movie movie) {
        return movieAppDAL.saveMovie(movie);
    }



}
