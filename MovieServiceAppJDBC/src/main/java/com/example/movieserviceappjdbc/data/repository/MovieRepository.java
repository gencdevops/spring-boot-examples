package com.example.movieserviceappjdbc.data.repository;


import com.example.movieserviceappjdbc.data.entity.Movie;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class MovieRepository implements IMovieRepository{
    private static final String SAVE_SQL = "insert into movies (name, rating, scene_time, cost, imdb) " +
            "values (:name, :rating, :sceneTime, :cost, :imdb)";
    private static final String COUNT_SQL = "select count(*) from movies";
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public MovieRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static void fillCounts(ResultSet resultSet, ArrayList<Long> counts) throws SQLException {
        do{
            counts.add(resultSet.getLong(1));
        }while(resultSet.next());
    }

    @Override
    public <S extends Movie> S save(S movie) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        var parameterSource = new BeanPropertySqlParameterSource(movie);
        parameterSource.registerSqlType("sceneTime", Types.DATE);
        jdbcTemplate.update(SAVE_SQL, parameterSource, keyHolder, new String[] {"movie_id"});
      movie.id = keyHolder.getKey().longValue();
        return movie;
    }

    @Override
    public long count() {
       var counts = new ArrayList<Long>();
    jdbcTemplate.query(COUNT_SQL, (ResultSet rs) -> fillCounts(rs,counts));
    return counts.isEmpty() ? 0 : counts.get(0);
    }

    @Override
    public Iterable<Movie> findMoviesByYear(int year) {
        return null;
    }

    @Override
    public Iterable<Movie> findMoviesByMonthYear(int month, int year) {
        return null;
    }

    @Override
    public <S extends Movie> Iterable<S> save(Iterable<S> entities) {
        throw new UnsupportedOperationException();
    }



    @Override
    public void delete(Movie entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Movie> entities) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Movie> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> longs) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Movie> findById(Long aLong) {
        throw new UnsupportedOperationException();
    }



}
