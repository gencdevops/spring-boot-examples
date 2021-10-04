package com.example.todoappjpa.service;

import com.example.todoappjpa.converter.TodoInfoConverter;
import com.example.todoappjpa.converter.TodoSaveConverter;
import com.example.todoappjpa.data.dal.TodoAppDAL;
import com.example.todoappjpa.dto.TodoInfoDTO;
import com.example.todoappjpa.dto.TodoSaveDTO;
import com.example.todoappjpa.util.DatabaseUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TodoService {
    private final TodoAppDAL todoAppDAL;
    private final TodoInfoConverter todoInfoConverter;
    private final TodoSaveConverter todoSaveConverter;

    public TodoService(TodoAppDAL todoAppDAL,
                       TodoInfoConverter todoInfoConverter,
                       TodoSaveConverter todoSaveConverter) {
        this.todoAppDAL = todoAppDAL;
        this.todoInfoConverter = todoInfoConverter;
        this.todoSaveConverter = todoSaveConverter;
    }

    private TodoInfoDTO saveCallback(TodoSaveDTO todoSaveDTO) {
    return todoInfoConverter.toTodoInfoDTO(todoAppDAL.saveTodo(todoSaveConverter.toTodo(todoSaveDTO)));
    }

    private List<TodoInfoDTO> findAllTodosCallback() {
        return StreamSupport.stream(todoAppDAL.findAllTodos().spliterator(), true)
                .map(todoInfoConverter::toTodoInfoDTO)
                .collect(Collectors.toList());
    }



    public TodoInfoDTO saveTodo(TodoSaveDTO todoSaveDTO) {
    return DatabaseUtil.doWorkForService(() -> saveCallback(todoSaveDTO),
            "TodoService.saveTodo");
    }

    public List<TodoInfoDTO> findAllTodos() {
        return DatabaseUtil.doWorkForService(this::findAllTodosCallback, "TodoService.findAll");
    }

}
