package com.example.todoappjpa.data.repository;

import com.example.todoappjpa.data.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface IItemRepository extends CrudRepository<Item, Long> {

}
