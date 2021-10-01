package com.example.movieapi.data.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MovieDirectorDetail {
    private Movie movie;
    private Director director;


    public MovieDirectorDetail(Movie movie, Director director) {
    this.movie = movie;
    this.director = director;
    }



    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

}
