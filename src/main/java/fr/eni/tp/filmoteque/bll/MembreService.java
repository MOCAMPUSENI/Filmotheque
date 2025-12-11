package fr.eni.tp.filmoteque.bll;

import fr.eni.tp.filmoteque.bo.Membre;

import java.util.List;

public interface MembreService {
    List<Membre> findAllMembres();
    Membre findMembreById(int id);
    Membre findMembreByPseudo(String pseudo);
}
