package fr.eni.tp.filmoteque.dal;

import fr.eni.tp.filmoteque.bo.Participant;
import fr.eni.tp.filmoteque.dto.FilmDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
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
        String sql = "select * from dbo.getAllParticipants";
        return jdbcTemplate.query(sql, new ParticipantRowMapper());
    }
    
    public Participant getParticipantById (int id) {
        String sql =  "select * from dbo.getAllParticipants where id = ?";
        return jdbcTemplate.queryForObject(sql, new ParticipantRowMapper(), id);
    }
    
    public List<Participant> getAllParticipantsByFilmId (int filmId) {
        String sql =  "SELECT * FROM dbo.getAllParticipantByFilmId WHERE filmId = ?";
        return jdbcTemplate.query(sql, new ParticipantRowMapper(), filmId);
    }
    
    public List<FilmDTO> getAllFilmsByParticipant (int id) {
        String sql =  "SELECT * FROM dbo.getAllFilmsByParticipant WHERE participantId = ?";
        return jdbcTemplate.query(sql, new FilmRowMapper(), id);
    }
    
    public void addParticipant(Participant participant) {
        jdbcTemplate.update(connection -> {
            CallableStatement cs = connection.prepareCall("{call create_participant(?, ?)}");
            cs.setString(1, participant.getPrenom());
            cs.setString(2, participant.getNom());
            return cs;
        });
    }
    
    public void addParticipantToFilm(int participantId, int filmId) {
        jdbcTemplate.update(connection -> {
            CallableStatement cs = connection.prepareCall("{call create_acteur(?, ?)}");
            cs.setInt(1, filmId);
            cs.setInt(2, participantId);
            return cs;
        });
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
    
    static class FilmRowMapper implements RowMapper<FilmDTO> {
        public FilmDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            FilmDTO film = new FilmDTO();
            film.setId(rs.getInt("id"));
            film.setTitre(rs.getString("titre"));
            film.setAnne(rs.getInt("annee"));
            film.setDuree(rs.getInt("duree"));
            film.setSynopsis(rs.getString("synopsis"));
            film.setGenreId(rs.getInt("genreId"));
            film.setRealisateurId(rs.getInt("realisateurId"));
            return film;
        }
    }
}
