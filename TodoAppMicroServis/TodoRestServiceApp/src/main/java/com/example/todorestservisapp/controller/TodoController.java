package com.example.todorestservisapp.controller;


import com.example.todorestservisapp.dto.TodoInfoDTO;
import com.example.todorestservisapp.dto.TodoSaveDTO;
import com.example.todorestservisapp.service.TodoAppService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo")
public class TodoController {
    private final TodoAppService todoAppService;

    public TodoController(TodoAppService todoAppService) {
        this.todoAppService = todoAppService;
    }

    @PostMapping("save")
    public TodoInfoDTO saveTodo(@RequestBody TodoSaveDTO todoSaveDTO) {
        return todoAppService.saveTodo(todoSaveDTO);
    }

    @GetMapping("todos/all")
    public List<TodoInfoDTO> findAllTodos() {
        return todoAppService.findAllTodos();
    }

    @GetMapping("todos/find/completed")
    public List<TodoInfoDTO> findTodosByCompleted(@RequestParam("comp") boolean completed) {
        return todoAppService.findTodosByCompleted(completed);
    }

    @GetMapping("todos/find/title")
    public Iterable<TodoInfoDTO> findTodosByTitle(String title) {
        return todoAppService.findTodosByTitle(title);
    }

    @GetMapping("todos/find/title/contains")
    public Iterable<TodoInfoDTO> findTodosByTitleContains(String text) {
        return todoAppService.findTodosByTitleContains(text);
    }

    @GetMapping("todos/find/title/completed")
    public Iterable<TodoInfoDTO> findTodosByCompletedAndTitle(@RequestParam(defaultValue = "true") boolean completed,
                                                              String title) {
        return todoAppService.findTodosByCompletedAndTitle(completed, title);
    }

    @GetMapping("todos/find/title/completed/contains")
    public Iterable<TodoInfoDTO> findTodosByCompletedAndTitleContains(@RequestParam(defaultValue = "true") boolean completed, String text) {
        return todoAppService.findTodosByCompletedAndTitleContains(completed, text);
    }

    @GetMapping("todos/find/month")
    public List<TodoInfoDTO> findByMonth(int month) {
        return todoAppService.findTodosByMonth(month);
    }


}
