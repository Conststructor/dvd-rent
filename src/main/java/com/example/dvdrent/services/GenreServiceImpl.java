package com.example.dvdrent.services;

import com.example.dvdrent.entities.Genre;
import com.example.dvdrent.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Optional<Genre> getGenreById(long id) {
        return genreRepository.findById(id);
    }
}
