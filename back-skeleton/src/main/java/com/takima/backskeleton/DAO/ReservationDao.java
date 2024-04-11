package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationDao extends JpaRepository<Reservation, Long> {
    //@Query ("SELECT r FROM Reservation r INNER JOIN Utilisateur u ON r.utilisateur.Id_User = u.Id_User INNER JOIN Seance s ON r.Id_Seance = s.Id_Seance WHERE r.Id_Reservation= :reservationId ")
    //Reservation findByReservationId(long reservationId);

    //@Query ("SELECT r FROM Reservation r INNER JOIN Utilisateur u ON r.utilisateur.Id_User = u.Id_User INNER JOIN Seance s ON r.Id_Seance = s.Id_Seance WHERE s.Id_Seance = :seanceId")
    //List<Reservation> findBySeanceId(long seanceId);

    //@Query ("SELECT r FROM Reservation r INNER JOIN Utilisateur u ON r.utilisateur.Id_User = u.Id_User INNER JOIN Seance s ON r.Id_Seance = s.Id_Seance WHERE u.Id_User = :userId")
    //List<Reservation> findByUserId(long userId);

    @Query ("SELECT r FROM Reservation r INNER JOIN Utilisateur u ON r.utilisateur.Id_User = u.Id_User  WHERE r.Id_Reservation = :Id_Reservation")
    Optional<Reservation> findByReservationIdsmall(long Id_Reservation);

}
