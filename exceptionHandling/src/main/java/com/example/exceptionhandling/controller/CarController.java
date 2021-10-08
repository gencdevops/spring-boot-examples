package com.example.exceptionhandling.controller;

import com.example.exceptionhandling.dto.Car;
import com.example.exceptionhandling.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public Car getCar(String name) {
        return carService.getCar(name);
    }
}
