package fr.eni.tp.filmoteque.dal;

import fr.eni.tp.filmoteque.bo.Avis;

import java.util.List;

public class AvisRepositoryImpl implements AvisRepository {
    @Override
    public List<Avis> findAllAvis() {
        return List.of();
    }
    
    @Override
    public Avis findAvisById(int id) {
        return null;
    }
    
    @Override
    public List<Avis> findAllAvisByMembreId(int membreId) {
        return List.of();
    }
    
    @Override
    public List<Avis> findAllAvisByFilmId(int filmId) {
        return List.of();
    }
}
