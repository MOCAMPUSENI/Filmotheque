package fr.eni.tp.filmoteque.bll;

import fr.eni.tp.filmoteque.dto.FilmDTO;

import java.util.List;

public interface FilmService {
    List<FilmDTO> consulterFilms();
    List<FilmDTO> findAllFilmsByRealisateur(int id);
    FilmDTO consulterFilmParId(int id);
    int creerFilm(FilmDTO film);
}
