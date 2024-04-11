package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.RealisateurDao;
import com.takima.backskeleton.DAO.FilmDao;
import com.takima.backskeleton.models.Realisateur;
import com.takima.backskeleton.models.Film;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RealisateurService {
    private final RealisateurDao realisateurDao;
    private final FilmDao filmDao; // Assurez-vous d'injecter également le FilmDao

    // Trouver tous les réalisateurs
    public List<Realisateur> findAll() {
        return realisateurDao.findAll();
    }

    // Trouver un réalisateur par ID
    public Optional<Realisateur> findById(Long id) {
        return realisateurDao.findById(id);
    }

    // Trouver des réalisateurs par nationalité
    public List<Realisateur> findByNationalite(String nationalite) {
        return realisateurDao.findByNationalite(nationalite);
    }

    // Trouver des réalisateurs par nom
    public List<Realisateur> findByNom(String nom) {
        return realisateurDao.findByNom(nom);
    }

    // Trouver des réalisateurs nés entre deux dates spécifiques
    public List<Realisateur> findByDateBetween(Date startDate, Date endDate) {
        return realisateurDao.findByDateBetween(startDate, endDate);
    }

    // Ajouter un réalisateur
    public Realisateur addRealisateur(Realisateur realisateur) {
        return realisateurDao.save(realisateur);
    }

    // Supprimer un réalisateur par ID
    public void deleteRealisateur(Long id) {
        realisateurDao.deleteById(id);
    }

    // Mettre à jour les informations d'un réalisateur
    public Realisateur updateRealisateur(Realisateur realisateur) {
        return realisateurDao.save(realisateur); // Utilise save pour la mise à jour si l'ID est présent
    }

}
