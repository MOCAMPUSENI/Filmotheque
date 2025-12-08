package fr.eni.tp.filmoteque.dal;

import fr.eni.tp.filmoteque.bo.Membre;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MembresRepositoryImpl implements MembresRepository {
    private JdbcTemplate jdbcTemplate;
    
    public MembresRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Membre> findAllMembres() {
        return List.of();
    }
    
    @Override
    public Membre findMembreById(int id) {
        return null;
    }
}
