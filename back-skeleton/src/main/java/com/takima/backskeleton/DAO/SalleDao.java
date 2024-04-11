package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SalleDao extends JpaRepository<Salle, Long> {
}
