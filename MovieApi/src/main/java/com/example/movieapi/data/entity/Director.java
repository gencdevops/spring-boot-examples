package com.example.movieapi.data.entity;

import java.time.LocalDate;

public class Director {
    private long m_id;
    private String m_name;
    private LocalDate m_birthDate;

    public Director() {


    }


    public Director(long m_id, String name, LocalDate birthDate) {
        this.m_id = m_id;
        this.m_name = name;
        this.m_birthDate = birthDate;
    }


    public long getId() {
        return m_id;
    }

    public void setId(long m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public LocalDate getBirthDate() {
        return m_birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.m_birthDate = birthDate;
    }
}
