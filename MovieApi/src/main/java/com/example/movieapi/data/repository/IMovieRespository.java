package com.example.movieapi.data.repository;

import com.example.movieapi.data.entity.Movie;
import org.csystem.util.data.repository.ICrudRepository;

import java.util.Optional;

public interface IMovieRespository extends ICrudRepository<Movie, Long> {
    @Override
    long count() throws UnsupportedOperationException;

    @Override
    void delete(Movie entity) throws UnsupportedOperationException;

    @Override
    void deleteAll() throws UnsupportedOperationException;

    @Override
    void deleteAll(Iterable<? extends Movie> entities) throws UnsupportedOperationException;

    @Override
    void deleteById(Long aLong) throws UnsupportedOperationException;

    @Override
    boolean existsById(Long aLong) throws UnsupportedOperationException;

    @Override
    Iterable<Movie> findAll() throws UnsupportedOperationException;

    @Override
    Iterable<Movie> findAllById(Iterable<Long> longs) throws UnsupportedOperationException;

    @Override
    Optional<Movie> findById(Long aLong) throws UnsupportedOperationException;

    @Override
    <S extends Movie> S save(S entity) throws UnsupportedOperationException;

    @Override
    <S extends Movie> Iterable<S> save(Iterable<S> entities) throws UnsupportedOperationException;
}
