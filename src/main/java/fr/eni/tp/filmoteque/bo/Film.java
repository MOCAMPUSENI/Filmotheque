package fr.eni.tp.filmoteque.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Film {
    private long id;
    private String titre;
    private int anne;
    private int duree;
    private String synopsis;
    private Genre genre;
    private Participant realisateur;
    private List<Participant> acteurs = new ArrayList<>();
    private List<Avis> avis = new ArrayList<>();

    public Film(long id, String titre, int anne, int duree, String synopsis, Genre genre, Participant realisateur) {
        this.id = id;
        this.titre = titre;
        this.anne = anne;
        this.duree = duree;
        this.synopsis = synopsis;
        this.genre = genre;
        this.realisateur = realisateur;
    }

    public Film(long id, String titre, int anne, int duree, String synopsis) {
        this.id = id;
        this.titre = titre;
        this.anne = anne;
        this.duree = duree;
        this.synopsis = synopsis;
    }

    public Film(String titre, int anne, int duree, String synopsis, Genre genre, Participant realisateur) {
        this.titre = titre;
        this.anne = anne;
        this.duree = duree;
        this.synopsis = synopsis;
        this.genre = genre;
        this.realisateur = realisateur;
    }

    public Film() {
        super();
    }

    // ! Getter(s) et Setter(s)
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Participant getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Participant realisateur) {
        this.realisateur = realisateur;
    }

    public List<Participant> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Participant> acteurs) {
        this.acteurs = acteurs;
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
                "\n   Realisateur : " + realisateur +
                "\n   Acteurs : " + acteurs +
                "\n   Genre : " + genre +
                "\n   Avis : " + avis;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id == film.id;
    }

}
