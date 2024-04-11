package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Reservation;

import java.io.IOException;

public class ReservationMapper {
    public static Reservation fromDto(ReservationDto dto, Long Id_Reservation) throws IOException {
        return new Reservation.Builder()
                .Id_Reservation(Id_Reservation)
                .utilisateur(dto.getUtilisateur())
                .Id_Seance(dto.getId_Seance())
                .build();
    }

    public static ReservationDto toDto (Reservation reservation){
        return ReservationDto.builder()
                .utilisateur(reservation.getUtilisateur())
                .Id_Seance(reservation.getId_Seance())
                .build();
    }
}
