package com.example.movieapi.controller;

import com.example.movieapi.dto.MovieDTO;
import com.example.movieapi.service.MovieService;
import org.csystem.util.data.service.DataServiceException;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/movie")
@Scope("prototype")
public class MovieController {
    private final MovieService movieService;


    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/all")
    public List<MovieDTO> findAll() {
        try {
            return movieService.findAllMovies();
        } catch (DataServiceException ex) {
            return new ArrayList<>(); //to do exception
        }
    }

    @GetMapping("/info")
    public List<MovieDTO> findMovieByYear(@RequestParam("year") int year) {
        try {
            return movieService.findMoviesByYear(year);
        } catch (DataServiceException ex) {
            return new ArrayList<>(); //to do exception
        }
    }

    @GetMapping("/infos")
    public List<MovieDTO> findMovieByYear(@RequestParam("year") String yearStr) {
        try {
            return movieService.findMoviesByYear(Integer.parseInt(yearStr));
        } catch (DataServiceException | NumberFormatException ex) {
            return new ArrayList<>(); //to do exception
        }
    }

    @GetMapping("/count")
    public long count() {
        return movieService.countMovies();
    }

}
