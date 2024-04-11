package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface RealisateurDao extends JpaRepository<Realisateur, Long> {

    // Trouver un réalisateur par ID
    Optional<Realisateur> findById(Long id);

    // Trouver des réalisateurs par nationalité
    List<Realisateur> findByNationalite(String nationalite);

    // Trouver des réalisateurs par nom
    List<Realisateur> findByNom(String nom);

    // Trouver des réalisateurs nés entre deux dates spécifiques
    @Query("SELECT r FROM Realisateur r WHERE r.date BETWEEN :startDate AND :endDate")
    List<Realisateur> findByDateBetween(Date startDate, Date endDate);

    // Mettre à jour les informations d'un réalisateur
    Realisateur save(Realisateur realisateur);

}
