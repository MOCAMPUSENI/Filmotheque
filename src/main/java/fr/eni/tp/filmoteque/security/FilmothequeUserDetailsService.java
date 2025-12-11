package fr.eni.tp.filmoteque.security;

import fr.eni.tp.filmoteque.bll.MembreServiceImpl;
import fr.eni.tp.filmoteque.bo.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class FilmothequeUserDetailsService implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    MembreServiceImpl membreService;
    
    public FilmothequeUserDetailsService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    
    @Override
    /* Cette méthode est appelée par Spring à chaque fois qu'un utilise essaye de se connecter */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Membre membre = membreService.findMembreByPseudo(username);
        String role = membre.isAdmin() ? "ADMIN" : "UTILISATEUR";
        User.UserBuilder builder = User.withUsername(username).password(membre.getMotDePasse()).roles(role);
        return builder.build();
    }}