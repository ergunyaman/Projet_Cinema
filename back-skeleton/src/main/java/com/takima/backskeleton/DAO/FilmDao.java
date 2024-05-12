package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface FilmDao extends JpaRepository<Film, Long> {
    // Trouver tous les films, méthode déjà fournie par JpaRepository
    // Trouver des films par titre (ignorant la casse et partiellement)
    List<Film> findByTitreContainingIgnoreCase(String titre);

    // Trouver des films par genre
    List<Film> findByGenre(String genre);

    // Trouver des films par l'ID du réalisateur
    @Query("SELECT f FROM Film f WHERE f.id_realisateur = :realisateurId")
    List<Film> findByRealisateurId(@Param("realisateurId") Long realisateurId);

    // Ajouter et mettre à jour des films, méthodes déjà fournies par JpaRepository
    // Supprimer un film par ID, méthode déjà fournie par JpaRepository

    // Trouver des films par une plage de dates de sortie
    @Query("SELECT f FROM Film f WHERE f.date BETWEEN :startDate AND :endDate")
    List<Film> findByDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
