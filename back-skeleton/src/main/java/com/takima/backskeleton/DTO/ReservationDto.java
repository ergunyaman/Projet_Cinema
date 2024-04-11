package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Course;
import com.takima.backskeleton.models.Major;
import com.takima.backskeleton.models.Utilisateur;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Builder
@Getter
public class ReservationDto {
    private Long Id_Reservation;
    private Utilisateur utilisateur;
    private Long Id_Seance;
}
