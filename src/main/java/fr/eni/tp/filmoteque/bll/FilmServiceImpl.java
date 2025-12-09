package fr.eni.tp.filmoteque.bll;

import fr.eni.tp.filmoteque.bo.*;
import fr.eni.tp.filmoteque.dal.FilmRepository;
import fr.eni.tp.filmoteque.dal.FilmRepositoryImpl;
import fr.eni.tp.filmoteque.dal.GenreRepositoryImpl;
import fr.eni.tp.filmoteque.dto.FilmDTO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService{
    // Attributs statiques pour gérer les valeurs à afficher et simuler les données
    // en base
    FilmRepository filmRepository;
    // GenreRepositoryImpl genreRepository;
    
    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
    
    @Cacheable("films")
    public List<FilmDTO> consulterFilms() {
        return filmRepository.findAllFilms();
    }
    
    @Override
    public FilmDTO consulterFilmParId(int id) {
        return filmRepository.findFilmById(id);
    }
    
    @CacheEvict(value = "films", allEntries = true)
    public int creerFilm(FilmDTO film) {
        return filmRepository.addFilm(film);
    }
    
    // // ? GenreService
    //
    // @Cacheable("genres")
    // public List<Genre> findAllGenres() {
    //     return genreRepository.findAllGenres();
    // }
    //
    // public Genre findGenreById(int id) {
    //     return genreRepository.findGenreById(id);
    // }
    //
    // @CacheEvict(value = "genres", allEntries = true)
    // public void addGenre(String libelle) {
    //     genreRepository.addGenre(libelle);
    // }
    //
    // @CacheEvict(value = "genres", allEntries = true)
    // public void updateGenre(String newLibelle, int id) {
    //     genreRepository.updateGenre(newLibelle, id);
    // }
}
