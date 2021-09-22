package com.example.movieapi.data.entity;

import java.time.LocalDate;

public class Director {
    private int m_id;
    private String name;
    private LocalDate birthDate;

    public Director() {

    }

    public Director(int m_id, String name, LocalDate birthDate) {
        this.m_id = m_id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
