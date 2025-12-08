package fr.eni.tp.filmoteque.bll;

import fr.eni.tp.filmoteque.bo.Participant;
import fr.eni.tp.filmoteque.dal.ParticipantRepository;
import fr.eni.tp.filmoteque.dto.FilmDTO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService {
    ParticipantRepository participantRepository;
    
    public ParticipantServiceImpl(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }
    
    @Cacheable("participants")
    public List<Participant> getAllParticipants () {
        return participantRepository.getAllParticipants();
    }
    
    public Participant getParticipantById (int id) {
        return participantRepository.getParticipantById(id);
    }
    
    public List<Participant> getAllParticipantsByFilmId (int filmId) {
        return participantRepository.getAllParticipantsByFilmId(filmId);
    }
    
    public List<FilmDTO> getAllFilmsByParticipant (int id) {
        return participantRepository.getAllFilmsByParticipant(id);
    }
    
    @CacheEvict(value = "participants", allEntries = true)
    public void addParticipant(Participant participant) {
        participantRepository.addParticipant(participant);
    }
    
    public void addParticipantToFilm(int participantId, int filmId) {
        participantRepository.addParticipantToFilm(participantId, filmId);
    }
    
}
