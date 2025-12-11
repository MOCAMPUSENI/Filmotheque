package fr.eni.tp.filmoteque.dal;

import fr.eni.tp.filmoteque.bo.Membre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MembresRepositoryImpl implements MembresRepository {
    private JdbcTemplate jdbcTemplate;
    
    public MembresRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Membre> findAllMembres() {
        String sql = "SELECT * FROM dbo.findAllMembres";
        return jdbcTemplate.query(sql, new MembreRowMapper());
    }
    
    @Override
    public Membre findMembreById(int id) {
        String sql = "SELECT * FROM dbo.findAllMembres WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new MembreRowMapper(), id);
    }
    
    public Membre findMembreByPseudo(String pseudo) {
        String sql = "SELECT * FROM dbo.findAllMembres WHERE pseudo = ?";
        return jdbcTemplate.queryForObject(sql, new MembreRowMapper(), pseudo);
    }
    
    static class MembreRowMapper implements RowMapper<Membre> {
        public Membre mapRow(ResultSet rs, int rowNum) throws SQLException {
            Membre membre = new Membre();
            membre.setId(rs.getInt("id"));
            membre.setPrenom(rs.getString("prenom"));
            membre.setNom(rs.getString("nom"));
            membre.setPseudo(rs.getString("pseudo"));
            membre.setMotDePasse(rs.getString("motDePasse"));
            membre.setAdmin(rs.getBoolean("admin"));
            return membre;
        }
    }
}
