package com.example.todoappjpa.controller;


import com.example.todoappjpa.dto.TodoInfoDTO;
import com.example.todoappjpa.dto.TodoSaveDTO;
import com.example.todoappjpa.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("save")
    public TodoInfoDTO saveTodo(@RequestBody TodoSaveDTO todoSaveDTO) {
        return todoService.saveTodo(todoSaveDTO);
    }

    @GetMapping("todos/all")
    public List<TodoInfoDTO> findAllTodos() {
        return todoService.findAllTodos();
    }

    @GetMapping("todos/find/completed")
    public List<TodoInfoDTO> findTodosByCompleted(@RequestParam("comp") boolean completed) {
        return todoService.findTodosByCompleted(completed);
    }

    @GetMapping("todos/find/title")
    public Iterable<TodoInfoDTO> findTodosByTitle(String title) {
        return todoService.findTodosByTitle(title);
    }

    @GetMapping("todos/find/title/contains")
    public Iterable<TodoInfoDTO> findTodosByTitleContains(String text) {
        return todoService.findTodosByTitleContains(text);
    }

    @GetMapping("todos/find/title/completed")
    public Iterable<TodoInfoDTO> findByCompletedAndTitle(@RequestParam(defaultValue = "true") boolean completed,
                                                         String title) {
    return todoService.findByCompletedAndTitle(completed, title);
    }

    @GetMapping("todos/find/title/completed/contains")
    public Iterable<TodoInfoDTO> findByCompletedAndTitleContains(@RequestParam(defaultValue = "true") boolean completed, String text) {
        return todoService.findByCompletedAndTitleContains(completed, text);
    }






}
