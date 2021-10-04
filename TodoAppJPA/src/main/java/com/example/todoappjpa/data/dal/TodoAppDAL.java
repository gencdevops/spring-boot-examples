package com.example.todoappjpa.data.dal;


import com.example.todoappjpa.data.entity.Todo;
import com.example.todoappjpa.data.repository.ITodoRepository;
import com.example.todoappjpa.util.DatabaseUtil;
import org.springframework.stereotype.Component;

@Component
public class TodoAppDAL {

    private final ITodoRepository todoRepository;

    public TodoAppDAL(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo saveTodo(Todo todo) {
       return DatabaseUtil.doWorkForRepository(() -> todoRepository.save(todo),
               "TodoAppDAL.saveTodo");
    }

    public Iterable<Todo> findAllTodos() {
        return DatabaseUtil.doWorkForRepository(todoRepository::findAll, "TodoAppDAL.findAll");
    }

}
