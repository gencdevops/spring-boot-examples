package com.example.todoappjpa.converter;

import com.example.todoappjpa.data.entity.Todo;
import com.example.todoappjpa.dto.TodoInfoDTO;
import org.springframework.stereotype.Component;

@Component
public class TodoInfoConverter {
    public Todo toTodo(TodoInfoDTO todoInfoDTO) {
        Todo todo = new Todo();

        todo.title = todoInfoDTO.getTitle();
        todo.text = todoInfoDTO.getText();
        return todo;
    }

    public TodoInfoDTO toTodoInfoDTO(Todo todo) {
        TodoInfoDTO todoInfoDTO = new TodoInfoDTO();

        todoInfoDTO.setTitle(todo.title);
        todoInfoDTO.setText(todo.title);
        todoInfoDTO.setInsertDateTime(todo.insertDateTime);
        todoInfoDTO.setLastUpdate(todo.lastUpdate);
        todoInfoDTO.setCompleted(todo.completed);

        return todoInfoDTO;
    }
}
