package com.example.dvdrent.shell;

import com.example.dvdrent.entities.Director;
import com.example.dvdrent.entities.Genre;
import com.example.dvdrent.entities.Movie;
import com.example.dvdrent.services.DirectorService;
import com.example.dvdrent.services.GenreService;
import com.example.dvdrent.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.h2.tools.Console;
import org.springframework.shell.standard.ShellOption;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.OneToMany;
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

    //Create
    @ShellMethod(value = "Create new director", key = {"cd","createdirector"})
    public String createDirector(@ShellOption(defaultValue = "John Doe") String fullname){
        return directorService.createDirector(new Director(fullname)).toString();
    }

    @ShellMethod(value = "Create new genre", key = {"cg","creategenre"})
    public String createGenre(@ShellOption(defaultValue = "Create new genre") String name){
        return genreService.createGenre(new Genre(name)).toString();
    }

    @ShellMethod(value = "Create newe movie", key = {"cm", "createmovie"})
    public  String createMovie(@ShellOption(defaultValue = "Create new movie") String name){
        return movieService.createMovie(new Movie(name)).toString();
    }
    //Update
    @ShellMethod(value = "Update director", key ={"ud","updatedirector"})
    public void updateDirector(@ShellOption(defaultValue = "1") long id, @ShellOption(defaultValue = "incognito") String fullname){
        directorService.updateDirector(new Director(id,fullname));
    }

    @ShellMethod(value = "Update genre",key = {"ug", "updategenre"})
    public void updateGenre(@ShellOption(defaultValue = "1") long id, @ShellOption(defaultValue = "new genre") String name){
        genreService.updateGenre(new Genre(id,name));
    }

    @ShellMethod(value = "update movie", key = {"um", "updatemovie"})
    public void updateMovie(@ShellOption(defaultValue = "1") long id, @ShellOption(defaultValue = "new movie")String name){
        movieService.updateMovie(new Movie(id, name));
    }

    //Delete
    @ShellMethod(value = "Delete director", key = {"dd","deletedirector"})
    public void deleteDirector(@ShellOption(defaultValue = "1") long id, @ShellOption(defaultValue = "John Bunyan") String fullname){
        directorService.deleteDirector(new Director(id, fullname));
    }

    @ShellMethod(value = "Delete genre", key = {"dg","deletegenre"})
    public void deleteGenre(@ShellOption(defaultValue = "1") long id, @ShellOption(defaultValue = "History") String name){
        genreService.deleteGenre(new Genre(id, name));
    }

    @ShellMethod(value = "Delete movie", key = {"dm", "deletemovie"})
    public void deleteMovie(@ShellOption(defaultValue = "1") long id, @ShellOption(defaultValue = "The Pilgrim’s Progress") String name){
        movieService.deleteMovie(new Movie(id, name));
    }
}
