package com.example.movieapi.data.repository;

import com.example.movieapi.data.entity.Movie;
import org.csystem.util.data.repository.RepositoryException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class MovieRepository implements IMovieRepository {
    private static final String SAVE_SQL = "insert into movies (name, scene_time, rating, cost, imdb) values(:name, :sceneTime, :rating, :cost, :imdb)";
    private static final String COUNT_SQL = "select count(*) from movies";
    private static final String FIND_BY_MONTH_YEAR_SQL = "select * from movies where date_part('month', scene_time) = 9 and date_part('year', scene_time) = 2021";
    private static final String FIND_BY_YEAR_SQL = "select * from movies where date_part('year', scene_time) = 2020";
    private static final String FIND_ALL_SQL = "select * from movies";


    private final NamedParameterJdbcTemplate jdbcTemplate;

    public MovieRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static void fillCounts(ResultSet resultSet, ArrayList<Long> counts) throws SQLException {
        do{
            counts.add(resultSet.getLong(1));
        }while(resultSet.next());
    }

    private static void fillMovies(ResultSet resultSet, ArrayList<Movie> movies) throws SQLException{
        do{
            long id = resultSet.getLong(1);
            String name = resultSet.getString(2);
            LocalDate sceneTime = resultSet.getDate(3).toLocalDate();
            long rating = resultSet.getLong(4);
            BigDecimal cost = resultSet.getBigDecimal(5);
            float imdb = resultSet.getFloat(6);

            movies.add(new Movie(id, name, sceneTime, rating, cost, imdb));

        }while(resultSet.next());
    }

    @Override
    public Iterable<Movie> findMoviesByMonthYear(int month, int year) {
        return null;
    }

    @Override
    public Iterable<Movie> findMoviesByYear(int year) {
       throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Movie> findAll() throws UnsupportedOperationException {

           var movies = new ArrayList<Movie>();
           jdbcTemplate.query(FIND_ALL_SQL, (ResultSet rs) -> fillMovies(rs,movies));

           return movies;

    }


    @Override
    public long count() throws UnsupportedOperationException {
        var counts = new ArrayList<Long>();
        jdbcTemplate.query(COUNT_SQL,(ResultSet rs) -> fillCounts(rs,counts));

        return counts.isEmpty() ? 0 : counts.get(0);
    }

  @Override
  public <S extends Movie> S save(S movie) throws UnsupportedOperationException {
      KeyHolder keyHolder = new GeneratedKeyHolder();
      BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(movie);
      parameterSource.registerSqlType("sceneTime", Types.DATE);

      jdbcTemplate.update(SAVE_SQL,parameterSource, keyHolder, new String[] {"movie_id"});


      movie.setId(keyHolder.getKey().longValue());

    return movie;
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
