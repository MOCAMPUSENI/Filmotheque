package fr.eni.tp.filmoteque.dal;

import fr.eni.tp.filmoteque.bo.Avis;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AvisRepositoryImpl implements AvisRepository {
    private JdbcTemplate jdbcTemplate;
    
    public AvisRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Avis> findAllAvis() {
        String sql = "select * from dbo.findAllAvis";
        return jdbcTemplate.query(sql, new AvisRowMapper());
    }
    
    public Avis findAvisById(int id) {
        String sql = "select * from dbo.findAllAvis where id = ?";
        return jdbcTemplate.queryForObject(sql, new AvisRowMapper(), id);
    }
    
    public List<Avis> findAllAvisByMembreId(int membreId) {
        String  sql = "select * from dbo.findAllAvis where membreId = ?";
        return jdbcTemplate.query(sql, new AvisRowMapper(), membreId);
    }
    
    public List<Avis> findAllAvisByFilmId(int filmId) {
        String  sql = "select * from dbo.findAllAvis where filmId = ?";
        return jdbcTemplate.query(sql, new AvisRowMapper(), filmId);
    }
    
    static class AvisRowMapper implements RowMapper<Avis> {
        public Avis mapRow(ResultSet rs, int rowNum) throws SQLException {
            Avis avis = new Avis();
            avis.setId(rs.getInt("id"));
            avis.setNote(rs.getInt("note"));
            avis.setCommentaire(rs.getString("commentaire"));
            avis.setMembreId(rs.getInt("membreId"));
            avis.setFilmId(rs.getInt("filmId"));
            return avis;
        }
    }
    
    public void addAvis(Avis avis) {
        jdbcTemplate.update(connection -> {
            CallableStatement cs = connection.prepareCall("{call create_avis(?, ?, ?, ?)}");
            cs.setInt(1, avis.getNote());
            cs.setString(2, avis.getCommentaire());
            cs.setInt(3, avis.getMembreId());
            cs.setInt(4, avis.getFilmId());
            return cs;
        });
        // String sql = "INSERT INTO avis VALUES (?, ?, ?, ?)";
        // jdbcTemplate.update(sql, avis.getNote(), avis.getCommentaire(), avis.getMembreId(), avis.getFilmId());
    }
}
