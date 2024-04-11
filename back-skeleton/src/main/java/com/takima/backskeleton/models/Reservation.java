package com.takima.backskeleton.models;

import lombok.Getter;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="reservation")
@Getter


public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_id_reservation_seq")
    @Column(name = "id_reservation")
    private Long Id_Reservation;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_user")
    private Utilisateur utilisateur;

    @Column(name = "id_seance")
    private Long Id_Seance;
    /*
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Id_User")
    private Seance seance;
    */


    private Reservation (Builder builder){
        this.Id_Reservation = builder.Id_Reservation;
        this.utilisateur = builder.utilisateur;
        this.Id_Seance = builder.Id_Seance;
    }

    public Reservation(){
    }
    public static class Builder {
        private Long Id_Reservation;
        private Utilisateur utilisateur;
        private Long Id_Seance;
        public Builder Id_Reservation (Long Id_Reservation) {
            this.Id_Reservation = Id_Reservation;
            return this;
        }
        public Builder utilisateur (Utilisateur utilisateur){
            this.utilisateur= utilisateur;
            return this;
        }
        public Builder Id_Seance (Long Id_Seance) {
            this.Id_Seance = Id_Seance;
            return this;
        }
        public Reservation build() {return new Reservation(this);}
    }
}
