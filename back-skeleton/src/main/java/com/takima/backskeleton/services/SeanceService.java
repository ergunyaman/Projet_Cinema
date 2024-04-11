package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.SeanceDao;

import com.takima.backskeleton.models.Seance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SeanceService {

    private final SeanceDao seanceDao;

    public List<Seance> findAll() {
       return seanceDao.findAll();
    }

    public Seance getById(Long id) {
        return seanceDao.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id) {
        seanceDao.deleteById(id);
    }

    public Seance findById(Long id) {
        return seanceDao.findById(id).orElseThrow();
    }

    public Seance save(Seance seance){
        return seanceDao.save(seance);
    }

    public Seance update(Seance seance){
        return seanceDao.save(seance);
    }
    public List<Seance> findByDateBetween(Date startDate, Date endDate) {
        return seanceDao.findByDateBetween(startDate, endDate);
    }
}
