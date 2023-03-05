package com.example.dvdrent.services;

import com.example.dvdrent.entities.Director;
import com.example.dvdrent.entities.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    List<Genre> getAllGenres();

    Optional<Genre> getGenreById(long id);

    Genre createGenre (Genre genre);

    void updateGenre (Genre genre);

    void  deleteGenre (Genre genre);
}
