package fr.eni.tp.filmoteque.dal;

import fr.eni.tp.filmoteque.bo.Avis;
import fr.eni.tp.filmoteque.bo.Membre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AvisRepositoryImpl implements AvisRepository {
    private JdbcTemplate jdbcTemplate;
    
    public AvisRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Avis> findAllAvis() {
        return List.of();
    }
    
    public Avis findAvisById(int id) {
        return null;
    }
    
    public List<Avis> findAllAvisByMembreId(int membreId) {
        return List.of();
    }
    
    public List<Avis> findAllAvisByFilmId(int filmId) {
        return List.of();
    }
    
    static class AvisRowMapper implements RowMapper<Avis> {
        public Avis mapRow(ResultSet rs, int rowNum) throws SQLException {
            Avis avis = new Avis();
            avis.setId(rs.getInt("id"));
            avis.setNote(rs.getInt("note"));
            avis.setCommentaire(rs.getString("commentaire"));
            avis.setMembreId(rs.getInt("membreId"));
            return avis;
        }
    }
}
