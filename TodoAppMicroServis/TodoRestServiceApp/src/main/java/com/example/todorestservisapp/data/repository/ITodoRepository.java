package com.example.todorestservisapp.data.repository;

import com.example.todorestservisapp.data.entity.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ITodoRepository extends CrudRepository<Todo, Long> {

    //select * from todos where completed = :completed
    // @Query("select td from Todo td where td.completed = :completed")
    Iterable<Todo> findByCompleted(boolean completed);

    //@Query("select t from Todo t where t.title = ?1")
    Iterable<Todo> findByTitle(String title);

    // @Query("select td from Todo td where td.title like %:text%")
    Iterable<Todo> findByTitleContains(String title);

    // @Query("select td from Todo td where td.completed = :completed and td.title = :title")
    Iterable<Todo> findByCompletedAndTitle(boolean completed, String title);


    //@Query("select td from Todo td where td.completed = :completed and td.title like %:text%")
    Iterable<Todo> findByCompletedAndTitleContains(boolean completed, String title);


    @Query(value = "select * from todos where date_part('month', insert_date_time)=?", nativeQuery = true)
    Iterable<Todo> findByMonth(int month);


}
