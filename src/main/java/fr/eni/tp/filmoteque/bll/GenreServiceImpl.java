package fr.eni.tp.filmoteque.bll;

import fr.eni.tp.filmoteque.bo.Genre;
import fr.eni.tp.filmoteque.dal.GenreRepositoryImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class GenreServiceImpl implements GenreService {
    // GenreRepositoryImpl genreRepository;
    //
    // public GenreServiceImpl(GenreRepositoryImpl genreRepository) {
    //     this.genreRepository = genreRepository;
    // }
    //
    // public List<Genre> findAllGenres() {
    //     return genreRepository.findAllGenres();
    // }
    //
    // public Genre findGenreById(int id) {
    //     return genreRepository.findGenreById(id);
    // }
}
