package com.example.todorestservisapp.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ItemInfoDTO {
    private String text;
    private LocalDateTime insertDateTime = LocalDateTime.now();
    private LocalDateTime lastUpdate;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    public LocalDateTime getInsertDateTime() {
        return insertDateTime;
    }

    public void setInsertDateTime(LocalDateTime insertDateTime) {
        this.insertDateTime = insertDateTime;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
