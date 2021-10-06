package com.example.todoappjpa.data.dal;


import com.example.todoappjpa.data.entity.Item;
import com.example.todoappjpa.data.entity.Todo;
import com.example.todoappjpa.data.repository.IItemRepository;
import com.example.todoappjpa.data.repository.ITodoRepository;
import com.example.todoappjpa.util.DatabaseUtil;
import org.springframework.stereotype.Component;

@Component
public class TodoAppHelper {

    private final ITodoRepository todoRepository;
    private final IItemRepository itemRepository;

    public TodoAppHelper(ITodoRepository todoRepository, IItemRepository iItemRepository) {
        this.todoRepository = todoRepository;
        this.itemRepository = iItemRepository;
    }

    public Todo saveTodo(Todo todo) {
        return DatabaseUtil.doWorkForRepository(() -> todoRepository.save(todo),
                "TodoAppDAL.saveTodo");
    }

    public Iterable<Todo> findAllTodos() {
        return DatabaseUtil.doWorkForRepository(todoRepository::findAll, "TodoAppDAL.findAll");
    }

    public Iterable<Todo> findTodosByCompleted(boolean completed) {
        return DatabaseUtil.doWorkForRepository(() -> todoRepository.findByCompleted(completed),
                "TodoAppDAL.findTodosByCompleted");
    }

    public Iterable<Todo> findTodosByTitle(String title) {
        return DatabaseUtil.doWorkForRepository(() -> todoRepository.findByTitle(title),
                "TodoAppDAL.findTodosByTitle");
    }

    public Iterable<Todo> findTodosByTitleContains(String text) {
        return DatabaseUtil.doWorkForRepository(() -> todoRepository.findByTitleContains(text),
                "TodoAppDAL.findTodosByTitleContains");
    }

    public Iterable<Todo> findTodosByCompletedAndTitle(boolean completed, String title) {
        return DatabaseUtil.doWorkForRepository(() -> todoRepository.findByCompletedAndTitle(completed, title),
                "TodoAppDAL.findByCompletedAbdTitle");
    }

    public Iterable<Todo> findTodosByCompletedAndTitleContains(boolean completed, String text) {
        return DatabaseUtil.doWorkForRepository(() -> todoRepository.findByCompletedAndTitleContains(completed, text),
                "TodoAppDAL.findByCompletedAndTitleContains");
    }

    public Iterable<Todo> findTodoByMonth(int month) {
    return DatabaseUtil.doWorkForRepository(() -> todoRepository.findByMonth(month),
            "TodoAppDAL.findTodoByMonth");
    }

    public Item saveItem(Item item) {
        return DatabaseUtil.doWorkForRepository(() -> itemRepository.save(item),
                "TodoAppDAL.saveItem");
    }

}

