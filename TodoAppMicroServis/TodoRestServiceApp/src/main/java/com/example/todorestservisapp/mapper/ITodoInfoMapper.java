package com.example.todorestservisapp.mapper;

import com.example.todorestservisapp.data.entity.Todo;
import com.example.todorestservisapp.dto.TodoInfoDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "TodoInfoMapperImpl", componentModel = "spring")
public interface ITodoInfoMapper {
    Todo toTodo(TodoInfoDTO todoInfoDTO);
    TodoInfoDTO toTodoInfoDTO(Todo todo);
}
