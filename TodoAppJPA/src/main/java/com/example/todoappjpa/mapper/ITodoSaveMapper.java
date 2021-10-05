package com.example.todoappjpa.mapper;


import com.example.todoappjpa.data.entity.Todo;
import com.example.todoappjpa.dto.TodoSaveDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "TodoSaveMapperImpl", componentModel = "spring")
public interface ITodoSaveMapper {
    Todo toTodo(TodoSaveDTO todoSaveDTO);
    TodoSaveDTO toTodoSaveDTO(Todo todo);
}
