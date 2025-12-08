package fr.eni.tp.filmoteque.bll;

import fr.eni.tp.filmoteque.bo.Avis;
import fr.eni.tp.filmoteque.dal.AvisRepositoryImpl;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvisServiceImpl implements AvisService {
    AvisRepositoryImpl avisRepositoryImpl;
    
    public AvisServiceImpl(AvisRepositoryImpl avisRepositoryImpl) {
        this.avisRepositoryImpl = avisRepositoryImpl;
    }
    
    @Cacheable("avis")
    public List<Avis> findAllAvis() {
        return avisRepositoryImpl.findAllAvis();
    }

    public Avis findAvisById(int id) {
       return avisRepositoryImpl.findAvisById(id);
    }
    
    public List<Avis> findAllAvisByMembreId(int membreId) {
        return avisRepositoryImpl.findAllAvisByMembreId(membreId);
    }
    
    public List<Avis> findAllAvisByFilmId(int filmId) {
        return avisRepositoryImpl.findAllAvisByFilmId(filmId);
    }
    
    @CacheEvict(value = "avis", allEntries = true)
    public void addAvis(Avis avis) {
        avisRepositoryImpl.addAvis(avis);
    }
}
