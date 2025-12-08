package fr.eni.tp.filmoteque.dal;

import fr.eni.tp.filmoteque.bo.Genre;
import fr.eni.tp.filmoteque.dto.FilmDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GenreRepositoryImplTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private GenreRepository  genreRepository;
    
    @BeforeEach
    public void setUp() {
        jdbcTemplate.update("DELETE FROM acteurs;");
        jdbcTemplate.update("DELETE FROM films;");
        jdbcTemplate.update("DELETE FROM participants;");
        jdbcTemplate.update("DELETE FROM genres;");
        
        jdbcTemplate.update("DBCC CHECKIDENT ('films', RESEED, 0);");
        jdbcTemplate.update("DBCC CHECKIDENT ('participants', RESEED, 0);");
        jdbcTemplate.update("DBCC CHECKIDENT ('genres', RESEED, 0);");
        
        jdbcTemplate.update("INSERT INTO genres (libelle) VALUES ('Action');");
        jdbcTemplate.update("INSERT INTO genres (libelle) VALUES ('Science-Fiction');");
        jdbcTemplate.update("INSERT INTO genres (libelle) VALUES ('Comédie');");
        jdbcTemplate.update("INSERT INTO genres (libelle) VALUES ('Drame');");
        
        jdbcTemplate.update("INSERT INTO participants (prenom, nom) VALUES ('Christopher', 'Nolan');     -- id = 1 (réalisateur)");
        jdbcTemplate.update("INSERT INTO participants (prenom, nom) VALUES ('Leonardo', 'DiCaprio');     -- id = 2");
        jdbcTemplate.update("INSERT INTO participants (prenom, nom) VALUES ('Joseph', 'Gordon-Levitt');  -- id = 3");
        jdbcTemplate.update("INSERT INTO participants (prenom, nom) VALUES ('Elliot', 'Page');           -- id = 4");
        jdbcTemplate.update("INSERT INTO participants (prenom, nom) VALUES ('Denis', 'Villeneuve');      -- id = 5 (réalisateur)");
        jdbcTemplate.update("INSERT INTO participants (prenom, nom) VALUES ('Timothée', 'Chalamet');     -- id = 6");
        jdbcTemplate.update("INSERT INTO participants (prenom, nom) VALUES ('Rebecca', 'Ferguson');      -- id = 7");
        jdbcTemplate.update("INSERT INTO participants (prenom, nom) VALUES ('Oscar', 'Isaac');           -- id = 8");
        
        jdbcTemplate.update(
                "INSERT INTO films (titre, annee, duree, synopsis, genreId, realisateurId) VALUES " +
                        "('Inception', 2010, 148, 'Un voleur professionnel infiltre les rêves pour voler des secrets.', 2, 1);"
        );
        
        jdbcTemplate.update(
                "INSERT INTO films (titre, annee, duree, synopsis, genreId, realisateurId) VALUES " +
                        "('Dune', 2021, 155, 'Un jeune héritier découvre son destin sur une planète désertique.', 2, 5);"
        );
        
        jdbcTemplate.update("INSERT INTO acteurs (filmId, participantId) VALUES (1, 2);  -- Leonardo DiCaprio");
        jdbcTemplate.update("INSERT INTO acteurs (filmId, participantId) VALUES (1, 3);  -- Joseph Gordon-Levitt");
        jdbcTemplate.update("INSERT INTO acteurs (filmId, participantId) VALUES (1, 4);  -- Elliot Page");
        jdbcTemplate.update("INSERT INTO acteurs (filmId, participantId) VALUES (2, 6);  -- Timothée Chalamet");
        jdbcTemplate.update("INSERT INTO acteurs (filmId, participantId) VALUES (2, 7);  -- Rebecca Ferguson");
        jdbcTemplate.update("INSERT INTO acteurs (filmId, participantId) VALUES (2, 8);  -- Oscar Isaac");
        
    }
    
    @Test
    @DisplayName("test voir si il y a exactement 4 genre")
    public void testFindAllGenres() {
        // ? AAA
        // ! Arrange : Préparation du test
        
        // ! Act : Appel de la méthode à tester
        List<Genre> genres = genreRepository.findAllGenres();
        
        // ! Assert : Vérification du résultat du Act
        assertNotNull(genres);
        assertEquals(4, genres.size());
    }
    
    @Test
    @DisplayName("test findGenreById cas si le genre existe")
    public void testFindGenreById() {
        // ? AAA
        // ! Arrange : Préparation du test
        
        // ! Act : Appel de la méthode à tester
        Genre genre = genreRepository.findGenreById(1);
        Genre genre1 = genreRepository.findGenreById(2);
        
        // ! Assert : Vérification du résultat du Act
        assertNotNull(genre);
        assertEquals("Action", genre.getTitle());
        assertEquals("Science-Fiction", genre1.getTitle());
    }
    
    @Test
    @DisplayName("test ajout Genre cas droit")
    public void testAjoutGenreCasDroit() {
        // ? AAA
        // ! Arrange : Préparation du test
        String titre = "Classique";
        
        // ! Act : Appel de la méthode à tester
        genreRepository.addGenre(titre);
        
        // ! Assert : Vérification du résultat du Act
        Genre genre = genreRepository.findGenreById(5);
        assertNotNull(genre);
        assertEquals(titre, genre.getTitle());
    }
}
