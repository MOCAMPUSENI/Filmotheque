package fr.eni.tp.filmoteque.bll;

import fr.eni.tp.filmoteque.bo.*;
import fr.eni.tp.filmoteque.dal.FilmRepository;
import fr.eni.tp.filmoteque.dto.FilmDTO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService{
    FilmRepository filmRepository;
    
    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
    
    @Cacheable("films")
    public List<FilmDTO> consulterFilms() {
        return filmRepository.findAllFilms();
    }
    
    public List<FilmDTO> findAllFilmsByRealisateur(int id) {
        return filmRepository.findAllFilmsByRealisateur(id);
    }
    
    @Override
    public FilmDTO consulterFilmParId(int id) {
        return filmRepository.findFilmById(id);
    }
    
    @CacheEvict(value = "films", allEntries = true)
    public int creerFilm(FilmDTO film) {
        return filmRepository.addFilm(film);
    }
}
