package fr.eni.tp.filmoteque.dal;

import fr.eni.tp.filmoteque.bo.Genre;

import java.util.List;

public interface GenreRepository {
    List<Genre> findAllGenres();
    Genre findGenreById(int id);
    void addGenre(String libelle);
    void updateGenre(String newLibelle, int id);
}
