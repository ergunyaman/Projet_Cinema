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
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String biographie;
    private java.sql.Date date;
    private String nationalite;


}
