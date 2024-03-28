-- Suppression des tables en utilisant CASCADE pour s'occuper des dépendances
DROP TABLE IF EXISTS Reservation CASCADE;
DROP TABLE IF EXISTS Seance CASCADE;
DROP TABLE IF EXISTS Salle CASCADE;
DROP TABLE IF EXISTS Film CASCADE;
DROP TABLE IF EXISTS Realisateurs CASCADE;
DROP TABLE IF EXISTS Utilisateur CASCADE;


-- Création de la table Film

CREATE TABLE Film (
      Id_Film SERIAL PRIMARY KEY,
      Titre VARCHAR(50),
      Id_Realisateur INT,
      Synopsis VARCHAR(255),
      Date DATE,
      Duree FLOAT,
      Image bytea,
      Genre VARCHAR(50)
);

-- Création de la table Réalisateurs
-- Création de la table Réalisateurs avec la colonne Id_Realisateur définie comme SERIAL pour l'auto-incrémentation
CREATE TABLE Realisateurs (
      Id_Realisateur SERIAL PRIMARY KEY,
      Nom VARCHAR(50),
      Prenom VARCHAR(50),
      Biographie VARCHAR(255),
      Date DATE,
      Nationalite VARCHAR(50)
);


-- Création de la table Salle
CREATE TABLE Salle (
   Id_Salle SERIAL PRIMARY KEY,
   Capacite INT,
   Equipement VARCHAR(50),
   Id_Film INT,
   FOREIGN KEY (Id_Film) REFERENCES Film(Id_Film)
);

-- Création de la table Seance
CREATE TABLE Seance (
    Id_Seance SERIAL PRIMARY KEY,
    Id_Film INT,
    Id_Salle INT,
    Date_Heure DATE,
    Prix FLOAT,
    FOREIGN KEY (Id_Film) REFERENCES Film(Id_Film),
    FOREIGN KEY (Id_Salle) REFERENCES Salle(Id_Salle)
);

-- Création de la table Utilisateur
CREATE TABLE Utilisateur (
     Id_User SERIAL PRIMARY KEY,
     Nom VARCHAR(50),
     Prenom VARCHAR(50),
     Mail VARCHAR(50),
     Mdp VARCHAR(50)
);

-- Création de la table Reservation
CREATE TABLE Reservation (
     Id_Reservation SERIAL PRIMARY KEY,
     Id_User INT,
     Id_Seance INT,
     FOREIGN KEY (Id_User) REFERENCES Utilisateur(Id_User),
     FOREIGN KEY (Id_Seance) REFERENCES Seance(Id_Seance)
);
