package fr.eni.tp.filmoteque.bll;

import fr.eni.tp.filmoteque.bo.Participant;
import fr.eni.tp.filmoteque.dto.FilmDTO;

import java.util.List;

public interface ParticipantService {
    List<Participant> getAllParticipants ();
    Participant getParticipantById (int id);
    List<Participant> getAllParticipantsByFilmId (int filmId);
    List<FilmDTO> getAllFilmsByParticipant (int id);
    void addParticipant(Participant participant);
    void addParticipantToFilm(int participantId, int filmId);
}
