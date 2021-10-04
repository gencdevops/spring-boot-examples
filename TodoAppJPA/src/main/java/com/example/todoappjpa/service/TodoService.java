package com.example.todoappjpa.service;

import com.example.todoappjpa.converter.TodoInfoConverter;
import com.example.todoappjpa.converter.TodoSaveConverter;
import com.example.todoappjpa.data.dal.TodoAppDAL;
import com.example.todoappjpa.dto.TodoInfoDTO;
import com.example.todoappjpa.dto.TodoSaveDTO;
import com.example.todoappjpa.util.DatabaseUtil;
import org.springframework.stereotype.Service;

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



    public TodoInfoDTO saveTodo(TodoSaveDTO todoSaveDTO) {
    return DatabaseUtil.doWorkForService(() -> saveCallback(todoSaveDTO),
            "TodoService.saveTodo");
    }
}
