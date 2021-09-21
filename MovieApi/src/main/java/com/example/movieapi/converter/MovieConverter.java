package com.example.movieapi.converter;


import com.example.movieapi.data.entity.Movie;
import com.example.movieapi.dto.MovieDTO;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class MovieConverter {
    private final DateTimeFormatter dateTimeFormatter;

    public MovieConverter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    public MovieDTO toMovieDTO(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName(movie.getName());
        movieDTO.setSceneTimeStr(dateTimeFormatter.format(movie.getSceneTime()));
        movieDTO.setCost(movie.getCost());
        movieDTO.setRating(movie.getRating());

        return movieDTO;
    }

    public Movie toMovie(MovieDTO movieDTO) {
        throw new UnsupportedOperationException();
    }
}
