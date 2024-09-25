package com.filmratings.filmratings.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Entity // Indique que c'est une entité JPA qui sera mappée à une table de la base de données
public class Film {

    @Id // Indique que cet attribut est la clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // La clé sera auto-générée par la base de données
    private Long id;
    @NotNull(message = "Le titre est obligatoire")
    @Size(min = 1, max = 100, message = "Le titre doit contenir entre 1 et 100 caractères")
    private String title;
    @Size(max = 255, message = "La description ne doit pas dépasser 255 caractères")

    private String description;
    @NotNull(message = "La note est obligatoire")
    @Min(value = 1, message = "La note doit être au moins 1")
    @Max(value = 10, message = "La note ne doit pas dépasser 10")
    private int rating;

    // Constructeur par défaut (obligatoire pour JPA)
    public Film() {}

    // Constructeur avec paramètres
    public Film(String title, String description, int rating) {
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
