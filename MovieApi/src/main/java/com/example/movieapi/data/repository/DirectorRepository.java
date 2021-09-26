package com.example.movieapi.data.repository;


import com.example.movieapi.data.entity.Director;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class DirectorRepository implements IDirectorRepository{

    private static final String FIND_ALL_SQL = "select * from directors";
    private static final String SAVE_SQL = "insert into directors(name, birth_date) values (:name, :birthDate)";

    private final NamedParameterJdbcTemplate jdbcTemplate;


    public DirectorRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static void fillDirectors(ResultSet rs , ArrayList<Director> directors) throws SQLException {
        do {
            long id = rs.getLong(1);
            String name = rs.getString(2);
            LocalDate birthDate = rs.getDate(3).toLocalDate();

            directors.add(new Director(id, name, birthDate));
        }while(rs.next());


    }

    @Override
    public Iterable<Director> findAll() {
        var directors =  new ArrayList<Director>();
        jdbcTemplate.query(FIND_ALL_SQL, (ResultSet rs) -> fillDirectors(rs, directors));

        return directors;
    }

    @Override
    public <S extends Director> S save(S director) {
        var keyHolder = new GeneratedKeyHolder();
        var parameterSource = new BeanPropertySqlParameterSource(director);

        parameterSource.registerSqlType("birthDate" , Types.DATE);

        jdbcTemplate.update(SAVE_SQL, parameterSource, keyHolder, new String[] {"director_id"});

        director.setId(keyHolder.getKey().longValue());

        return director;
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
    public Iterable<Director> findAllById(Iterable<Long> longs) {
        throw new  UnsupportedOperationException();
    }

    @Override
    public Optional<Director> findById(Long aLong) {
        throw new  UnsupportedOperationException();    }



    @Override
    public <S extends Director> Iterable<S> save(Iterable<S> entities) {
        throw new  UnsupportedOperationException();
    }
}
