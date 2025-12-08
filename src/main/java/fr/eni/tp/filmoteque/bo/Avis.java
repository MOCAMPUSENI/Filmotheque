package fr.eni.tp.filmoteque.bo;

public class Avis {
    private int id;
    private int note;
    private String commentaire;
    private int membreId;

    public Avis(int id, int note, String commentaire, int membreId) {
        this.id = id;
        this.note = note;
        this.commentaire = commentaire;
        this.membreId = membreId;
    }

    public Avis(int note, String commentaire, int membreId) {
        this.note = note;
        this.commentaire = commentaire;
        this.membreId = membreId;
    }

    public Avis() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getMembreId() {
        return membreId;
    }

    public void setMembreId(int membreId) {
        this.membreId = membreId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Avis avis = (Avis) o;
        return id == avis.id;
    }

}
