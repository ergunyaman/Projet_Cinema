package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Utilisateur;

import java.io.IOException;

public class UtilisateurMapper {
    public static Utilisateur fromDto(UtilisateurDto dto, Long Id_User) throws IOException {
        return new Utilisateur.Builder()
                .Id_User(Id_User)
                .Nom(dto.getNom())
                .Prenom(dto.getPrenom())
                .Mail(dto.getMail())
                .build();
    }

    public static UtilisateurDto toDto(Utilisateur utilisateur){
        return UtilisateurDto.builder()
                .Nom(utilisateur.getNom())
                .Prenom(utilisateur.getPrenom())
                .Mail(utilisateur.getMail())
                .build();
    }
}
