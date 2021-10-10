package com.example.todorestservisapp.data.repository;

import com.example.todorestservisapp.data.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface IItemRepository extends CrudRepository<Item, Long> {

}
