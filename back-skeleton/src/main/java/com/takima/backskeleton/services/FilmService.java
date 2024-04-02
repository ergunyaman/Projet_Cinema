package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.FilmDao;
import com.takima.backskeleton.models.Film;
import com.takima.backskeleton.models.Realisateur;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilmService {
    private final FilmDao filmDao;

    // Trouver tous les films
    public List<Film> findAll() {
        return filmDao.findAll();
    }
    public Film findById(Long id) {
        Optional<Film> optionalFilm = filmDao.findById(id);
        return optionalFilm.orElse(null);
    }


    // Trouver des films par titre
    public List<Film> findByTitre(String titre) {
        return filmDao.findByTitreContainingIgnoreCase(titre);
    }

    // Trouver des films par genre
    public List<Film> findByGenre(String genre) {
        return filmDao.findByGenre(genre);
    }

    // Trouver des films par l'ID du réalisateur
    public List<Film> findByRealisateurId(Long realisateurId) {
        return filmDao.findByRealisateurId(realisateurId);
    }

    // Ajouter un film
    public Film save(Film film) {
        return filmDao.save(film);
    }

    // Mettre à jour un film
    public Film update(Film film) {
        return filmDao.save(film); // save fonctionne pour les mises à jour si l'entité a déjà un ID
    }

    // Supprimer un film par ID
    public void deleteById(Long id) {
        filmDao.deleteById(id);
    }

    // Trouver des films par une plage de dates de sortie
    public List<Film> findByDateBetween(Date startDate, Date endDate) {
        return filmDao.findByDateBetween(startDate, endDate);
    }
}
