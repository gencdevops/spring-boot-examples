package com.example.movieapi.data.dataaccesslayer;


import com.example.movieapi.data.entity.Director;
import com.example.movieapi.data.entity.Movie;
import com.example.movieapi.data.entity.MovieDirectorDetail;
import com.example.movieapi.data.repository.IDirectorRepository;
import com.example.movieapi.data.repository.IMovieRepository;
import com.example.movieapi.util.DatabaseUtil;
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
      return DatabaseUtil.doWorkForRepository(movieRepository::findAll, "MovieServiceAppDAL.findALLMovies");
    }

    public long countMovies() {
        return DatabaseUtil.doWorkForRepository(movieRepository::count, "MovieServiceAppDAL.countmovies");
    }


    public Movie saveMovie(Movie movie) {
     return  DatabaseUtil.doWorkForRepository(() -> movieRepository.save(movie),
               "MovieServiceApplicationDAL.saveMovie");
    }

    public long countDirectors() {
       return DatabaseUtil.doWorkForRepository(directorRepository::count,
               "MovieServiceApplicationDAL.countDirectors");
    }

    public Director saveDirector(Director director) {
       return DatabaseUtil.doWorkForRepository(() -> directorRepository.save(director),
               "MovieServiceApplicationDAL.saveDirector");
    }

    public Iterable<Director> findAllDirectors() {
       return DatabaseUtil.doWorkForRepository(directorRepository::findAll,
               "MovieServiceApplicationDAL.findAllDirectors");
    }

    public Iterable<Movie> findMoviesByMonthYear(int month, int year) {
        return DatabaseUtil.doWorkForRepository(() -> movieRepository.findMoviesByMonthYear(month, year),
                "MovieAppDAL.findMoviesByMonthYear");
    }

    public Iterable<MovieDirectorDetail> findMoviesDetailsByYear(int year) {
        return DatabaseUtil.doWorkForRepository(() -> movieRepository.findMoviesDetailsByYear(year),
                "MovieServiceAppDAL.findMoviesDetailsByYear");
    }

    public Iterable<Movie> findMoviesByYear(int year) {
       return DatabaseUtil.doWorkForRepository(() -> movieRepository.findMoviesByYear(year), "MovieServiceAppDAL.findMoviesByYear");
    }


}
