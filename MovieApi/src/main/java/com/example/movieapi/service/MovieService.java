package com.example.movieapi.service;

import com.example.movieapi.converter.DirectorConverter;
import com.example.movieapi.converter.MovieConverter;
import com.example.movieapi.data.dataaccesslayer.MovieAppDAL;
import com.example.movieapi.dto.DirectorDTO;
import com.example.movieapi.dto.MovieDTO;
import com.example.movieapi.util.DatabaseUtil;
import org.csystem.util.data.repository.RepositoryException;
import org.csystem.util.data.service.DataServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieService {
    private final MovieAppDAL movieAppDAL;
    private final MovieConverter movieConverter;

    private List<MovieDTO> findAllMoviesCallback() {
        return StreamSupport.stream(movieAppDAL.findAllMovies().spliterator(), false)
                .map(movieConverter::toMovieDTO)
                .collect(Collectors.toList());
    }

    private List<MovieDTO> findMoviesByMonthYearCallback(int month, int year) {
        return StreamSupport.stream(movieAppDAL.findMoviesByMonthYear(month,year).spliterator(),false)
                .map(movieConverter::toMovieDTO)
                .collect(Collectors.toList());
    }

    private List<MovieDTO> findMoviesByYearCallback(int year) {
        return StreamSupport.stream(movieAppDAL.findMoviesByYear(year).spliterator(), false)
                .map(movieConverter::toMovieDTO)
                .collect(Collectors.toList());
    }



    public MovieService(MovieAppDAL movieAppDAL, MovieConverter movieConverter) {
        this.movieAppDAL = movieAppDAL;
        this.movieConverter = movieConverter;
    }

    public List<MovieDTO> findAllMovies() {
       return DatabaseUtil.doWorkForService(this::findAllMovies,
               "MovieAppService.findAllMovies");

    }

    public long countMovies() {
       return DatabaseUtil.doWorkForService(movieAppDAL::countMovies,
               "MovieAppService.countMovies");
    }


    public MovieDTO saveMovie(MovieDTO movieDTO) {
        try {
            movieAppDAL.saveMovie(movieConverter.toMovie(movieDTO));
            return movieDTO;
        } catch (RepositoryException ex) {
            throw new DataServiceException("MovieAppService.saveMovie", ex.getCause());
        }
    }


    public List<MovieDTO> findMoviesByMonthYear(int month, int year) {
     return  DatabaseUtil.doWorkForService(() -> findMoviesByMonthYearCallback(month, year),
               "MovieAppService.findMoviesByMonthYear");
    }

    public List<MovieDTO> findMoviesByYear(int year) {

     return  DatabaseUtil.doWorkForService( () -> findMoviesByYear(year) ,
             "MovieAppService.findMoviesByYear");


    }


}
