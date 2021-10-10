package com.example.todorestservisapp.mapper;

import com.example.todorestservisapp.data.entity.Item;
import com.example.todorestservisapp.dto.ItemSaveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(implementationName = "ItemSaveMapperImpl", componentModel = "spring")
public interface IItemSaveMapper {
    @Mappings({
            @Mapping(source = "todoId", target = "todoId")
    })
    Item toItem(ItemSaveDTO itemSaveDTO);


    @Mappings({
            @Mapping(source = "todoId", target = "todoId")
    })
    ItemSaveDTO toItemSaveDTO(Item item);
}
