package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.ReservationDto;
import com.takima.backskeleton.models.Reservation;
import com.takima.backskeleton.models.Utilisateur;
import com.takima.backskeleton.services.ReservationService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RequestMapping("reservations")
@RestController
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;
    @GetMapping("")
    public List<Reservation> listReservations(@RequestParam(required = false) Long Id_Reservation) {
        if (Id_Reservation != null ) {
            List <Reservation> reserves = new ArrayList<>();
            reserves.add(reservationService.getById(Id_Reservation));
            return reserves;

        }
        return reservationService.findAll();
    }

    @GetMapping("/{Id_Reservation}")
    public Reservation getReservationById(@PathVariable Long Id_Reservation) {
        return reservationService.getById(Id_Reservation);
    }

    @DeleteMapping("/{Id_Reservation}")
    public void deleteReservation(@PathVariable Long Id_Reservation) {
        reservationService.deleteById(Id_Reservation);
    }

    @PostMapping("")
    public void addReservation(@RequestBody ReservationDto reservationDto) {
        reservationService.addReservation(reservationDto);
    }

    @PostMapping("/{id}")
    public void updateReservation(@RequestBody ReservationDto reservationDto, @PathVariable Long Id_Reservation) {
        reservationService.updateReservation(reservationDto, Id_Reservation);
    }

}
