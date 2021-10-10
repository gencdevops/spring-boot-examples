package com.example.todorestservisapp.mapper;


import com.example.todorestservisapp.data.entity.Item;
import com.example.todorestservisapp.dto.ItemInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(implementationName = "ItemInfoMapperImpl", componentModel = "spring")
public interface IItemInfoMapper {

    Item toItem(ItemInfoDTO itemInfoDTO);

    ItemInfoDTO toItemInfoDTO(Item item);
}
