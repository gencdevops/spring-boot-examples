package com.example.movieapi.controller;

import com.example.movieapi.dto.DirectorDTO;
import com.example.movieapi.service.DirectoryService;
import org.csystem.util.data.service.DataServiceException;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Scope("prototype")
@RequestMapping("api/director")
public class DirectorController {
    private final DirectoryService directoryService;


    public DirectorController(DirectoryService directoryService) {
        this.directoryService = directoryService;
    }

    @GetMapping("/all")
    public List<DirectorDTO> findAllDirector() {
        try{
            return directoryService.findAllDirectors();
        }catch (DataServiceException ex) {
            return new ArrayList<>();
        }
    }

}
