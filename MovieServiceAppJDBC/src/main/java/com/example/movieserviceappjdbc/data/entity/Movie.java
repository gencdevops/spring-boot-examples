package com.example.movieserviceappjdbc.data.entity;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Movie {
    public long id;
    public String name;
    public LocalDateTime scene_time;
    public long rating;
    public BigDecimal cost;
    public float imdb;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getSceneTime() {
        return scene_time;
    }

    public void setSceneTime(LocalDateTime sceneTime) {
        this.scene_time = scene_time;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public float getImdb() {
        return imdb;
    }

    public void setImdb(float imdb) {
        this.imdb = imdb;
    }
}
