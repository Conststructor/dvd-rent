package com.example.dvdrent.services;

import com.example.dvdrent.entities.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> getAllMovies();

    Optional<Movie> getMovieById(long id);

    Movie createMovie (Movie movie);

    void updateMovie(Movie movie);

    void deleteMovie (Movie movie);
}
