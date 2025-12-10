package fr.eni.tp.filmoteque.dal;

import fr.eni.tp.filmoteque.dto.FilmDTO;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Repository
public class FilmRepositoryImpl implements FilmRepository {
    private JdbcTemplate jdbcTemplate;
    
    public FilmRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<FilmDTO> findAllFilms() {
        String sql = "select * from dbo.findAllFilms";
        return jdbcTemplate.query(sql, new FilmRowMapper());
    }
    
    public List<FilmDTO> findAllFilmsByRealisateur(int id) {
        String sql = "select * from dbo.findAllFilms WHERE realisateurId = ?";
        return jdbcTemplate.query(sql, new FilmRowMapper(), id);
    }
    
    public FilmDTO findFilmById(int id) {
        String sql = "select * from dbo.findAllFilms where id = ?";
        return jdbcTemplate.queryForObject(sql, new FilmRowMapper(), id);
    }
    
    public FilmDTO findFilmByName(String name) {
        String sql = "select * from dbo.findAllFilms where titre = ?";
        return jdbcTemplate.queryForObject(sql, new FilmRowMapper(), name);
    }
    
    public int addFilm(FilmDTO film) {
        return jdbcTemplate.execute((ConnectionCallback<Integer>) connection -> {
            CallableStatement cs = connection.prepareCall("{call dbo.create_film(?,?,?,?,?,?,?)}");
            
            cs.setString(1, film.getTitre());
            cs.setInt(2, film.getAnne());
            cs.setInt(3, film.getDuree());
            cs.setString(4, film.getSynopsis());
            cs.setInt(5, film.getGenreId());
            cs.setInt(6, film.getRealisateurId());
            
            cs.registerOutParameter(7, Types.INTEGER);
            
            cs.execute();
            
            return cs.getInt(7);
        });
        // SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
        //         .withTableName("films")
        //         .usingGeneratedKeyColumns("id");
        //
        // Map<String, Object> params = Map.of(
        //         "titre", film.getTitre(),
        //         "annee", film.getAnne(),
        //         "duree", film.getDuree(),
        //         "synopsis", film.getSynopsis(),
        //         "genreId", film.getGenreId(),
        //         "realisateurId", film.getRealisateurId()
        // );
        //
        // Number id = insert.executeAndReturnKey(params);
        //
        // return id.intValue();
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
