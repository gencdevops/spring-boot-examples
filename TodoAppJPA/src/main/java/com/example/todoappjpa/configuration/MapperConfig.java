package com.example.todoappjpa.configuration;

import com.example.todoappjpa.mapper.ITodoInfoMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ITodoInfoMapper getTodoInfoMapper() {
      return Mappers.getMapper(ITodoInfoMapper.class);
    }

}
