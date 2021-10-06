package com.example.todoappjpa.mapper;


import com.example.todoappjpa.data.entity.Item;
import com.example.todoappjpa.dto.ItemInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(implementationName = "ItemInfoMapperImpl", componentModel = "spring")
public interface IItemInfoMapper {

    Item toItem(ItemInfoDTO itemInfoDTO);

    ItemInfoDTO toItemInfoDTO(Item item);
}
