package com.example.dvdrent.services;

import com.example.dvdrent.entities.Director;
import com.example.dvdrent.entities.Genre;
import com.example.dvdrent.repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorServiceImpl implements DirectorService {
    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorServiceImpl(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Director> getDirectorById(long id) {
        return directorRepository.findById(id);
    }

    @Override
    @Transactional
    public Director createDirector(Director director) {
        return directorRepository.save(director);
    }

    @Override
    @Transactional
    public void updateDirector(Director director) {
        directorRepository.save(director);
    }

    @Override
    @Transactional
    public void deleteDirector(Director director) {
        directorRepository.delete(director);
    }

}
