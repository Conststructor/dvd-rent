package com.example.dvdrent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }

    // в pom файле поменять версию <java.version>1.8</java.version> на 11
}
