package fr.eni.tp.filmoteque.bll;

import fr.eni.tp.filmoteque.bo.Avis;

import java.util.List;

public interface AvisService {
    List<Avis> findAllAvis();
    Avis findAvisById(int id);
    List<Avis> findAllAvisByMembreId(int membreId);
    List<Avis> findAllAvisByFilmId(int filmId);
    void addAvis(Avis avis);
}
