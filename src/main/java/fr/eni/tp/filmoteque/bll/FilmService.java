package fr.eni.tp.filmoteque.bll;

import fr.eni.tp.filmoteque.bo.Film;
import fr.eni.tp.filmoteque.bo.Genre;
import fr.eni.tp.filmoteque.bo.Participant;
import fr.eni.tp.filmoteque.dto.FilmDTO;

import java.util.List;

public interface FilmService {
    List<FilmDTO> consulterFilms();
    FilmDTO consulterFilmParId(int id);
    int creerFilm(FilmDTO film);
    
    // GenreService
    List<Genre> findAllGenres();
    Genre findGenreById(int id);
    void addGenre(String libelle);
    void updateGenre(String newLibelle, int id);
}
