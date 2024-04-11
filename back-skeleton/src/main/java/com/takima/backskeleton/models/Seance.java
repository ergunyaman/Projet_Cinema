package com.takima.backskeleton.models;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "seance")
@NoArgsConstructor
@Getter
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seance")
    private Long Id_Seance;

    /* @ManyToOne
        @JoinColumn(name= Id_Film )
        private Film  Film;*/
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_salle")
    @JsonIgnore
    private Salle salle;

    @Column(name = "date_heure")
    private Date Date_Heure;

    @Column(name = "prix")
    private float Prix;
    public void setId(Long id) {
        this.Id_Seance = id;
    }
}
