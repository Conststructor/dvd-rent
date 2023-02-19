package com.example.dvdrent.shell;

import com.example.dvdrent.services.DirectorService;
import com.example.dvdrent.services.GenreService;
import com.example.dvdrent.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.h2.tools.Console;
import org.springframework.shell.standard.ShellOption;

import java.sql.SQLException;
import java.util.Scanner;

@ShellComponent
public class AppEventsCommands {
    private final DirectorService directorService;
    private final GenreService genreService;
    private final MovieService movieService;

    @Autowired
    public AppEventsCommands(DirectorService directorService, GenreService genreService, MovieService movieService) {
        this.directorService = directorService;
        this.genreService = genreService;
        this.movieService = movieService;
    }

    /**
     * Метод startConsoleH2 запускает консоль
     */
    @ShellMethod(value = "Start console H2", key = {"c", "console"})
    public void startConsoleH2() {
        try {
            Console.main();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @ShellMethod(value = "Get All Directors", key = {"gad", "getalldirectors"})
    public void getAllDirectors() {
        System.out.println(directorService.getAllDirectors().toString());
    }

    @ShellMethod(value = "Get Director By Id", key = {"gdid", "getdirectorbyid"})
    public void getDirectorById(@ShellOption(defaultValue = "1") long id) {
//        Scanner input = new Scanner(System.in);
//        long id = input.nextLong();
        System.out.println(directorService.getDirectorById(id).toString());
    }

    @ShellMethod(value = "Get All Genres", key = {"gag", "getallgenres"})
    public void getAllGenres() {
        System.out.println(genreService.getAllGenres().toString());
    }

    @ShellMethod(value = "Get Genre By Id", key = {"ggbi", "getgenrebyid"})
    public void getGenreById() {
        Scanner input = new Scanner(System.in);
        long id = input.nextLong();
        System.out.println(genreService.getGenreById(id).toString());
    }

    @ShellMethod(value = "Get All Movies", key = {"gam", "getallmovies"})
    public void getAllMovies() {
        System.out.println(movieService.getAllMovies().toString());
    }

    @ShellMethod(value = "Get Movie By Id", key = {"gmbi", "getmoviebyid"})
    public void getMovieById() {
        Scanner input = new Scanner(System.in);
        long id = input.nextLong();
        System.out.println(movieService.getMovieById(id).toString());
    }
}
