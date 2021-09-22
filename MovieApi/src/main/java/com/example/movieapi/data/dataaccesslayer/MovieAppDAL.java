package com.example.movieapi.data.dataaccesslayer;


import com.example.movieapi.data.entity.Director;
import com.example.movieapi.data.entity.Movie;
import com.example.movieapi.data.repository.IDirectorRepository;
import com.example.movieapi.data.repository.IMovieRepository;
import com.example.movieapi.dto.MovieDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class MovieAppDAL {
    private final IMovieRepository movieRepository;
    private final IDirectorRepository directorRepository;

    public MovieAppDAL(IMovieRepository movieRepository, IDirectorRepository directorRepository) {
        this.movieRepository = movieRepository;
        this.directorRepository = directorRepository;
    }

    public Iterable<Movie> findAllMovies() {
        return movieRepository.findAll();

    }
    public long countMovies() {
        return movieRepository.count();
    }


    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public long countDirectors() {
        return directorRepository.count();
    }

    public Director saveDirector(Director director) {
        return directorRepository.save(director);
    }

    public Iterable<Director> findAllDirectors() {
        return directorRepository.findAll();
    }


}
