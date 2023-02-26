package com.example.dvdrent.services;

import com.example.dvdrent.entities.Director;

import java.util.List;
import java.util.Optional;

public interface DirectorService {
    List<Director> getAllDirectors();

    Optional<Director> getDirectorById(long id);

    Director createDirector (Director director);

    void updateDirector (Director director);

    void  deleteDirector (Director director);
}
