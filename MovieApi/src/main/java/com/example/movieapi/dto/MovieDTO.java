package com.example.movieapi.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;


public class MovieDTO {
    private String m_name;
    private String m_sceneTimeStr;
    private long m_rating;
    private BigDecimal m_cost;

    public String getName() {
        return m_name;
    }

    public void setName(String m_name) {
        this.m_name = m_name;
    }

    public String getSceneTimeStr() {
        return m_sceneTimeStr;
    }

    public void setSceneTimeStr(String m_sceneTimeStr) {
        this.m_sceneTimeStr = m_sceneTimeStr;
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
}
