package com.example.dvdrent.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id")
    private Director directorId;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genreId;

    public Movie() {
    }

    public Movie(long id) {
        this.id = id;
    }

    public Movie(String name) {
        this.name = name;
    }

    public Movie(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Movie(String name, Director directorId, Genre genreId) {
        this.name = name;
        this.directorId = directorId;
        this.genreId = genreId;
    }

    public Movie(long id, String name, Director directorId, Genre genreId) {
        this.id = id;
        this.name = name;
        this.directorId = directorId;
        this.genreId = genreId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Director getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Director directorId) {
        this.directorId = directorId;
    }

    public Genre getGenreId() {
        return genreId;
    }

    public void setGenreId(Genre genreId) {
        this.genreId = genreId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && Objects.equals(name, movie.name) && Objects.equals(directorId, movie.directorId) && Objects.equals(genreId, movie.genreId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, directorId, genreId);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", director_id=" + directorId +
                ", genre_id=" + genreId +
                '}';
    }
}
