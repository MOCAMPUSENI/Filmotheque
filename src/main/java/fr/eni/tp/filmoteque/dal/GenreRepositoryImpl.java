package fr.eni.tp.filmoteque.dal;

import fr.eni.tp.filmoteque.bo.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GenreRepositoryImpl implements GenreRepository {
    private JdbcTemplate jdbcTemplate;
    
    public GenreRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Genre> findAllGenres() {
        String sql = "select id, libelle from genres";
        return jdbcTemplate.query(sql, new GenreRowMapper());
    }
    
    public Genre findGenreById(int id) {
        String sql = "select id, libelle from genres where id = ?";
        return jdbcTemplate.queryForObject(sql, new GenreRowMapper(), id);
    }
    
    public void addGenre(String libelle) {
        String sql = "insert into genres (libelle) values (?)";
        jdbcTemplate.update(sql, libelle);
    }
    
    public void updateGenre(String newLibelle, int id) {
        String sql = "update genres set libelle = ? where id = ?";
        PreparedStatementSetter pss = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, newLibelle);
                ps.setInt(2, id);
            }
        };
        jdbcTemplate.update(sql, pss);
    }
    
    static class GenreRowMapper implements RowMapper<Genre> {
        public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
            Genre genre = new Genre();
            genre.setId(rs.getInt("id"));
            genre.setTitle(rs.getString("libelle"));
            return genre;
        }
    }
}
