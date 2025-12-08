package fr.eni.tp.filmoteque.bo;

public class Participant extends Personne {
    private static final long serialVersionUID = 1L;

    public Participant(int id, String nom, String prenom) {
        super(id, nom, prenom);
    }

    public Participant(String nom, String prenom) {
        super(nom, prenom);
    }

    public Participant() {
        super();
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
