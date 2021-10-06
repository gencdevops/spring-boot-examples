package com.example.todoappjpa.dto;

public class ItemSaveDTO {
    private long todoId;
    private String text;



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getTodoId() {
        return todoId;
    }

    public void setTodoId(long todoId) {
        this.todoId = todoId;
    }
}
