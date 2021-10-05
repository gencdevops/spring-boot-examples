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

    private List<TodoInfoDTO> findTodosByTitleCallback(String title) {
        return StreamSupport.stream(todoAppDAL.findTodosByTitle(title).spliterator(), false)
                .map(todoInfoConverter::toTodoInfoDTO)
                .collect(Collectors.toList());
    }

    private TodoInfoDTO saveCallback(TodoSaveDTO todoSaveDTO) {
    return todoInfoConverter.toTodoInfoDTO(todoAppDAL.saveTodo(todoSaveConverter.toTodo(todoSaveDTO)));
    }

    private List<TodoInfoDTO> findAllTodosCallback() {
        return StreamSupport.stream(todoAppDAL.findAllTodos().spliterator(), true)
                .map(todoInfoConverter::toTodoInfoDTO)
                .collect(Collectors.toList());
    }

    private List<TodoInfoDTO> findTodosByCompletedCallback(boolean completed) {
        return StreamSupport.stream(todoAppDAL.findTodosByCompleted(completed).spliterator(), true)
                .map(todoInfoConverter::toTodoInfoDTO)
                .collect(Collectors.toList());
    }

    private List<TodoInfoDTO> findTodosByTitleContainsCallback(String text) {
        return StreamSupport.stream(todoAppDAL.findTodosByTitleContains(text).spliterator(), false)
                .map(todoInfoConverter::toTodoInfoDTO)
                .collect(Collectors.toList());
    }

    private List<TodoInfoDTO> findByCompletedAndTitleCallback(boolean completed, String title) {
        return StreamSupport.stream(todoAppDAL.findByCompletedAndTitle(completed,title).spliterator(), false)
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

    public List<TodoInfoDTO> findTodosByCompleted(boolean completed) {
        return DatabaseUtil.doWorkForService(() -> findTodosByCompletedCallback(completed),
                "TodoService.findTodosByCompleted");
    }

    public Iterable<TodoInfoDTO> findTodosByTitle(String title) {
        return DatabaseUtil.doWorkForService(() -> findTodosByTitleCallback(title),
                "TodoService.findTodosByTitle");
    }

    public Iterable<TodoInfoDTO> findTodosByTitleContains(String text) {
        return DatabaseUtil.doWorkForService(() -> findTodosByTitleContainsCallback(text),
                "TodoService.findTodosByTitleContains");
    }

    public Iterable<TodoInfoDTO> findByCompletedAndTitle(boolean comleted, String title) {
        return DatabaseUtil.doWorkForService(() -> findByCompletedAndTitleCallback(comleted,title),
                "TodoService.findByCompletedAndTitle");
    }

}
