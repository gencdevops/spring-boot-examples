package com.example.movieapi.converter;

import com.example.movieapi.data.entity.Director;
import com.example.movieapi.dto.DirectorDTO;
import org.springframework.stereotype.Component;

@Component
public class DirectorConverter {
   public DirectorDTO toDirectorDTO(Director director) {
        DirectorDTO directorDTO = new DirectorDTO();
        directorDTO.setName(director.getName());
        directorDTO.setBirthDate(director.getBirthDate());
        return directorDTO;
    }
    public Director toDirector(DirectorDTO directorDTO) {
        Director director = new Director();
        director.setName(directorDTO.getName());
        director.setBirthDate(directorDTO.getBirthDate());
        return director;
    }
}
