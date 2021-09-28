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


    public MovieService(MovieAppDAL movieAppDAL, MovieConverter movieConverter) {
        this.movieAppDAL = movieAppDAL;
        this.movieConverter = movieConverter;
    }

    public List<MovieDTO> findAllMovies() {
        try {
            return StreamSupport.stream(movieAppDAL.findAllMovies().spliterator(), false)
                    .map(movieConverter::toMovieDTO)
                    .collect(Collectors.toList());
        } catch (RepositoryException ex) {
            throw new DataServiceException("MovieAppServive.findAllMovies", ex.getCause());
        }

    }

    public long countMovies() {
        try {
            return movieAppDAL.countMovies();
        } catch (RepositoryException ex) {
            throw new DataServiceException("MovieAppService.countMovies", ex.getCause());
        }
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
        try {
      return StreamSupport.stream(movieAppDAL.findMoviesByMonthYear(month,year).spliterator(),false)
              .map(movieConverter::toMovieDTO)
              .collect(Collectors.toList());
        } catch (RepositoryException ex) {
            throw new DataServiceException("MovieAppService.findMoviesByMonthYear", ex.getCause());
        }
    }

    public List<MovieDTO> findMoviesByYear(int year) {

     return  DatabaseUtil.doWorkForService( () ->  StreamSupport.stream(movieAppDAL.findMoviesByYear(year).spliterator(), false)
                .map(movieConverter::toMovieDTO)
                .collect(Collectors.toList()),  "MovieAppService.findMoviesByYear");


    }


}
