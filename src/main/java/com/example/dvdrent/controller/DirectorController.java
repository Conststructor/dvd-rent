package com.example.dvdrent.controller;

import com.example.dvdrent.entities.Director;
import com.example.dvdrent.repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DirectorController {
    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorController(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @GetMapping("/")
    public String welcomePage() {
        return "welcome";
    }

    @GetMapping("/index")
    public String indexPage(){
        return "index";
    }

    @GetMapping("/director")
    public String getDirectorById(@RequestParam("id") long id, Model model) {
        Director director = directorRepository.findById(id).get();
        model.addAttribute("director", director);
        return "director";
    }

    @GetMapping("/directors")
    public String directorsPage(Model model) {
        List<Director> directorsList = (List<Director>) directorRepository.findAll();
        model.addAttribute("directorsList", directorsList);
        return "directors";
    }


}
