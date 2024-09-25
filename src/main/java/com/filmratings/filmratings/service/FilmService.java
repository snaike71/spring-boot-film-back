package com.filmratings.filmratings.service;

import com.filmratings.filmratings.model.Film;
import com.filmratings.filmratings.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    // Récupérer tous les films
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    // Récupérer un film par ID
    public Optional<Film> getFilmById(Long id) {
        return filmRepository.findById(id);
    }

    // Ajouter ou mettre à jour un film
    public Film saveFilm(Film film) {
        return filmRepository.save(film);
    }

    // Supprimer un film par ID
    public void deleteFilmById(Long id) {
        filmRepository.deleteById(id);
    }
}
