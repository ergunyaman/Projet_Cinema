package com.takima.backskeleton.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Salle")
@NoArgsConstructor
@Getter
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_salle")
    private Long Id_Salle;


    @Column(name = "capacite")
    private int Capacite;

    @Column(name = "equipement")
    private String Equipement;

    @OneToMany(mappedBy = "salle")
    @JsonIgnore
    private List<Seance> Seances;

    public void setId(Long id){
        this.Id_Salle=id;
    }

   /* @ManyToOne
    @JoinColumn(name= Id_Film )
    private Film  Film;*/

}
