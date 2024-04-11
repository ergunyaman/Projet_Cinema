package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.ReservationDao;
import com.takima.backskeleton.DTO.ReservationDto;
import com.takima.backskeleton.DTO.ReservationMapper;
import com.takima.backskeleton.DTO.StudentDto;
import com.takima.backskeleton.DTO.StudentMapper;
import com.takima.backskeleton.models.Reservation;
import com.takima.backskeleton.models.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.rmi.server.RemoteRef;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationDao reservationDao;

    public List<Reservation> findAll(){
        Iterable<Reservation> it = reservationDao.findAll();
        List <Reservation> reserves = new ArrayList<>();
        it.forEach(reserves::add);
        return reserves ;
    }
    public Reservation getById(Long Id_Reservation) {return reservationDao.findByReservationIdsmall(Id_Reservation).orElseThrow(); }
    // orelsethrow();

    @Transactional
    public void deleteById(Long Id_Reservation){reservationDao.deleteById(Id_Reservation);}

    @Transactional
    public void addReservation(ReservationDto reservationDto) {
        Reservation reservation;
        try {
            reservation = ReservationMapper.fromDto(reservationDto, null);
        } catch (IOException e) {
            throw new RuntimeException("Error with Student image", e);
        }

        reservationDao.save(reservation);
    }

    @Transactional
    public void updateReservation(ReservationDto reservationDto, Long id) {
        reservationDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Reservation doesn't exist"));
        Reservation reservation;
        try {
            reservation = ReservationMapper.fromDto(reservationDto, id);
        } catch (IOException e) {
            throw new RuntimeException("Error with reservation image", e);
        }
        reservationDao.save(reservation);
    }

    //public List<Reservation> searchByUserId(Long UserId) {
    //    return reservationDao.findByUserId(UserId);
    //}
}
