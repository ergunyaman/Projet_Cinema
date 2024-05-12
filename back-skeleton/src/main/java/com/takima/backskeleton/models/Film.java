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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "film_id_film_seq")
    @Column(name = "Id_film")
    private Long id_film;
    @Column(name = "titre")
    private String titre;

    @ManyToOne
    @JoinColumn(name = "Id_Realisateur")
    private Realisateur id_realisateur;

    @Column(name = "synopsis")
    private String synopsis;
    @Column(name = "date")
    private Date date;
    @Column(name = "duree")
    private Float duree;

    @Lob // Indique que le type de donnée peut être très grand, comme pour stocker des images
    @JsonIgnore // Éventuellement ignoré pour éviter de charger des données binaires lourdes dans les réponses JSON
    @Column(name = "image")
    private byte[] image;

    @Column(name = "genre")
    private String genre;

    public void setId(Long id_film) {
        this.id_film = id_film;
    }
}
