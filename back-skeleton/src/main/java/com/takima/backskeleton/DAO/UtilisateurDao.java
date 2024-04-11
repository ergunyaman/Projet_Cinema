package com.takima.backskeleton.DAO;


import com.takima.backskeleton.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {
    @Query("SELECT u FROM Utilisateur u WHERE u.Id_User = :utilisateurId")
    Utilisateur findByUtilisateurId(long utilisateurId);
}
