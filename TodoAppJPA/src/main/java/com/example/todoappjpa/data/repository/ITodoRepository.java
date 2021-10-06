package com.example.todoappjpa.data.repository;

import com.example.todoappjpa.data.entity.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ITodoRepository extends CrudRepository<Todo, Long> {

    //select * from todos where completed = :completed
    //@Query("select td from Todo td where td.completed = :completed")
    Iterable<Todo> findByCompleted(boolean completed);

    //@Query("select t from Todo t where t.title = ?1")
    Iterable<Todo> findByTitle(String title);



    //@Query("select t from Todo t where t.title like %?1%")
    Iterable<Todo> findByTitleContains(String title);

    //@Query("select t from Todo t where t.completed = ?1 and t.title = ?2")
    Iterable<Todo> findByCompletedAndTitle(boolean completed, String title);


    //@Query("select t from Todo t where t.completed = ?1 or t.title = ?2")
    Iterable<Todo> findByCompletedAndTitleContains(boolean completed, String title);


    @Query(value ="select * from todos where date_part('month', insert_date_time)=?", nativeQuery = true)
    Iterable<Todo> findByMonth(int month);


}
