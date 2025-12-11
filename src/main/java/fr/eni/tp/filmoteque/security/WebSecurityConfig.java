package fr.eni.tp.filmoteque.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home", "/css/*").permitAll()
                        .requestMatchers("/.well-known/**").permitAll()
                        .requestMatchers("/error").permitAll()
                        .requestMatchers("/films/creer").hasAllRoles("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/login")     // <-- Ta page personnalisée
                        .permitAll()             // <-- Important
                        .defaultSuccessUrl("/")
                )
                .logout((logout) -> logout.permitAll());
        
        return http.build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    
    // @Bean
    // public UserDetailsService userDetailsService() {
    //     BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    //     UserDetails user =
    //             User.builder()
    //                     .username("user")
    //                     .password(encoder.encode("password"))
    //                     .roles("USER")
    //                     .build();
    //
    //     return new InMemoryUserDetailsManager(user);
    // }
}