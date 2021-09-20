package com.example.movieapi.data.repository;

import com.example.movieapi.data.entity.Movie;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MovieRepository implements IMovieRespository{
  private static final String SAVE_SQL = "insert into movies (name, scene_time, rating, cost, imdb) values(:name, :sceneTime, :rating, :cost, :imdb)";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public MovieRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

  @Override
  public <S extends Movie> S save(S movie) throws UnsupportedOperationException {
      KeyHolder keyHolder = new GeneratedKeyHolder();
      jdbcTemplate.update(SAVE_SQL,new BeanPropertySqlParameterSource(movie), keyHolder, new String[] {"movie_id"});
      movie.id = keyHolder.getKey().longValue();

    return movie;
  }


    @Override
    public long count() throws UnsupportedOperationException {
        return 0;
    }

    @Override
    public void delete(Movie entity) throws UnsupportedOperationException {

    }

    @Override
    public void deleteAll() throws UnsupportedOperationException {

    }

    @Override
    public void deleteAll(Iterable<? extends Movie> entities) throws UnsupportedOperationException {

    }

    @Override
    public void deleteById(Long aLong) throws UnsupportedOperationException {

    }

    @Override
    public boolean existsById(Long aLong) throws UnsupportedOperationException {
        return false;
    }

    @Override
    public Iterable<Movie> findAll() throws UnsupportedOperationException {
        return null;
    }

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> longs) throws UnsupportedOperationException {
        return null;
    }

    @Override
    public Optional<Movie> findById(Long aLong) throws UnsupportedOperationException {
        return Optional.empty();
    }



    @Override
    public <S extends Movie> Iterable<S> save(Iterable<S> entities) throws UnsupportedOperationException {
        return null;
    }
}
