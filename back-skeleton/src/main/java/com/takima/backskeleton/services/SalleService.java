package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.SalleDao;
import com.takima.backskeleton.DTO.StudentDto;
import com.takima.backskeleton.DTO.StudentMapper;
import com.takima.backskeleton.models.Salle;
import com.takima.backskeleton.models.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SalleService {

    private final SalleDao salleDao;

    public List<Salle> findAll() {
        Iterable<Salle> it = salleDao.findAll();
        List <Salle> users = new ArrayList<>();
        it.forEach(users::add);
        return users ;
    }
    public Salle findById(Long id) {
        return salleDao.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id) {
        salleDao.deleteById(id);
    }

    public Salle save(Salle salle) {
        return salleDao.save(salle);
    }

    public Salle update(Salle salle){
        return salleDao.save(salle);
    }



    /*
    @Transactional
    public void addStudent(StudentDto studentDto) {
        Student student;
        try {
            student = StudentMapper.fromDto(studentDto, null);
        } catch (IOException e) {
            throw new RuntimeException("Error with Student image", e);
        }

        studentDao.save(student);
    }
    @Transactional
    public void updateStudent(StudentDto studentDto, Long id) {
        studentDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Student doesn't exist"));
        Student student;
        try {
            student = StudentMapper.fromDto(studentDto, id);
        } catch (IOException e) {
            throw new RuntimeException("Error with Student image", e);
        }
        studentDao.save(student);
    }

    */



}
