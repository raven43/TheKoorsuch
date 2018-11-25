package app.controller;

import app.entities.*;
import app.repository.ActorRepository;
import app.repository.DirectorRepository;
import app.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/add")
@PreAuthorize("hasAuthority('ADMIN')")
public class AddController {

    @Autowired
    FilmRepository filmRepository;
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    DirectorRepository directorRepository;

    @GetMapping("/film")
    public String film(
            Model model
    ) {
        model.addAttribute("directors", directorRepository.findAll());
        model.addAttribute("genres", Genre.values());
        return "add/film";
    }

    @PostMapping("/film")
    public String filmAdd(
            @AuthenticationPrincipal User user,
            @RequestParam String name,
            @RequestParam String altName,
            @RequestParam short prodYear,
            @RequestParam String description,
            @RequestParam String imageURL,
            @RequestParam Map<String, String> form,
            Model model
    ) {
        Film film = new Film(name,altName,prodYear,description,imageURL);
        Set<String> genres = Arrays.stream(Genre.values())
                .map(Genre::name)
                .collect(Collectors.toSet());
        Set<Genre> s = new HashSet<>();
        for (String key : form.keySet())
            if (genres.contains(key)) s.add(Genre.valueOf(key));

        film.setGenres(s);
        filmRepository.save(film);
        model.addAttribute("genres", Genre.values());
        model.addAttribute("message", "Фильм добавлен");
        model.addAttribute("id", film.getId());

        return "add/film";
    }

    @GetMapping("/director")
    public String director(
            Model model
    ){
        return "add/director";
    }

    @PostMapping("/director")
    public String directorAdd(
            @RequestParam String name,
            @RequestParam Date birth,
            @RequestParam String description,
            @RequestParam String imageURL,
            Model model
    ){
        Director director = new Director(name,birth,description,imageURL);

        directorRepository.save(director);
        model.addAttribute("message", "Режисёр добавлен");
        model.addAttribute("id", director.getId());

        return "add/director";
    }

    @GetMapping("/actor")
    public String actor(Model model){
        return "add/actor";
    }

    @PostMapping("/actor")
    public String actorAdd(
            @RequestParam String name,
            @RequestParam Date birth,
            @RequestParam String description,
            @RequestParam String imageURL,
            Model model
    ){
        Actor actor = new Actor(name,birth,description,imageURL);
        actorRepository.save(actor);
        model.addAttribute("message", "Актер добавлен");
        model.addAttribute("id", actor.getId());

        return "add/actor";
    }





}
