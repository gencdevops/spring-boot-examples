package com.example.exceptionhandling.dto;

public class Car {
    private String name;
    private String brand;

    public Car(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    public Car() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
