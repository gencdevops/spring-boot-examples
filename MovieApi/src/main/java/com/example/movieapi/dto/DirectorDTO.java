package com.example.movieapi.dto;

import java.time.LocalDate;

public class DirectorDTO {
    private String m_name;
    private LocalDate birthDate;

    public String getName() {
        return m_name;
    }

    public void setName(String m_name) {
        this.m_name = m_name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
