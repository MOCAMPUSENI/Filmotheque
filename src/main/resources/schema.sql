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

create table participants (
                              id INT not null primary key IDENTITY(1,1),
                              prenom varchar(50) not null,
                              nom varchar(50) not null
);

create table films(
                      id INT not null primary key IDENTITY(1,1),
                      titre varchar(50) not null,
                      annee int not null,
                      duree int not null,
                      synopsis varchar(500) not null,
                      genreId int not null,
                      realisateurId int not null
);

alter table films add constraint fk_films_genre_id foreign key(genreId)
    references genres(id);

alter table films add constraint fk_films_realisateur_id foreign key(realisateurId)
    references participants(id);


create table acteurs(
                        filmId int NOT NULL,
                        participantId int NOT NULL);

alter table acteurs add primary key (filmId, participantId);

alter table acteurs add constraint fk_acteurs_filmId foreign key(filmId)   references films(id);
alter table acteurs add constraint fk_acteurs_participantId foreign key (participantId)   references participants(id);

create table membres(
    id INT not null primary key IDENTITY(1,1),
    nom NVARCHAR (100) NOT NULL,
    prenom NVARCHAR (100) NOT NULL,
    pseudo NVARCHAR(100) NOT NULL,
    admin BIT NOT NULL
);

create table avis(
    id INT not null primary key IDENTITY(1,1),
    note INT NOT NULL,
    commentaire NVARCHAR(100) NOT NULL,
    membreId INT NOT NULL,
    filmId INT NOT NULL
);

alter table avis add constraint fk_avis_membreId foreign key(membreId)   references membres(id);
alter table avis add constraint fk_avis_filmId foreign key(filmId)   references films(id);