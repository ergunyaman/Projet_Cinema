package com.takima.backskeleton.DAO;
import com.takima.backskeleton.models.Salle;
import com.takima.backskeleton.models.Seance;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

public interface SeanceDao extends JpaRepository<Seance, Long> {


    @Query("SELECT s FROM Seance s WHERE s.Date_Heure BETWEEN :startDate AND :endDate")
    List<Seance> findByDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}