package fr.eni.tp.filmoteque.bll;

import fr.eni.tp.filmoteque.bo.*;
import fr.eni.tp.filmoteque.dal.FilmRepository;
import fr.eni.tp.filmoteque.dal.FilmRepositoryImpl;
import fr.eni.tp.filmoteque.dal.GenreRepositoryImpl;
import fr.eni.tp.filmoteque.dto.FilmDTO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService{
    // Attributs statiques pour gérer les valeurs à afficher et simuler les données
    // en base
    private static List<Participant> lstParticipants = new ArrayList<>();
    private static int indexFilms = 1;
    FilmRepository filmRepository;
    GenreRepositoryImpl genreRepository;
    
    public FilmServiceImpl(GenreRepositoryImpl genreRepository, FilmRepository filmRepository) {
        this.genreRepository = genreRepository;
        this.filmRepository = filmRepository;
    }
    
    @Override
    public List<FilmDTO> consulterFilms() {
        return filmRepository.findAllFilms();
    }
    
    @Override
    public FilmDTO consulterFilmParId(int id) {
        return filmRepository.findFilmById(id);
    }
    
    @Override
    public List<Participant> consulterParticipants() {
        return lstParticipants;
    }
    
    @Override
    public int creerFilm(FilmDTO film) {
        return filmRepository.addFilm(film);
    }
    
    // ? GenreService
    
    public List<Genre> findAllGenres() {
        return genreRepository.findAllGenres();
    }
    
    public Genre findGenreById(int id) {
        return genreRepository.findGenreById(id);
    }
    
    public void addGenre(String libelle) {
        genreRepository.addGenre(libelle);
    }
    
    public void updateGenre(String newLibelle, int id) {
        genreRepository.updateGenre(newLibelle, id);
    }
}
