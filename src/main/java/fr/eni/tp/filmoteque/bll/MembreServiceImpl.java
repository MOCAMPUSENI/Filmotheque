package fr.eni.tp.filmoteque.bll;

import fr.eni.tp.filmoteque.bo.Membre;
import fr.eni.tp.filmoteque.dal.MembresRepositoryImpl;

import java.util.List;

public class MembreServiceImpl implements MembreService {
    MembresRepositoryImpl membresRepositoryImpl;
    
    public MembreServiceImpl(MembresRepositoryImpl membresRepositoryImpl) {
        this.membresRepositoryImpl = membresRepositoryImpl;
    }
    
    public List<Membre>  findAllMembres() {
        return membresRepositoryImpl.findAllMembres();
    }
    
    public Membre findMembreById(int id) {
        return membresRepositoryImpl.findMembreById(id);
    }
}
