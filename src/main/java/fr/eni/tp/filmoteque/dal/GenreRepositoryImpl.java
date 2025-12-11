package fr.eni.tp.filmoteque.dal;

import fr.eni.tp.filmoteque.bo.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
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
        String sql = "select * from dbo.findAllGenres";
        return jdbcTemplate.query(sql, new GenreRowMapper());
    }
    
    public Genre findGenreById(int id) {
        String sql = "select * from dbo.findAllGenres where id = ?";
        return jdbcTemplate.queryForObject(sql, new GenreRowMapper(), id);
    }
    
    public void addGenre(String libelle) {
        jdbcTemplate.update(connection -> {
            CallableStatement cs = connection.prepareCall("{call create_genre(?)}");
            cs.setString(1, libelle);
            return cs;
        });
    }
    
    public void updateGenre(String newLibelle, int id) {
        jdbcTemplate.update(connection -> {
            CallableStatement cs = connection.prepareCall("{call update_genre(?,?)}");
            cs.setString(1, newLibelle);
            cs.setInt(2, id);
            return cs;
        });
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
