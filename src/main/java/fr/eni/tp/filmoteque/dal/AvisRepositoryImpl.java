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
        String sql = "select * from avis";
        return jdbcTemplate.query(sql, new AvisRowMapper());
    }
    
    public Avis findAvisById(int id) {
        String sql = "select * from avis where id = ?";
        return jdbcTemplate.queryForObject(sql, new AvisRowMapper(), id);
    }
    
    public List<Avis> findAllAvisByMembreId(int membreId) {
        String  sql = "select * from avis where membreId = ?";
        return jdbcTemplate.query(sql, new AvisRowMapper(), membreId);
    }
    
    public List<Avis> findAllAvisByFilmId(int filmId) {
        String  sql = "select * from avis where filmId = ?";
        return jdbcTemplate.query(sql, new AvisRowMapper(), filmId);
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
