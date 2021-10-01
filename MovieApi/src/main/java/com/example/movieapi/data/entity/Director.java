package com.example.movieapi.data.entity;

import java.time.LocalDate;

public class Director {
    private long m_id;
    private String m_name;
    private LocalDate m_birthDate;

    public Director() {


    }

    public Director(String name) {
        this(0, name, null);
    }

    public Director(long id, String name) {
       this(id, name, null);
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

    public String getName() {
        return m_name;
    }

    public void setName(String m_name) {
        this.m_name = m_name;
    }

    public LocalDate getBirthDate() {
        return m_birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.m_birthDate = birthDate;
    }
}
