package com.example.todoappjpa.mapper;

import com.example.todoappjpa.data.entity.Todo;
import com.example.todoappjpa.dto.TodoInfoDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "TodoInfoMapperImpl", componentModel = "spring")
public interface ITodoInfoMapper {
    Todo toTodo(TodoInfoDTO todoInfoDTO);
    TodoInfoDTO toTodoInfoDTO(Todo todo);
}
