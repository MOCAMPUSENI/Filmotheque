package fr.eni.tp.filmoteque.dal;

import fr.eni.tp.filmoteque.bo.Film;
import fr.eni.tp.filmoteque.dto.FilmDTO;

import java.util.List;

public interface FilmRepository {
    List<FilmDTO> findAllFilms();
    FilmDTO findFilmById(int id);
    FilmDTO findFilmByName(String name);
    int addFilm(FilmDTO film);
}
