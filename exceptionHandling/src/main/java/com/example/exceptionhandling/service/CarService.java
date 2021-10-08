package com.example.exceptionhandling.service;

import com.example.exceptionhandling.dto.Car;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private static List<Car> carList = new ArrayList<>();

    @PostConstruct
    private void initCar() {
        carList.add(new Car("3.20", "BMW"));
        carList.add(new Car("a4", "Audi"));
        carList.add(new Car("101", "Murat"));
        carList.add(new Car("SLX", "Şahin"));
    }

    public Car getCar(String name) {
    }
}
