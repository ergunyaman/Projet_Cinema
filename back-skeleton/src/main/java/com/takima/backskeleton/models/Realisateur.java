package com.takima.backskeleton.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "realisateurs")
@NoArgsConstructor
@Getter
public class Realisateur {
    // Constructeurs, getters et setters
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "realisateurs_id_realisateur_seq")
    @JoinColumn(name = "Id_Realisateur")
    private Long id_realisateur;
    @Column(name = "Nom")
    private String nom;
    @Column(name = "Prenom")
    private String prenom;
    @Column(name = "Biographie")
    private String biographie;
    @Column(name = "Date")
    private java.sql.Date date;
    @Column(name = "Nationalite")
    private String nationalite;

    public void setId(Long id_realisateur) {
        this.id_realisateur = id_realisateur;
    }
}
