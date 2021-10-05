package com.example.todoappjpa.converter;

import com.example.todoappjpa.data.entity.Todo;
import com.example.todoappjpa.dto.TodoSaveDTO;
import org.springframework.stereotype.Component;

@Component
public class TodoSaveConverter {
    public Todo toTodo(TodoSaveDTO todoSaveDTO) {
        Todo todo = new Todo();
        todo.title = todoSaveDTO.getTitle();
        todo.text = todoSaveDTO.getText();

        return todo;
    }

    public TodoSaveDTO toTodoSaveDTO(Todo todo) {
        TodoSaveDTO todoSaveDTO = new TodoSaveDTO();
        todoSaveDTO.setTitle(todo.title);
        todoSaveDTO.setText(todo.text);

        return todoSaveDTO;
    }
}
