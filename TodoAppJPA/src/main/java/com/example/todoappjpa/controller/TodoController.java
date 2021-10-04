package com.example.todoappjpa.controller;


import com.example.todoappjpa.dto.TodoInfoDTO;
import com.example.todoappjpa.dto.TodoSaveDTO;
import com.example.todoappjpa.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
