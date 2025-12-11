package fr.eni.tp.filmoteque.dal;

import fr.eni.tp.filmoteque.bo.Membre;

import java.util.List;

public interface MembresRepository {
    List<Membre> findAllMembres();
    Membre findMembreById(int id);
    Membre findMembreByPseudo(String pseudo);
}
