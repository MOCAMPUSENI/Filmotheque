-- ===========================
-- RESET (optionnel selon ton environnement)
-- ===========================
-- TRUNCATE TABLE avis;
-- TRUNCATE TABLE membres;
-- TRUNCATE TABLE acteurs;
-- TRUNCATE TABLE films;
-- TRUNCATE TABLE participants;
-- TRUNCATE TABLE genres;

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
           1,  -- Science-Fiction
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

-- Star wars
INSERT INTO films (titre, annee, duree, synopsis, genreId, realisateurId)
VALUES (
           'Star wars',
           2003,
           155,
           'Chepas',
           2,  -- Science-Fiction
           2   -- Denis Villeneuve
       );

-- Toy story
INSERT INTO films (titre, annee, duree, synopsis, genreId, realisateurId)
VALUES (
           'Toy story',
           2010,
           200,
           'Des jouets',
           3,  -- Science-Fiction
           3   -- Denis Villeneuve
       );

-- Tron
INSERT INTO films (titre, annee, duree, synopsis, genreId, realisateurId)
VALUES (
           'Tron',
           2015,
           188,
           'Motos',
           4,  -- Science-Fiction
           7   -- Denis Villeneuve
       );

-- Star wars
INSERT INTO films (titre, annee, duree, synopsis, genreId, realisateurId)
VALUES (
           'Star wars 2',
           2006,
           155,
           'Chepas',
           2,  -- Science-Fiction
           2   -- Denis Villeneuve
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

-- ===========================
-- MEMBRES
-- ===========================
INSERT INTO membres (nom, prenom, pseudo, admin)
VALUES ('admin', 'istrateur', 'admin123', 1);

INSERT INTO membres (nom, prenom, pseudo, admin)
VALUES ('Baille', 'Anne-Lise', 'abaille@campus-eni.fr', 0);

INSERT INTO membres (nom, prenom, pseudo, admin)
VALUES ('Gobin', 'Stéphane', 'sgobin@campus-eni.fr', 0);

INSERT INTO membres (nom, prenom, pseudo, admin)
VALUES ('Trillard', 'Julien', 'jtrillard@campus-eni.fr', 0);

-- ===========================
-- AVIS (liés aux membres)
-- ===========================
INSERT INTO avis (note, commentaire, membreId, filmId)
VALUES (5, 'Incroyable film, concept brillant !', 2, 1);  -- user1

INSERT INTO avis (note, commentaire, membreId, filmId)
VALUES (4, 'Très bon film, visuellement superbe.', 3, 2);  -- user2

INSERT INTO avis (note, commentaire, membreId, filmId)
VALUES (5, 'Un chef d’œuvre de science-fiction.', 2, 2);  -- user1
