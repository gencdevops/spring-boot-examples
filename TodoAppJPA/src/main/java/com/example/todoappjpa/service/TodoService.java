package com.example.todoappjpa.service;

import com.example.todoappjpa.converter.TodoInfoConverter;
import com.example.todoappjpa.converter.TodoSaveConverter;
import com.example.todoappjpa.data.dal.TodoAppDAL;
import com.example.todoappjpa.dto.TodoInfoDTO;
import com.example.todoappjpa.dto.TodoSaveDTO;
import com.example.todoappjpa.mapper.ITodoInfoMapper;
import com.example.todoappjpa.mapper.ITodoSaveMapper;
import com.example.todoappjpa.util.DatabaseUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TodoService {
    private final TodoAppDAL todoAppDAL;
    private final ITodoInfoMapper todoInfoMapper;
    private final ITodoSaveMapper todoSaveMapper;

    public TodoService(TodoAppDAL todoAppDAL, ITodoInfoMapper todoInfoMapper, ITodoSaveMapper todoSaveMapper) {
        this.todoAppDAL = todoAppDAL;
        this.todoInfoMapper = todoInfoMapper;
        this.todoSaveMapper = todoSaveMapper;
    }

    private static <T, R> List<R> convertToList(Iterable<? extends T> iterable, boolean parallel,
                                                Function<? super T, ? extends R> function) {
        return StreamSupport.stream(iterable.spliterator(), parallel)
                .map(function)
                .collect(Collectors.toList());
    }



    private TodoInfoDTO saveCallback(TodoSaveDTO todoSaveDTO) {
        return todoInfoMapper.toTodoInfoDTO(todoAppDAL.saveTodo(todoSaveMapper.toTodo(todoSaveDTO)));
    }

    private List<TodoInfoDTO> findTodosByTitleCallback(String title) {
        return convertToList(todoAppDAL.findTodosByTitle(title), false, todoInfoMapper::toTodoInfoDTO);
    }


    private List<TodoInfoDTO> findAllTodosCallback() {
        return convertToList(todoAppDAL.findAllTodos(), true,
                todoInfoMapper::toTodoInfoDTO);
    }

    private List<TodoInfoDTO> findTodosByCompletedCallback(boolean completed) {
        return convertToList(todoAppDAL.findTodosByCompleted(completed), true,
                todoInfoMapper::toTodoInfoDTO);
    }

    private List<TodoInfoDTO> findTodosByTitleContainsCallback(String text) {
        return convertToList(todoAppDAL.findTodosByTitle(text), false,
                todoInfoMapper::toTodoInfoDTO);
    }


    private List<TodoInfoDTO> findByCompletedAndTitleCallback(boolean completed, String title) {
        return convertToList(todoAppDAL.findByCompletedAndTitle(completed, title), true,
                todoInfoMapper::toTodoInfoDTO);
    }

    private List<TodoInfoDTO> findByCompletedAndTitleContainsCallback(boolean completed, String text) {
        return convertToList(todoAppDAL.findByCompletedAndTitleContains(completed, text), true,
                todoInfoMapper::toTodoInfoDTO);
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

    public Iterable<TodoInfoDTO> findByCompletedAndTitle(boolean completed, String title) {
        return DatabaseUtil.doWorkForService(() -> findByCompletedAndTitleCallback(completed, title),
                "TodoService.findByCompletedAndTitle");
    }

    public Iterable<TodoInfoDTO> findByCompletedAndTitleContains(boolean completed, String text) {
        return DatabaseUtil.doWorkForService(() -> findByCompletedAndTitleContainsCallback(completed, text),
                "TodoService.findByCompletedAndTitleContains");
    }

}
