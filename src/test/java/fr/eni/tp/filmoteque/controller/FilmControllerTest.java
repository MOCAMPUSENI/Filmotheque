package fr.eni.tp.filmoteque.controller;

// import fr.eni.tp.filmoteque.config.TestSecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class FilmControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    void homeShouldHaveAccueil() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("accueil"));
    }
    
    @Test
    void FilmsPageShouldHaveViewFilms() throws Exception {
        mockMvc.perform(get("/films"))
                .andExpect(status().isOk())
                .andExpect(view().name("view-films"));
    }
    
    @Test
    void FilmsDetailsPageShouldHaveViewFilmsDetails() throws Exception {
        mockMvc.perform(get("/films/detail?id=1"))
                .andExpect(status().isOk())
                .andExpect(view().name("view-films-details"))
                .andExpect(model().attributeExists("film"));
    }
    
    @Test
    void GenresPageShouldHaveViewGenres() throws Exception {
        mockMvc.perform(get("/genre/creer"))
                .andExpect(status().isOk())
                .andExpect(view().name("view-genre"))
                .andExpect(model().attributeExists("genres"));
    }
}
