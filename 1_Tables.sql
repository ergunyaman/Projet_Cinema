CREATE TABLE Film (
                    Id_Film INT  PRIMARY ,
                    Titre VARCHAR(50),
                    Id_Realisateur INT,
                    Synopsis VARCHAR(255),
                    Date DATE,
                    Duree FLOAT,
                    Image BLOB,
                    Genre VARCHAR(50)
);

-- Création de la table Réalisateurs
CREATE TABLE Realisateurs (
                            Id_Realisateur INT PRIMARY KEY,
                            Nom VARCHAR(50),
                            Prenom VARCHAR(50),
                            Biographie VARCHAR(255),
                            date DATE,
                            Nationalite VARCHAR(50)
);

-- Création de la table Salle
CREATE TABLE Salle (
                     Id_Salle INT PRIMARY KEY,
                     Capacite INT,
                     Equipement VARCHAR(50),
                     Id_Film INT,
                     FOREIGN KEY (Id_Film) REFERENCES Film(Id_Film)
);

-- Création de la table Seance
CREATE TABLE Seance (
                      Id_Seance INT PRIMARY KEY,
                      Id_Film INT,
                      Id_Salle INT,
                      Date_Heure DATE,
                      Prix FLOAT,
                      FOREIGN KEY (Id_Film) REFERENCES Film(Id_Film),
                      FOREIGN KEY (Id_Salle) REFERENCES Salle(Id_Salle)
);

-- Création de la table Utilisateur
CREATE TABLE Utilisateur (
                           Id_User INT PRIMARY KEY,
                           Nom VARCHAR(50),
                           Prenom VARCHAR(50),
                           Mail VARCHAR(50),
                           Mdp VARCHAR(50)
);

-- Création de la table Reservation
CREATE TABLE Reservation (
                           Id_Reservation INT PRIMARY KEY,
                           Id_User INT,
                           Id_Seance INT,
                           FOREIGN KEY (Id_User) REFERENCES Utilisateur(Id_User),
                           FOREIGN KEY (Id_Seance) REFERENCES Seance(Id_Seance)
);
