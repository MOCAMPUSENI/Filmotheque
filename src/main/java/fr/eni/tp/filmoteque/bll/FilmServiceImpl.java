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
    
    // @Override
    // public Participant consulterParticipantParId(int id) {
    //     return lstParticipants.stream().filter(item -> item.getId() == id).findAny().orElse(null);
    // }
    
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
    
    /**
     * Cette méthode permet de simuler le stockage en base de données et la remontée
     * d'information
     */
    // public void simulationCoucheDALetDB() {
    //     // Création de la liste des genres
    //
    //     // Création de la liste des participants aux films (acteurs et réalisateurs)
    //     // 3 réalisateurs dont 1 pour 2 films et 1 réalisateurs qui est aussi un acteur
    //     lstParticipants.add(new Participant(1, "Spielberg", "Steven"));
    //     lstParticipants.add(new Participant(2, "Cronenberg", "David"));
    //     lstParticipants.add(new Participant(3, "Boon", "Dany"));
    //
    //     // 2 acteurs par film et l'un d'eux dans 2 films
    //     lstParticipants.add(new Participant(4, "Attenborough", "Richard"));
    //     lstParticipants.add(new Participant(5, "Goldblum", "Jeff"));
    //     lstParticipants.add(new Participant(6, "Davis", "Geena"));
    //     lstParticipants.add(new Participant(7, "Rylance", "Mark"));
    //     lstParticipants.add(new Participant(8, "Barnhill", "Ruby"));
    //     lstParticipants.add(new Participant(9, "Merad", "Kad"));
    //
    //     // Création de la liste de films
    //     // 4 films
    //     FilmDTO jurassicPark = new FilmDTO(indexFilms++, "Jurassic Park", 1993, 128,
    //             "Le film raconte l'histoire d'un milliardaire et son équipe de généticiens parvenant à ramener à la vie des dinosaures grâce au clonage.");
    //     jurassicPark.setGenreId(genreRepository.findGenreById(1).getId());
    //     // jurassicPark.setRealisateurId(consulterParticipantParId(1).getId());
    //     // Associer les acteurs
    //     // jurassicPark.getActeurs().add(consulterParticipantParId(4));
    //     // jurassicPark.getActeurs().add(consulterParticipantParId(5));
    //     filmRepository.addFilm(jurassicPark);
    //
    //     FilmDTO theFly = new FilmDTO(indexFilms++, "The Fly", 1986, 95,
    //             "Il s'agit de l'adaptation cinématographique de la nouvelle éponyme de l'auteur George Langelaan.");
    //     theFly.setGenre(genreRepository.findGenreById(1));
    //     // theFly.setRealisateur(consulterParticipantParId(2));
    //     // // Associer les acteurs
    //     // theFly.getActeurs().add(consulterParticipantParId(5));
    //     // theFly.getActeurs().add(consulterParticipantParId(6));
    //     filmRepository.addFilm(theFly);
    //
    //     Film theBFG = new Film(indexFilms++, "The BFG", 2016, 117,
    //             "Le Bon Gros Géant est un géant bien différent des autres habitants du Pays des Géants.");
    //     theBFG.setGenre(genreRepository.findGenreById(4));
    //     theBFG.setRealisateur(consulterParticipantParId(1));
    //     // Associer les acteurs
    //     theBFG.getActeurs().add(consulterParticipantParId(7));
    //     theBFG.getActeurs().add(consulterParticipantParId(8));
    //     lstFilms.add(theBFG);
    //
    //     Film bienvenueChezLesChtis = new Film(indexFilms++, "Bienvenue chez les Ch'tis", 2008, 106,
    //             "Philippe Abrams est directeur de la poste de Salon-de-Provence. Il est marié à Julie, dont le caractère dépressif lui rend la vie impossible. Pour lui faire plaisir, Philippe fraude afin d'obtenir une mutation sur la Côte d'Azur. Mais il est démasqué: il sera muté à Bergues, petite ville du Nord.");
    //     bienvenueChezLesChtis.setGenre(genreRepository.findGenreById(4));
    //     bienvenueChezLesChtis.setRealisateur(consulterParticipantParId(3));
    //     // Associer les acteurs
    //     bienvenueChezLesChtis.getActeurs().add(consulterParticipantParId(3));
    //     bienvenueChezLesChtis.getActeurs().add(consulterParticipantParId(9));
    //     lstFilms.add(bienvenueChezLesChtis);
    //
    //     // Création d'un membre et un avis
    //     Membre membre1 = new Membre(1, "Baille", "Anne-Lise", "abaille@campus-eni.fr", false);
    //     Avis avis = new Avis(1, 4, "On rit du début à la fin", membre1);
    //     bienvenueChezLesChtis.getAvis().add(avis);
    // }
}
