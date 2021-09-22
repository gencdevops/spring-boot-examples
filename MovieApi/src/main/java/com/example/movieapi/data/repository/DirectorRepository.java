package com.example.movieapi.data.repository;


import com.example.movieapi.data.entity.Director;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DirectorRepository implements IDirectorRepository{

    private final NamedParameterJdbcTemplate jdbcTemplate;


    public DirectorRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public long count() {
        throw new  UnsupportedOperationException();
    }

    @Override
    public void delete(Director entity) {
        throw new  UnsupportedOperationException();
    }

    @Override
    public void deleteAll() {
        throw new  UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Director> entities) {
        throw new  UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long aLong) {
        throw new  UnsupportedOperationException();
    }

    @Override
    public boolean existsById(Long aLong) {
        throw new  UnsupportedOperationException();
    }

    @Override
    public Iterable<Director> findAll() {
        throw new  UnsupportedOperationException();
    }

    @Override
    public Iterable<Director> findAllById(Iterable<Long> longs) {
        throw new  UnsupportedOperationException();
    }

    @Override
    public Optional<Director> findById(Long aLong) {
        throw new  UnsupportedOperationException();    }

    @Override
    public <S extends Director> S save(S entity) {
        throw new  UnsupportedOperationException();
    }

    @Override
    public <S extends Director> Iterable<S> save(Iterable<S> entities) {
        throw new  UnsupportedOperationException();
    }
}
