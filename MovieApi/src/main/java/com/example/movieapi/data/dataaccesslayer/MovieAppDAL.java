package com.example.movieapi.data.dataaccesslayer;


import com.example.movieapi.data.entity.Director;
import com.example.movieapi.data.entity.Movie;
import com.example.movieapi.data.repository.IDirectorRepository;
import com.example.movieapi.data.repository.IMovieRepository;
import org.csystem.util.data.repository.RepositoryException;
import org.springframework.stereotype.Component;

@Component
public class MovieAppDAL {
    private final IMovieRepository movieRepository;
    private final IDirectorRepository directorRepository;

    public MovieAppDAL(IMovieRepository movieRepository, IDirectorRepository directorRepository) {
        this.movieRepository = movieRepository;
        this.directorRepository = directorRepository;
    }

    public Iterable<Movie> findAllMovies() {
        try {
            return movieRepository.findAll();
        } catch (Throwable ex) {
            throw new RepositoryException("MovieServiceApplivationDAL.findAllMovies", ex);
        }
    }

    public long countMovies() {
        try {
            return movieRepository.count();
        } catch (Throwable ex) {
            throw new RepositoryException("MovieServiceApplivationDAL.countMovies", ex);
        }
    }


    public Movie saveMovie(Movie movie) {
        try {
            return movieRepository.save(movie);
        } catch (Throwable ex) {
            throw new RepositoryException("MovieServiceApplivationDAL.saveMovie", ex);
        }
    }

    public long countDirectors() {
        try {
            return directorRepository.count();
        } catch (Throwable ex) {
            throw new RepositoryException("MovieServiceApplivationDAL.countDirectors", ex);
        }
    }

    public Director saveDirector(Director director) {
        try {
            return directorRepository.save(director);
        } catch (Throwable ex) {
            throw new RepositoryException("MovieServiceApplivationDAL.saveDirector", ex);
        }
    }

    public Iterable<Director> findAllDirectors() {
        try {
            return directorRepository.findAll();
        } catch (Throwable ex) {
            throw new RepositoryException("MovieServiceApplivationDAL.findAllDirectors", ex);
        }
    }

    public Iterable<Movie> findMoviesByMonthYear(int month, int year) {
        try {
        return movieRepository.findMoviesByMonthYear(month,year);
        } catch (Throwable ex) {
            throw new RepositoryException("MovieAppDAL.findMoviesByMonthYear", ex);
        }
    }

    public Iterable<Movie> findMoviesByYear(int year) {
        try {
        return movieRepository.findMoviesByYear(year);
        } catch (Throwable ex) {
            throw new RepositoryException("MovieAppDAL.findMoviesByYear", ex);
        }
    }


}
