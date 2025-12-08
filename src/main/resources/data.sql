-- ===========================
-- GENRES
-- ===========================
INSERT INTO genres (libelle) VALUES ('Action');
INSERT INTO genres (libelle) VALUES ('Science-Fiction');
INSERT INTO genres (libelle) VALUES ('Comédie');
INSERT INTO genres (libelle) VALUES ('Drame');

-- ===========================
-- PARTICIPANTS (acteurs + réalisateurs)
-- ===========================
INSERT INTO participants (prenom, nom) VALUES ('Christopher', 'Nolan');     -- id = 1 (réalisateur)
INSERT INTO participants (prenom, nom) VALUES ('Leonardo', 'DiCaprio');     -- id = 2
INSERT INTO participants (prenom, nom) VALUES ('Joseph', 'Gordon-Levitt');  -- id = 3
INSERT INTO participants (prenom, nom) VALUES ('Elliot', 'Page');           -- id = 4

INSERT INTO participants (prenom, nom) VALUES ('Denis', 'Villeneuve');      -- id = 5 (réalisateur)
INSERT INTO participants (prenom, nom) VALUES ('Timothée', 'Chalamet');     -- id = 6
INSERT INTO participants (prenom, nom) VALUES ('Rebecca', 'Ferguson');      -- id = 7
INSERT INTO participants (prenom, nom) VALUES ('Oscar', 'Isaac');           -- id = 8

-- ===========================
-- FILMS
-- ===========================
-- Inception
INSERT INTO films (titre, annee, duree, synopsis, genreId, realisateurId)
VALUES (
           'Inception',
           2010,
           148,
           'Un voleur infiltre les rêves pour dérober des secrets.',
           2,  -- Science-Fiction
           1   -- Christopher Nolan
       );

-- Dune
INSERT INTO films (titre, annee, duree, synopsis, genreId, realisateurId)
VALUES (
           'Dune',
           2021,
           155,
           'Le destin d’un jeune homme lié à une planète désertique.',
           2,  -- Science-Fiction
           5   -- Denis Villeneuve
       );

-- ===========================
-- ACTEURS (casting)
-- ===========================

-- Casting Inception (filmId = 1)
INSERT INTO acteurs (filmId, participantId) VALUES (1, 2);  -- Leonardo DiCaprio
INSERT INTO acteurs (filmId, participantId) VALUES (1, 3);  -- Joseph Gordon-Levitt
INSERT INTO acteurs (filmId, participantId) VALUES (1, 4);  -- Elliot Page

-- Casting Dune (filmId = 2)
INSERT INTO acteurs (filmId, participantId) VALUES (2, 6);  -- Timothée Chalamet
INSERT INTO acteurs (filmId, participantId) VALUES (2, 7);  -- Rebecca Ferguson
INSERT INTO acteurs (filmId, participantId) VALUES (2, 8);  -- Oscar Isaac
