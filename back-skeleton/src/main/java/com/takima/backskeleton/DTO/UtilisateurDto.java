package com.takima.backskeleton.DTO;


import com.takima.backskeleton.models.*;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Builder
@Getter
public class UtilisateurDto {
    private Long Id_User;
    private String Nom;
    private String Prenom;
    private String Mail;
    List<Reservation> reservationList;
}
