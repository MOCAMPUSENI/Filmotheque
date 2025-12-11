package fr.eni.tp.filmoteque.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest()
public class SecurityConfigTest {
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Test void testPasswordEncoder() {
        System.out.println(passwordEncoder.encode("azerty"));
    }
}
