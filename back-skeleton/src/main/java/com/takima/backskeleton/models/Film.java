package com.takima.backskeleton.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "film")
@NoArgsConstructor
@Getter
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;

    @ManyToOne
    @JoinColumn(name = "id_realisateur", nullable = false)
    private Realisateur realisateur;

    private String synopsis;
    private Date date;
    private Float duree;

    @Lob // Indique que le type de donnée peut être très grand, comme pour stocker des images
    @JsonIgnore // Éventuellement ignoré pour éviter de charger des données binaires lourdes dans les réponses JSON
    private byte[] image;

    private String genre;

    public void setId(Long id) {
        this.id = id;
    }
}
