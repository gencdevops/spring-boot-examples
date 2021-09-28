package com.example.movieapi.service;

import com.example.movieapi.converter.DirectorConverter;
import com.example.movieapi.data.dataaccesslayer.MovieAppDAL;
import com.example.movieapi.dto.DirectorDTO;
import org.csystem.util.data.DatabaseUtil;
import org.csystem.util.data.repository.RepositoryException;
import org.csystem.util.data.service.DataServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class DirectoryService {
    private final MovieAppDAL movieAppDAL;
    private final DirectorConverter directorConverter;

    private DirectorDTO saveDirectorCallback(DirectorDTO directorDTO) {
        movieAppDAL.saveDirector(directorConverter.toDirector(directorDTO));
        return directorDTO;
    }

    private List<DirectorDTO> findAllDirectorsCallback() {
        return StreamSupport.stream(movieAppDAL.findAllDirectors().spliterator(), false)
                .map(directorConverter::toDirectorDTO)
                .collect(Collectors.toList());
    }

    public DirectoryService(MovieAppDAL movieAppDAL, DirectorConverter directorConverter) {
        this.movieAppDAL = movieAppDAL;
        this.directorConverter = directorConverter;
    }

    public DirectorDTO saveDirector(DirectorDTO directorDTO) {
        return DatabaseUtil.doWorkForService(() -> saveDirectorCallback(directorDTO),
                "MovieAppService.saveDirector");
    }

    public List<DirectorDTO> findAllDirectors() {
        return DatabaseUtil.doWorkForService(this::findAllDirectorsCallback,
                "MovieAppService.findAllDirectors");
    }
}
