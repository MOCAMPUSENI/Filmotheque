package fr.eni.tp.filmoteque.bll.contexte;

import fr.eni.tp.filmoteque.bo.Membre;

import java.util.List;

public interface ContexteService {
    Membre charger(String email);
    List<Membre> getListMembre();
}
