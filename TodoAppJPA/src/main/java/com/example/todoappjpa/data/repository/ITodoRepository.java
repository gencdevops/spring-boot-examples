package com.example.todoappjpa.data.repository;

import com.example.todoappjpa.data.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface ITodoRepository extends CrudRepository<Todo, Long> {

}
