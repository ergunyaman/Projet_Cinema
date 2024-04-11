-- Insertion des données pour la table Realisateurs
INSERT INTO Realisateurs (Id_Realisateur,Nom, Prenom, Biographie, date, Nationalite) VALUES
                                                                          (1,'Dupont', 'Jean', 'Un réalisateur français.', '1975-05-12', 'Française'),
                                                                          (2,'Durand', 'Marie', 'Une cinéaste primée.', '1982-04-16', 'Belge'),
                                                                          (3,'Tremblay', 'Luc', 'Un réalisateur de documentaires.', '1969-02-23', 'Canadienne'),
                                                                          (4,'Leroy', 'Sophie', 'Une réalisatrice de courts métrages.', '1990-07-30', 'Suisse'),
                                                                          (5,'Moreau', 'Étienne', 'Connu pour ses films dramatiques.', '1971-03-18', 'Française'),
                                                                          (6,'Garnier', 'Françoise', 'Une réalisatrice de comédies.', '1974-12-11', 'Belge'),
                                                                          (7,'Lefebvre', 'Pierre', 'Pionnier du cinéma d’animation.', '1954-08-09', 'Canadienne'),
                                                                          (8,'Mercier', 'Alice', 'Connue pour ses films indépendants.', '1977-10-24', 'Française'),
                                                                          (9,'Roux', 'Henri', 'Spécialiste du film noir.', '1985-01-05', 'Belge'),
                                                                          (10,'Vincent', 'Isabelle', 'Innovatrice en techniques cinématographiques.', '1964-06-19', 'Canadienne');

-- Insertion des données pour la table Film
INSERT INTO Film (id_film,Titre, Id_Realisateur, Synopsis, Date, Duree, Genre) VALUES
                                                                           (1,'La quête du temps', 1, 'Un voyage à travers les âges.', '2023-05-20', 120, 'Science-fiction'),
                                                                           (2,'Lueur d\ espoir', 2, 'Le parcours inspirant d\ un héros.', '2023-06-15', 90, 'Drame'),
                                                                           (3,'Rires à volonté', 3, 'Une comédie familiale hilarante.', '2023-07-22', 95, 'Comédie'),
                                                                           (4,'En quête de vérité', 4, 'Une enquête palpitante.', '2023-08-18', 105, 'Mystère'),
                                                                           (5,'Au cœur de l\océan', 5, 'Une aventure maritime épique.', '2023-09-10', 115, 'Aventure'),
                                                                           (6,'Le dernier duel', 6, 'Un affrontement historique.', '2023-10-05', 110, 'Action'),
                                                                           (7,'Les liens du destin', 7, 'Une saga familiale émouvante.', '2023-11-28', 100, 'Drame'),
                                                                           (8,'Frissons nocturnes', 8, 'Une terrifiante histoire de fantômes.', '2023-12-13', 85, 'Horreur'),
                                                                           (9,'La révolte des machines', 9, 'La lutte contre une IA rebelle.', '2024-01-20', 95, 'Science-fiction'),
                                                                           (10,'Le secret de la forêt', 10, 'Les mystères d\une forêt ancienne.', '2024-02-14', 90, 'Fantaisie');

-- Insertion des données pour la table Salle
INSERT INTO Salle (Id_Salle,capacite, Equipement, Id_Film) VALUES
                                                      (1,200, '4K Projecteur', 1),
                                                      (2,150, 'Son surround', 2),
                                                      (3,120, 'Sièges VIP', 3),
                                                      (4,100, 'Écran IMAX', 4),
                                                      (5,250, '3D Capable', 5),
                                                      (6,180, 'Dolby Atmos', 6),
                                                      (7,220, 'Projection Laser', 7),
                                                      (8,160, 'Grand écran', 8),
                                                      (9,130, 'Son Dolby', 9),
                                                      (10,190, 'Haute luminosité', 10);

-- Insertion des données pour la table Seance
INSERT INTO Seance (Id_Seance,Id_Film, Id_Salle, Date_Heure, Prix) VALUES
                                                             (1,1, 1, '2024-03-10 14:00:00', 8.50),
                                                             (2,2, 2, '2024-03-10 16:30:00', 10.00),
                                                             (3,3, 3, '2024-03-10 19:00:00', 9.00),
                                                             (4,4, 4, '2024-03-10 21:30:00', 11.00),
                                                             (5,5, 5, '2024-03-11 14:00:00', 8.50),
                                                             (6,6, 6, '2024-03-11 16:30:00', 10.00),
                                                             (7,7, 7, '2024-03-11 19:00:00', 9.00),
                                                             (8,8, 8, '2024-03-11 21:30:00', 11.00),
                                                             (9,9, 9, '2024-03-12 14:00:00', 8.50),
                                                             (10,10, 10, '2024-03-12 16:30:00', 10.00);

-- Insertion des données pour la table Utilisateur
INSERT INTO Utilisateur (id_user,Nom, Prenom, Mail, Mdp) VALUES
                                                     (1,'Martin', 'Paul', 'paul.martin@example.com', 'pass1234'),
                                                     (2,'Bernard', 'Julie', 'julie.bernard@example.com', 'motdepasse'),
                                                     (3,'Thomas', 'Amélie', 'amelie.thomas@example.com', '12345abcde'),
                                                     (4,'Petit', 'Louis', 'louis.petit@example.com', 'louisPWD'),
                                                     (5,'Robert', 'Emma', 'emma.robert@example.com', 'emma1234'),
                                                     (6,'Richard', 'Mathieu', 'mathieu.richard@example.com', 'richard_pass'),
                                                     (7,'Durand', 'Lucie', 'lucie.durand@example.com', 'luciedu'),
                                                     (8,'Dubois', 'Antoine', 'antoine.dubois@example.com', 'antoinepw'),
                                                     (9,'Moreau', 'Clara', 'clara.moreau@example.com', 'clara_pw'),
                                                     (10,'Laurent', 'Sébastien', 'sebastien.laurent@example.com', 'seb2024');

-- Insertion des données pour la table Reservation
INSERT INTO Reservation (id_reservation,Id_User, Id_Seance) VALUES
                                                 (1,1, 1),
                                                 (2,2, 2),
                                                 (3,3, 3),
                                                 (4,4, 4),
                                                 (5,5, 5),
                                                 (6,6, 6),
                                                 (7,7, 7),
                                                 (8,8, 8),
                                                 (9,9, 9),
                                                 (10,10, 10);