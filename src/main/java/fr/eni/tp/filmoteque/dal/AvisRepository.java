package fr.eni.tp.filmoteque.dal;

import fr.eni.tp.filmoteque.bo.Avis;

import java.util.List;

public interface AvisRepository {
    List<Avis> findAllAvis();
    Avis findAvisById(int id);
    List<Avis> findAllAvisByMembreId(int membreId);
    List<Avis> findAllAvisByFilmId(int filmId);
}
