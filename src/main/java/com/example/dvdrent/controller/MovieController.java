package com.example.dvdrent.controller;

import com.example.dvdrent.entities.Director;
import com.example.dvdrent.entities.Genre;
import com.example.dvdrent.entities.Movie;
import com.example.dvdrent.repositories.MovieRepository;
import org.h2.engine.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movie")
    public String getMovieById(@RequestParam("id") long id, Model model) {
        Movie movie = movieRepository.findById(id).get();
        model.addAttribute("movie", movie);
        return "movie";
    }

    @GetMapping("/movies")
    public String moviesPage(Model model) {
        List<Movie> moviesList = (List<Movie>) movieRepository.findAll();
        model.addAttribute("moviesList", moviesList);
        return "movies";
    }

    @PostMapping("/create")
    public String createMovie(@RequestParam String name, @RequestParam Director directorId, @RequestParam Genre genreId, Model model) {
        Movie movie = movieRepository.save(new Movie(name, directorId, genreId));
        model.addAttribute("movie", movie);
        return "movie";
    }

    @PutMapping("/update")
    public String updateMovie(@RequestParam long id, @RequestParam String name, @RequestParam Director directorId, @RequestParam Genre genreId, Model model) {
        Movie movie = movieRepository.save(new Movie(id, name, directorId, genreId));
        model.addAttribute("movie", movie);
        return "movie";
    }

    @DeleteMapping("/delete")
    public String deleteMovie(@RequestParam long id, Model model) {
        movieRepository.delete(new Movie(id));
        return "welcome";
    }
}
