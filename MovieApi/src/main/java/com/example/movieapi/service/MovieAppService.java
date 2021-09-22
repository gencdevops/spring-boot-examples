package com.example.movieapi.service;

import com.example.movieapi.converter.DirectorConverter;
import com.example.movieapi.converter.MovieConverter;
import com.example.movieapi.data.dataaccesslayer.MovieAppDAL;
import com.example.movieapi.data.entity.Movie;
import com.example.movieapi.dto.DirectorDTO;
import com.example.movieapi.dto.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieAppService {
   private final MovieAppDAL movieAppDAL;
    private final MovieConverter movieConverter;
    private final DirectorConverter directorConverter;

    public MovieAppService(MovieAppDAL movieAppDAL, MovieConverter movieConverter, DirectorConverter directorConverter) {
        this.movieAppDAL = movieAppDAL;
        this.movieConverter = movieConverter;
        this.directorConverter = directorConverter;
    }

    public List<MovieDTO> findAllMovies() {
        return StreamSupport.stream(movieAppDAL.findAllMovies().spliterator(), false)
                .map(movieConverter::toMovieDTO)
                .collect(Collectors.toList());

    }
    public long countMovies() {
        return movieAppDAL.countMovies();
    }


    public MovieDTO saveMovie(MovieDTO movieDTO) {
         movieAppDAL.saveMovie(movieConverter.toMovie(movieDTO));
         return movieDTO;
    }

    public DirectorDTO saveDirector(DirectorDTO directorDTO) {
    movieAppDAL.saveDirector(directorConverter.toDirector(directorDTO));
    return directorDTO;
    }

    public List<DirectorDTO> findAllDirectors() {
        return StreamSupport.stream(movieAppDAL.findAllDirectors().spliterator(), false)
                .map(directorConverter::toDirectorDTO)
                .collect(Collectors.toList());

    }


}
