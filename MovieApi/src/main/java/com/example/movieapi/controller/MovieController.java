package com.example.movieapi.controller;

import com.example.movieapi.dto.MovieDTO;
import com.example.movieapi.dto.MovieDetailDTO;
import com.example.movieapi.service.MovieService;
import org.csystem.util.data.service.DataServiceException;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.csystem.util.exception.ExceptionUtil.subscribe;

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
    public List<MovieDTO> findMovieByYear(@RequestParam("year") int year)
    {
        return subscribe(() -> movieService.findMoviesByYear(year), ex -> new ArrayList<>());
    }

    @GetMapping("/infos")
    public List<MovieDTO> findMovieByYear(@RequestParam("year") String yearStr)
    {
        return subscribe(() -> movieService.findMoviesByYear(Integer.parseInt(yearStr)), ex -> new ArrayList<>());
    }

    @GetMapping("/infosre")
    public ResponseEntity<List<MovieDTO>> findMovieByYearResponseEntity(@RequestParam("year") String yearStr)
    {
        ResponseEntity<List<MovieDTO>> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(movieService.findMoviesByYear(Integer.parseInt(yearStr)));
        }
        catch (DataServiceException|NumberFormatException ex) {
            //...
        }

        return responseEntity;
    }

    @GetMapping("/info/detail")
    public ResponseEntity<List<MovieDetailDTO>> findMoviesDetailsByYear(@RequestParam("year") String yearStr)
    {
        ResponseEntity<List<MovieDetailDTO>> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(movieService.findMoviesDetailsByYear(Integer.parseInt(yearStr)));
        }
        catch (DataServiceException|NumberFormatException ex) {
            //...
        }

        return responseEntity;
    }

    @GetMapping("/count")
    public long count() {
        return movieService.countMovies();
    }

}
