package com.example.dvdrent.shell;

import com.example.dvdrent.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.h2.tools.Console;
import java.sql.SQLException;

@ShellComponent
public class AppEventsCommands {
    private final DirectorService directorService;

    @Autowired

    public AppEventsCommands(DirectorService directorService) {
        this.directorService = directorService;
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
    public void getAllAuthors() {
        System.out.println(directorService.getAllDirectors().toString());
    }
}
