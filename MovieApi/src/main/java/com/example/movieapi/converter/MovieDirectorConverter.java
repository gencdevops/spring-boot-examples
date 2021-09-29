package com.example.movieapi.converter;

import com.example.movieapi.data.entity.Director;
import com.example.movieapi.data.entity.Movie;
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


    public MovieDetailDTO toMovieDetailDTO(Movie movie, Director director) {
        MovieDetailDTO movieDetailDTO = new MovieDetailDTO();

        var movieDTO = movieConverter.toMovieDTO(movie);
        var directorDTO = directorConverter.toDirectorDTO(director);
        movieDetailDTO.setName(movie.getName());
        movieDetailDTO.setSceneTimeStr(movieDTO.getSceneTimeStr());
        movieDetailDTO.setRating(movieDTO.getRating());
        movieDetailDTO.setCost(movieDTO.getCost());
        movieDetailDTO.setDirectorName(directorDTO.getName());

        return movieDetailDTO;
    }
}
