package fr.eni.tp.filmoteque.controller;

import fr.eni.tp.filmoteque.bll.AvisService;
import fr.eni.tp.filmoteque.bll.FilmService;
import fr.eni.tp.filmoteque.bll.MembreService;
import fr.eni.tp.filmoteque.bll.ParticipantService;
import fr.eni.tp.filmoteque.bll.contexte.ContexteService;
import fr.eni.tp.filmoteque.bo.*;
import fr.eni.tp.filmoteque.dal.AvisRepository;
import fr.eni.tp.filmoteque.dto.FilmDTO;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FilmController {
    FilmService filmService;
    ContexteService  contexteService;
    ParticipantService  participantService;
    AvisService avisRepository;
    MembreService membreService;
    
    public FilmController(FilmService filmService, ContexteService contexteService, ParticipantService participantService, AvisService avisService, MembreService membreService) {
        this.filmService = filmService;
        this.contexteService = contexteService;
        this.participantService = participantService;
        this.avisRepository = avisService;
        this.membreService = membreService;
    }

    @GetMapping("/films")
    public String afficherFilms(Model model) {
        model.addAttribute("films", filmService.consulterFilms());
        return "view-films";
    }
    
    @GetMapping("/films/detail")
    public String afficherUnFilm(@RequestParam(name = "id") int id, Model model) {
        model.addAttribute("film", filmService.consulterFilmParId(id));
        model.addAttribute("membres", contexteService.getListMembre());
        return "view-films-details";
    }
    
    @GetMapping("/films/creer")
    public String creerFilm(Model model) {
        FilmDTO filmDTO = (FilmDTO) model.getAttribute("filmDTO");
        if (filmDTO == null) {
            model.addAttribute("filmDTO", new FilmDTO());
        }
        return "view-create-film";
    }
    
    @PostMapping("/films/creer")
    public String creationFilm(@Valid @ModelAttribute("film") FilmDTO filmDTO, BindingResult result, Model model, RedirectAttributes redirectAttr) {
        if (filmService.consulterFilms().stream().noneMatch(f -> f.getTitre().equals(filmDTO.getTitre())) && !result.hasErrors()) {
            // Film film = new Film();
            // BeanUtils.copyProperties(filmDTO, film);
            // film.setRealisateur(participantService.getParticipantById(filmDTO.getRealisateurId()));
            // filmDTO.getActeursId().forEach(acteurId -> film.getActeurs().add(participantService.getParticipantById(acteurId)));
            // film.setGenre(filmService.findGenreById(filmDTO.getGenreId()));
            int filmId = filmService.creerFilm(filmDTO);
            filmDTO.getActeursId().forEach(acteurId -> {
                participantService.addParticipantToFilm(acteurId, filmId);
            });
            return "redirect:/films/detail?id=" + filmId;
            // return "redirect:/films/creer";
        }
        redirectAttr.addFlashAttribute("org.springframework.validation.BindingResult.filmDTO", result);
        redirectAttr.addFlashAttribute("filmDTO", filmDTO);
        return "redirect:/films/creer";
    }
    
    @GetMapping("/contexte")
    public String afficherContexte(Model model) {
        model.addAttribute("listMembres", contexteService.getListMembre());
        model.addAttribute("membre", null);
        return "view-contexte";
    }
    
    @GetMapping("/contexte/session")
    public String session(@RequestParam(name = "email", required = false) String email, Model model) {
        if (email != null) {
            Membre membre = contexteService.charger(email);
            if (membre != null) {
                model.addAttribute("membre", membre);
            } else {
                return "redirect:/contexte";
            }
        } else {
            model.addAttribute("membre", contexteService.charger("jtrillard@campus-eni.fr"));
        }
        return "view-contexte";
    }
    
    @PostMapping("/avis/creer")
    public String creerAvis(@RequestParam("note") int note, @RequestParam("commentaire") String commentaire, @RequestParam("idMembre") int idMembre, @RequestParam("idFilm") int idFilm) {
        Membre membre = membreService.findMembreById(idMembre);
        Avis avis = new Avis(note, commentaire, membre.getId(), idFilm);
        avisRepository.addAvis(avis);
        return "redirect:/films/detail?id=" + idFilm;
    }
    
    @GetMapping("/genre/creer")
    public String viewCreerGenre(Model model) {
        model.addAttribute("genres", filmService.findAllGenres());
        return "view-genre";
    }
    
    @GetMapping("/membres")
    public String viewMembres(Model model) {
        return "view-membres";
    }
    
    @GetMapping("/membres/detail")
    public String viewMembres(@RequestParam(name = "id") int id, Model model) {
        model.addAttribute("membre", membreService.findMembreById(id));
        return "view-membres-details";
    }
    
    @PostMapping("/genre/creer")
    public String creeGenre(@ModelAttribute("libelle") String libelle) {
        filmService.addGenre(libelle);
        return "redirect:/genre/creer";
    }
    
    @GetMapping("/genre/modifier")
    public String viewModifierGenre(Model model) {
        model.addAttribute("genres", filmService.findAllGenres());
        return "view-editGenre";
    }
    
    @PostMapping("/genre/modifier")
    public String modifierGenre(@ModelAttribute Genre genre) {
        filmService.updateGenre(genre.getTitle(), genre.getId());
        return "redirect:/genre/creer";
    }
}