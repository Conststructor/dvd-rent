package com.example.dvdrent.controller;

import com.example.dvdrent.entities.Movie;
import com.example.dvdrent.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MovieController {
    private final MovieRepository movieRepository;
@Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @GetMapping("/movie")
    public String getMovieById(@RequestParam("id") long id, Model model){
        Movie movie = movieRepository.findById(id).get();
        model.addAttribute("movie",movie);
        return "movie";
    }

    @GetMapping("/movies")
    public String moviesPage(Model model){
        List<Movie> moviesList = (List<Movie>) movieRepository.findAll();
        model.addAttribute("moviesList", moviesList);
        return "movies";
    }

}
