DROP TABLE IF EXISTS acteurs;
DROP TABLE IF EXISTS avis;
DROP TABLE IF EXISTS membres;
DROP TABLE IF EXISTS films;
DROP TABLE IF EXISTS participants;
DROP TABLE IF EXISTS genres;

CREATE TABLE genres (
                        id INT IDENTITY(1,1) PRIMARY KEY,
                        libelle VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE participants (
                              id INT IDENTITY(1,1) PRIMARY KEY,
                              prenom VARCHAR(50) NOT NULL,
                              nom VARCHAR(50) NOT NULL
);

CREATE TABLE films (
                       id INT IDENTITY(1,1) PRIMARY KEY,
                       titre VARCHAR(50) NOT NULL,
                       annee INT NOT NULL,
                       duree INT NOT NULL,
                       synopsis VARCHAR(500) NOT NULL,
                       genreId INT NOT NULL,
                       realisateurId INT NOT NULL
);

ALTER TABLE films ADD CONSTRAINT fk_films_genre_id FOREIGN KEY(genreId) REFERENCES genres(id);
ALTER TABLE films ADD CONSTRAINT fk_films_realisateur_id FOREIGN KEY(realisateurId) REFERENCES participants(id);

CREATE TABLE acteurs (
                         filmId INT NOT NULL,
                         participantId INT NOT NULL,
                         PRIMARY KEY (filmId, participantId)
);

ALTER TABLE acteurs ADD CONSTRAINT fk_acteurs_film FOREIGN KEY(filmId) REFERENCES films(id);
ALTER TABLE acteurs ADD CONSTRAINT fk_acteurs_participant FOREIGN KEY(participantId) REFERENCES participants(id);

CREATE TABLE membres (
                         id INT IDENTITY(1,1) PRIMARY KEY,
                         nom NVARCHAR(100) NOT NULL,
                         prenom NVARCHAR(100) NOT NULL,
                         pseudo NVARCHAR(100) NOT NULL,
                         admin BIT NOT NULL
);

CREATE TABLE avis (
                      id INT IDENTITY(1,1) PRIMARY KEY,
                      note INT NOT NULL,
                      commentaire NVARCHAR(100) NOT NULL,
                      membreId INT NOT NULL,
                      filmId INT NOT NULL
);

ALTER TABLE avis ADD CONSTRAINT fk_avis_membre FOREIGN KEY(membreId) REFERENCES membres(id);
ALTER TABLE avis ADD CONSTRAINT fk_avis_film FOREIGN KEY(filmId) REFERENCES films(id);