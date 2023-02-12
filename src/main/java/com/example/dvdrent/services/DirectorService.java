package com.example.dvdrent.services;

import com.example.dvdrent.entities.Director;

import java.util.List;
import java.util.Optional;

public interface DirectorService {
    List<Director> getAllDirectors();

    Optional<Director> getDirectorById(long id);
}
