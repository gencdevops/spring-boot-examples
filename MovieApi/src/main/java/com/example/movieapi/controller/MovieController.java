package com.example.movieapi.controller;

import com.example.movieapi.data.entity.Movie;
import com.example.movieapi.dto.MovieDTO;
import com.example.movieapi.service.MovieAppService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/movie")
@Scope("prototype")
public class MovieController {
private final MovieAppService movieAppService;


    public MovieController(MovieAppService movieAppService) {
        this.movieAppService = movieAppService;
    }

    @GetMapping("/movies")
    public List<MovieDTO> findAll() {
    return movieAppService.findAllMovies();
    }

    @GetMapping("/count")
    public long count() {
        return movieAppService.countMovie();
    }

}
