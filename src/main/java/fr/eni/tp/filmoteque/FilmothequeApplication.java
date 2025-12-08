package fr.eni.tp.filmoteque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

import fr.eni.tp.filmoteque.controller.FilmController;

@SpringBootApplication
public class FilmothequeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilmothequeApplication.class, args);
    }

}
