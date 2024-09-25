package com.filmratings.filmratings.controller;

import com.filmratings.filmratings.model.Film;
import com.filmratings.filmratings.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/films") // La route de base pour accéder aux films
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    // Récupérer tous les films
    @GetMapping
    public List<Film> getAllFilms() {
        return filmService.getAllFilms();
    }

    // Récupérer un film par ID
    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable Long id) {
        Optional<Film> film = filmService.getFilmById(id);
        return film.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Ajouter un film
    @PostMapping
    public ResponseEntity<?> createFilm(@Valid @RequestBody Film film) {
        Film savedFilm = filmService.saveFilm(film);
        return new ResponseEntity<>(savedFilm,HttpStatus.CREATED);
    }

    // Mettre à jour un film
    @PutMapping("/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable Long id, @RequestBody Film updatedFilm) {
        Optional<Film> film = filmService.getFilmById(id);
        if (film.isPresent()) {
            Film existingFilm = film.get();
            existingFilm.setTitle(updatedFilm.getTitle());
            existingFilm.setDescription(updatedFilm.getDescription());
            existingFilm.setRating(updatedFilm.getRating());
            return ResponseEntity.ok(filmService.saveFilm(existingFilm));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un film
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable Long id) {
        if (filmService.getFilmById(id).isPresent()) {
            filmService.deleteFilmById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
