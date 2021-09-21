package com.example.movieapi.data.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Movie {
    private long m_id;
    private String m_name;
    private LocalDate m_sceneTime;
    private long m_rating;
    private BigDecimal m_cost;
    private float m_imdb;

    public Movie() {

    }

    public Movie(long m_id, String m_name, LocalDate m_sceneTime, long m_rating, BigDecimal m_cost, float m_imdb) {
        this.m_id = m_id;
        this.m_name = m_name;
        this.m_sceneTime = m_sceneTime;
        this.m_rating = m_rating;
        this.m_cost = m_cost;
        this.m_imdb = m_imdb;
    }

    public long getId() {
        return m_id;
    }

    public void setId(long m_id) {
        this.m_id = m_id;
    }

    public String getName() {
        return m_name;
    }

    public void setName(String m_name) {
        this.m_name = m_name;
    }

    public LocalDate getSceneTime() {
        return m_sceneTime;
    }

    public void setSceneTime(LocalDate m_sceneTime) {
        this.m_sceneTime = m_sceneTime;
    }

    public long getRating() {
        return m_rating;
    }

    public void setRating(long m_rating) {
        this.m_rating = m_rating;
    }

    public BigDecimal getCost() {
        return m_cost;
    }

    public void setCost(BigDecimal m_cost) {
        this.m_cost = m_cost;
    }

    public float getImdb() {
        return m_imdb;
    }

    public void setImdb(float m_imdb) {
        this.m_imdb = m_imdb;
    }
    @Override
    public String toString() {
        return "Movie{" +
                "m_id=" + m_id +
                ", m_name='" + m_name + '\'' +
                ", m_sceneTime=" + m_sceneTime +
                ", m_rating=" + m_rating +
                ", m_cost=" + m_cost +
                ", m_imdb=" + m_imdb +
                '}';
    }
}
