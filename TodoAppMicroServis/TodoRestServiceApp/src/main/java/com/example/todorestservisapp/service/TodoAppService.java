package com.example.todorestservisapp.service;

import com.example.todorestservisapp.data.dal.TodoAppHelper;
import com.example.todorestservisapp.dto.ItemSaveDTO;
import com.example.todorestservisapp.dto.TodoInfoDTO;
import com.example.todorestservisapp.dto.TodoSaveDTO;
import com.example.todorestservisapp.mapper.IItemInfoMapper;
import com.example.todorestservisapp.mapper.IItemSaveMapper;
import com.example.todorestservisapp.mapper.ITodoInfoMapper;
import com.example.todorestservisapp.mapper.ITodoSaveMapper;
import com.example.todorestservisapp.util.DatabaseUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TodoAppService {
    private final TodoAppHelper todoAppHelper;
    private final ITodoInfoMapper todoInfoMapper;
    private final ITodoSaveMapper todoSaveMapper;
    private final IItemInfoMapper itemInfoMapper;
    private final IItemSaveMapper itemSaveMapper;

    public TodoAppService(TodoAppHelper todoAppHelper, ITodoInfoMapper todoInfoMapper,
                          ITodoSaveMapper todoSaveMapper,
                          IItemInfoMapper itemInfoMapper,
                          IItemSaveMapper itemSaveMapper) {
        this.todoAppHelper = todoAppHelper;
        this.todoInfoMapper = todoInfoMapper;
        this.todoSaveMapper = todoSaveMapper;
        this.itemInfoMapper = itemInfoMapper;
        this.itemSaveMapper = itemSaveMapper;
    }

    private static <T, R> List<R> convertToList(Iterable<? extends T> iterable, boolean parallel,
                                                Function<? super T, ? extends R> function) {
        return StreamSupport.stream(iterable.spliterator(), parallel)
                .map(function)
                .collect(Collectors.toList());
    }



    private TodoInfoDTO saveTodoCallback(TodoSaveDTO todoSaveDTO) {
        return todoInfoMapper.toTodoInfoDTO(todoAppHelper.saveTodo(todoSaveMapper.toTodo(todoSaveDTO)));
    }

    private List<TodoInfoDTO> findTodosByTitleCallback(String title) {
        return convertToList(todoAppHelper.findTodosByTitle(title), false, todoInfoMapper::toTodoInfoDTO);
    }


    private List<TodoInfoDTO> findAllTodosCallback() {
        return convertToList(todoAppHelper.findAllTodos(), true,
                todoInfoMapper::toTodoInfoDTO);
    }

    private List<TodoInfoDTO> findTodosByCompletedCallback(boolean completed) {
        return convertToList(todoAppHelper.findTodosByCompleted(completed), true,
                todoInfoMapper::toTodoInfoDTO);
    }

    private List<TodoInfoDTO> findTodoByTitleContainsCallback(String text) {
        return convertToList(todoAppHelper.findTodosByTitle(text), false,
                todoInfoMapper::toTodoInfoDTO);
    }


    private List<TodoInfoDTO> findTodosByCompletedAndTitleCallback(boolean completed, String title) {
        return convertToList(todoAppHelper.findTodosByCompletedAndTitle(completed, title), true,
                todoInfoMapper::toTodoInfoDTO);
    }

    private List<TodoInfoDTO> findTodosByCompletedAndTitleContainsCallback(boolean completed, String text) {
        return convertToList(todoAppHelper.findTodosByCompletedAndTitleContains(completed, text), true,
                todoInfoMapper::toTodoInfoDTO);
    }

    private List<TodoInfoDTO> findTodoByMonthCallback(int month) {
        return convertToList(todoAppHelper.findTodoByMonth(month), false, todoInfoMapper::toTodoInfoDTO);
    }


    private ItemSaveDTO  saveItemCallback(ItemSaveDTO itemSaveDTO) {

        return itemSaveMapper.toItemSaveDTO(todoAppHelper.saveItem(itemSaveMapper.toItem(itemSaveDTO)));
    }


    public TodoInfoDTO saveTodo(TodoSaveDTO todoSaveDTO) {
        return DatabaseUtil.doWorkForService(() -> saveTodoCallback(todoSaveDTO),
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
        return DatabaseUtil.doWorkForService(() -> findTodoByTitleContainsCallback(text),
                "TodoService.findTodosByTitleContains");
    }

    public Iterable<TodoInfoDTO> findTodosByCompletedAndTitle(boolean completed, String title) {
        return DatabaseUtil.doWorkForService(() -> findTodosByCompletedAndTitleCallback(completed, title),
                "TodoService.findByCompletedAndTitle");
    }

    public Iterable<TodoInfoDTO> findTodosByCompletedAndTitleContains(boolean completed, String text) {
        return DatabaseUtil.doWorkForService(() -> findTodosByCompletedAndTitleContainsCallback(completed, text),
                "TodoService.findByCompletedAndTitleContains");
    }

    public List<TodoInfoDTO> findTodosByMonth(int month) {
    return DatabaseUtil.doWorkForService(() -> findTodoByMonthCallback(month),
            "TodoService.findTodosByMonth");
    }

    public ItemSaveDTO saveItem(ItemSaveDTO itemSaveDTO) {
        return DatabaseUtil.doWorkForService(() -> saveItemCallback(itemSaveDTO),
                "TodoService.saveItem");
    }

}
