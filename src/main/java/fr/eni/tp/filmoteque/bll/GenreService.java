package fr.eni.tp.filmoteque.bll;

import fr.eni.tp.filmoteque.bo.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> findAllGenres();
    Genre findGenreById(int id);
    void addGenre(String libelle);
    void updateGenre(String newLibelle, int id);
}
