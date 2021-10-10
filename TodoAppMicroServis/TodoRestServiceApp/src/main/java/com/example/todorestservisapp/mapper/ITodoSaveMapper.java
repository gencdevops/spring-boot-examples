package com.example.todorestservisapp.mapper;


import com.example.todorestservisapp.data.entity.Todo;
import com.example.todorestservisapp.dto.TodoSaveDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "TodoSaveMapperImpl", componentModel = "spring")
public interface ITodoSaveMapper {
    Todo toTodo(TodoSaveDTO todoSaveDTO);

    TodoSaveDTO toTodoSaveDTO(Todo todo);
}
