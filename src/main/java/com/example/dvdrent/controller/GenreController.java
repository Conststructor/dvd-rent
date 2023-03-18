package com.example.dvdrent.controller;

import com.example.dvdrent.entities.Genre;
import com.example.dvdrent.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GenreController {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping("/genre")
    public String getGenreById (@RequestParam("id") long id, Model model){
        Genre genre = genreRepository.findById(id).get();
        model.addAttribute("genre",genre);
        return "genre";
    }

    @GetMapping("/genres")
    public String genrePage (Model model){
        List<Genre> genreList = (List<Genre>) genreRepository.findAll();
        model.addAttribute("genreList", genreList);
        return "genres";
    }
}
