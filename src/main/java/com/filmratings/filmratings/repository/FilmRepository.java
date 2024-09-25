package com.filmratings.filmratings.repository;

import com.filmratings.filmratings.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Indique que cette interface est un composant Spring qui gère les accès à la base de données
public interface FilmRepository extends JpaRepository<Film, Long> {
    // Pas besoin d'ajouter des méthodes, JpaRepository contient déjà les méthodes basiques CRUD
}
