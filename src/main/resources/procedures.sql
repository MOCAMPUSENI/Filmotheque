DROP PROCEDURE IF EXISTS dbo.create_acteur;
DROP PROCEDURE IF EXISTS dbo.create_avis;
DROP PROCEDURE IF EXISTS dbo.create_film;
DROP PROCEDURE IF EXISTS dbo.create_genre;
DROP PROCEDURE IF EXISTS dbo.create_participant;
DROP PROCEDURE IF EXISTS dbo.update_genre;
GO

CREATE PROCEDURE dbo.create_acteur
    @filmId INT,
    @participantId INT
AS
BEGIN
    INSERT INTO acteurs(filmId, participantId)
    VALUES (@filmId, @participantId);
END
GO

CREATE PROCEDURE dbo.create_avis
    @note INT,
    @commentaire NVARCHAR(100),
    @membreId INT,
    @filmId INT
AS
BEGIN
    INSERT INTO avis(note, commentaire, membreId, filmId)
    VALUES (@note, @commentaire, @membreId, @filmId);
END
GO

CREATE PROCEDURE dbo.create_film
    @Titre NVARCHAR(50),
    @Annee INT,
    @Duree INT,
    @Synopsis NVARCHAR(500),
    @GenreId INT,
    @RealisateurId INT,
    @NewId INT OUTPUT
AS
BEGIN
    INSERT INTO films (titre, annee, duree, synopsis, genreId, realisateurId)
    VALUES (@Titre, @Annee, @Duree, @Synopsis, @GenreId, @RealisateurId);

    SET @NewId = SCOPE_IDENTITY();
END
GO
