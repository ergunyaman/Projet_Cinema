package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Major;
import com.takima.backskeleton.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MajorDao extends JpaRepository<Major, Long> {
    @Query("SELECT m.students FROM Major m WHERE m.id= :majorId")
    List<Student> getAllStudentsFromMajor(Long majorId);
}
