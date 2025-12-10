DROP VIEW IF EXISTS findAllAvis;
GO

DROP VIEW IF EXISTS findAllFilms;
GO

DROP VIEW IF EXISTS findAllGenres;
GO

DROP VIEW IF EXISTS findAllMembres;
GO

DROP VIEW IF EXISTS getAllFilmsByParticipant;
GO

DROP VIEW IF EXISTS getAllParticipantByFilmId;
GO

DROP VIEW IF EXISTS getAllParticipants;
GO

DROP VIEW IF EXISTS getAllParticipantsByFilmId;
GO

CREATE VIEW findAllAvis
AS
SELECT id, note, commentaire, membreId, filmId
FROM avis;
GO

CREATE VIEW findAllFilms
AS
SELECT id, titre, annee, duree, synopsis, genreId, realisateurId
FROM films;
GO

CREATE VIEW findAllGenres
AS
SELECT id, libelle
FROM genres;
GO

CREATE VIEW findAllMembres
AS
SELECT id, nom, prenom, pseudo, admin
FROM membres;
GO

CREATE VIEW getAllFilmsByParticipant
AS
SELECT
    a.participantId,
    f.*
FROM acteurs a
         INNER JOIN films f ON f.id = a.filmId;
GO

CREATE VIEW getAllParticipantByFilmId
AS
SELECT
    a.filmId,
    p.*
FROM acteurs a
         INNER JOIN participants p ON p.id = a.participantId;
GO

CREATE VIEW getAllParticipants
AS
SELECT id, prenom, nom
FROM participants;
GO

CREATE VIEW getAllParticipantsByFilmId
AS
SELECT p.*
FROM acteurs a
         INNER JOIN participants p ON p.id = a.participantId;
GO
