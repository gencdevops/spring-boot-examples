package com.example.todoappjpa.converter;

import com.example.todoappjpa.data.entity.Todo;
import com.example.todoappjpa.dto.TodoInfoDTO;
import org.springframework.stereotype.Component;

@Component
public class TodoInfoConverter {
    public Todo toTodo(TodoInfoDTO todoInfoDTO) {
    Todo todo = new Todo();

    todo.setTitle(todoInfoDTO.getTitle());
    todo.setText(todoInfoDTO.getText());

    return todo;
    }

    public TodoInfoDTO toTodoInfoDTO(Todo todo) {
        TodoInfoDTO todoInfoDTO = new TodoInfoDTO();

        todoInfoDTO.setTitle(todo.getTitle());
        todoInfoDTO.setText(todo.getText());
        todoInfoDTO.setInsertDateTime(todo.getInsertDateTime());
        todoInfoDTO.setLastUpdate(todo.getLastUpdate());
        todoInfoDTO.setCompleted(todo.isCompleted());

        return todoInfoDTO;
    }
}
