package fr.eni.tp.filmoteque.bo;

import java.util.Objects;

public class Membre extends Personne {
    private static final long serialVersionUID = 1L;
    private String pseudo;
    private String motDePasse;
    private boolean admin = false;

    public Membre() {
        super();
    }

    public Membre(int id, String nom, String prenom, String pseudo, boolean admin) {
        super(id, nom, prenom);
        this.pseudo = pseudo;
        this.admin = admin;
    }

    public Membre(String nom, String prenom, String pseudo, boolean admin) {
        super(nom, prenom);
        this.pseudo = pseudo;
        this.admin = admin;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Membre (" +
                "pseudo=" + pseudo + '\'' +
                ", admin=" + admin +
                ')';
    }
}
