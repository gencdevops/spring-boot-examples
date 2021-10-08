package com.example.exceptionhandling.controller;

import com.example.exceptionhandling.dto.Car;
import com.example.exceptionhandling.exception.EntityNotFoundException;
import com.example.exceptionhandling.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/car")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<Car> getCar(@RequestParam String name) {
        return ResponseEntity.ok(carService.getCar(name));
    }




}
