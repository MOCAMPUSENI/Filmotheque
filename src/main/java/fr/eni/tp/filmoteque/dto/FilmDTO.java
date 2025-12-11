package fr.eni.tp.filmoteque.dto;

import fr.eni.tp.filmoteque.bo.Avis;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

public class FilmDTO {
    private int id;
    
    @NotNull(message = "Le titre est obligatoire")
    @Size(min = 3, max = 50, message = "Le titre doit comporter entre 3 à 50 caractère(s)")
    private String titre;
    
    @Min(1900)
    @Max(2025)
    @Positive(message = "L anne doit être positif")
    private int anne;
    
    @Min(1)
    @Max(366)
    private int duree;
    
    @NotNull(message = "Le synopsis est obligatoire")
    @Size(min = 3, max = 50, message = "Le titre doit comporter entre 3 à 50 caractère(s)")
    private String synopsis;
    
    @Min(1)
    private int genreId;
    
    @Min(1)
    private int realisateurId;
    
    @Size(min = 1, message = "Vous devez choisir au moins un acteur")
    private List<Integer> acteursId = new ArrayList<>();
    private List<Avis> avis = new ArrayList<>();

    public FilmDTO(int id, String titre, int anne, int duree, String synopsis, int genreId, int realisateurId) {
        this.id = id;
        this.titre = titre;
        this.anne = anne;
        this.duree = duree;
        this.synopsis = synopsis;
        this.genreId = genreId;
        this.realisateurId = realisateurId;
    }

    public FilmDTO(int id, String titre, int anne, int duree, String synopsis) {
        this.id = id;
        this.titre = titre;
        this.anne = anne;
        this.duree = duree;
        this.synopsis = synopsis;
    }

    public FilmDTO(String titre, int anne, int duree, String synopsis, int genreId, int realisateurId) {
        this.titre = titre;
        this.anne = anne;
        this.duree = duree;
        this.synopsis = synopsis;
        this.genreId = genreId;
        this.realisateurId = realisateurId;
    }
    
    public FilmDTO(String titre, int anne, int duree, String synopsis, int genreId, int realisateurId, List<Integer> acteursId) {
        this.titre = titre;
        this.anne = anne;
        this.duree = duree;
        this.synopsis = synopsis;
        this.genreId = genreId;
        this.realisateurId = realisateurId;
        this.acteursId = acteursId;
    }

    public FilmDTO() {
    }

    // ! Getter(s) et Setter(s)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAnne() {
        return anne;
    }

    public void setAnne(int anne) {
        this.anne = anne;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public int getRealisateurId() {
        return realisateurId;
    }

    public void setRealisateurId(int realisateurId) {
        this.realisateurId = realisateurId;
    }
    
    public List<Integer> getActeursId() {
        return acteursId;
    }
    
    public void setActeursId(List<Integer> acteursId) {
        this.acteursId = acteursId;
    }
    public List<Avis> getAvis() {
        return avis;
    }

    public  void setAvis(Avis avis) {}

    @Override
    public String toString() {
        return "Film (" + id + ")\n" +
                "   Titre : " + titre +
                "[anne : " + anne +
                ", duree : " + duree +
                "]\n   Synopsis : " + synopsis +
                "\n   RealisateurId : " + realisateurId +
                "\n   ActeursId(s) : " + acteursId +
                "\n   GenreId : " + genreId +
                "\n   Avis : " + avis;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FilmDTO film = (FilmDTO) o;
        return id == film.id;
    }

}
