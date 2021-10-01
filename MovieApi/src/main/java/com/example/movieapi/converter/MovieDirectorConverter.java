package com.example.movieapi.converter;

import com.example.movieapi.data.entity.Director;
import com.example.movieapi.data.entity.Movie;
import com.example.movieapi.data.entity.MovieDirectorDetail;
import com.example.movieapi.dto.MovieDTO;
import com.example.movieapi.dto.MovieDetailDTO;
import org.springframework.stereotype.Component;

@Component
public class MovieDirectorConverter {
    private final MovieConverter movieConverter;
    private final DirectorConverter directorConverter;

    public MovieDirectorConverter(MovieConverter movieConverter, DirectorConverter directorConverter) {
        this.movieConverter = movieConverter;
        this.directorConverter = directorConverter;
    }


    public MovieDetailDTO toMovieDetailDTO(MovieDirectorDetail detail) {
        MovieDetailDTO movieDetailDTO = new MovieDetailDTO();

        movieDetailDTO.setMovieDTO(movieConverter.toMovieDTO(detail.getMovie()));
        movieDetailDTO.setDirectorName(directorConverter.toDirectorDTO(detail.getDirector()).getName());

        return movieDetailDTO;
    }
}
