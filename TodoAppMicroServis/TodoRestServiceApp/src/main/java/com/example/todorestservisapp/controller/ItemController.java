package com.example.todorestservisapp.controller;

import com.example.todorestservisapp.dto.ItemSaveDTO;
import com.example.todorestservisapp.service.TodoAppService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/todo/item")
public class ItemController {
    private final TodoAppService todoAppService;

    public ItemController(TodoAppService todoAppService) {
        this.todoAppService = todoAppService;
    }

    @PostMapping("save")
    public ItemSaveDTO saveItem(@RequestBody ItemSaveDTO itemSaveDTO) {
        return todoAppService.saveItem(itemSaveDTO);
    }
}
