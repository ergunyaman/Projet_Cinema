package com.takima.backskeleton.models;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;


import java.util.List;
@Entity
@Table(name="utilisateur")

@Getter
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "utilisateur_id_user_seq")
    @Column(name = "id_user")
    private Long Id_User;
    @Column(name = "nom")
    private String Nom;
    @Column(name = "prenom")
    private String Prenom;
    @Column(name = "mail")
    private String Mail;
    @Column(name = "mdp")
    private String Mdp;
    @OneToMany(mappedBy = "utilisateur") //nom de la column
    @JsonIgnore
    private List<Reservation> reservationList;



    private Utilisateur(Builder builder){
        this.Id_User= builder.Id_User;
        this.Nom= builder.Nom;
        this.Prenom= builder.Prenom;
        this.Mail= builder.Mail;
        this.Mdp= builder.Mdp;
    }

    public Utilisateur() {
    }
    public static class Builder {
        private Long Id_User;
        private String Nom;
        private String Prenom;
        private String Mail;
        private String Mdp;


        public Builder Id_User(Long Id_User) {
            this.Id_User = Id_User;
            return this;
        }

        public Builder Nom(String Nom) {
            this.Nom = Nom;
            return this;
        }

        public Builder Prenom(String Prenom) {
            this.Prenom = Prenom;
            return this;
        }

        public Builder Mail(String Mail) {
            this.Mail = Mail;
            return this;
        }

        public Builder Mdp(String Mdp) {
            this.Mdp = Mdp;
            return this;
        }

        public Utilisateur build() {
            return new Utilisateur(this);
        }
    }
}
