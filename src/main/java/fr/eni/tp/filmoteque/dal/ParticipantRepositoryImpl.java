package fr.eni.tp.filmoteque.dal;

import fr.eni.tp.filmoteque.bo.Participant;
import fr.eni.tp.filmoteque.dto.FilmDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ParticipantRepositoryImpl implements ParticipantRepository {
    private JdbcTemplate jdbcTemplate;
    
    public ParticipantRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Participant> getAllParticipants() {
        String sql = "select * from participants order by id";
        return jdbcTemplate.query(sql, new ParticipantRowMapper());
    }
    
    public Participant getParticipantById (int id) {
        String sql =  "select * from participants where id = ?";
        return jdbcTemplate.queryForObject(sql, new ParticipantRowMapper(), id);
    }
    
    public List<Participant> getAllParticipantsByFilmId (int filmId) {
        String sql =  "SELECT p.* FROM acteurs a INNER JOIN participants p ON p.id = a.participantId WHERE a.filmId = ?";
        return jdbcTemplate.query(sql, new ParticipantRowMapper(), filmId);
    }
    
    public List<FilmDTO> getAllFilmsByParticipant (int id) {
        return null;
        
    }
    
    public void addParticipant(Participant participant) {
        String sql = "INSERT INTO participants VALUES (?, ?)";
        jdbcTemplate.update(sql, participant.getPrenom(), participant.getNom());
    }
    
    public void addParticipantToFilm(int participantId, int filmId) {
        String sql = "INSERT INTO acteurs VALUES (?, ?)";
        jdbcTemplate.update(sql, filmId, participantId);
    }
    
    static class ParticipantRowMapper implements RowMapper<Participant> {
        public Participant mapRow(ResultSet rs, int rowNum) throws SQLException {
            Participant participant = new Participant();
            participant.setId(rs.getInt("id"));
            participant.setPrenom(rs.getString("prenom"));
            participant.setNom(rs.getString("nom"));
            return participant;
        }
    }
}
