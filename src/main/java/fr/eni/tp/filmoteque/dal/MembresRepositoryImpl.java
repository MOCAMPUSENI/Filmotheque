package fr.eni.tp.filmoteque.dal;

import fr.eni.tp.filmoteque.bo.Membre;

import java.util.List;

public class MembresRepositoryImpl implements MembresRepository {
    @Override
    public List<Membre> findAllMembres() {
        return List.of();
    }
    
    @Override
    public Membre findMembreById(int id) {
        return null;
    }
}
