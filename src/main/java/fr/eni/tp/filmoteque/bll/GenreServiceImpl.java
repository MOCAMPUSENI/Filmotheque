package fr.eni.tp.filmoteque.bll;

import fr.eni.tp.filmoteque.bo.Genre;
import fr.eni.tp.filmoteque.dal.GenreRepository;
import fr.eni.tp.filmoteque.dal.GenreRepositoryImpl;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    // ? GenreService
    GenreRepository genreRepository;
    
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }
    
    @Cacheable("genres")
    public List<Genre> findAllGenres() {
        return genreRepository.findAllGenres();
    }
    
    public Genre findGenreById(int id) {
        return genreRepository.findGenreById(id);
    }
    
    @CacheEvict(value = "genres", allEntries = true)
    public void addGenre(String libelle) {
        genreRepository.addGenre(libelle);
    }
    
    @CacheEvict(value = "genres", allEntries = true)
    public void updateGenre(String newLibelle, int id) {
        genreRepository.updateGenre(newLibelle, id);
    }
}
