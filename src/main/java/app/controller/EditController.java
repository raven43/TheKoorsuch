package app.controller;

import app.entities.Actor;
import app.entities.Director;
import app.entities.Film;
import app.entities.Genre;
import app.repository.ActorRepository;
import app.repository.DirectorRepository;
import app.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/edit")
@PreAuthorize("hasAuthority('ADMIN')")
public class EditController {
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    DirectorRepository directorRepository;

    @GetMapping
    public String edit(
            Model model
    ){
        model.addAttribute("films",filmRepository.findAll());
        model.addAttribute("actors",actorRepository.findAll());
        model.addAttribute("directors",directorRepository.findAll());
        return "edit/edit";
    }

    @GetMapping("/film")
    public String film(
            @RequestParam Integer id,
            Model model
    ){

        model.addAttribute("genres", Genre.values());
        model.addAttribute("actors", actorRepository.findAll());
        model.addAttribute("directors", directorRepository.findAll());
        model.addAttribute("film",filmRepository.getFilmById(id));

        return "edit/film";
    }
    @PostMapping("/film")
    public String editFilm(
            @RequestParam Integer filmid,
            @RequestParam String name,
            @RequestParam String altName,
            @RequestParam short prodYear,
            @RequestParam String description,
            @RequestParam String imageURL,
            @RequestParam Map<String, String> form,
            Model model
    ){
        Film film = filmRepository.getFilmById(filmid);
        film.setName(name);
        film.setAltName(altName);
        film.setProdYear(prodYear);
        film.setDescription(description);
        film.setImageURL(imageURL);
        Set<String> genres = Arrays.stream(Genre.values())
                .map(Genre::name)
                .collect(Collectors.toSet());
        Set<Genre> s = new HashSet<>();
        for (String key : form.keySet()) {
            if (genres.contains(key)) {
                s.add(Genre.valueOf(key));
            }
        }
        film.setGenres(s);
        filmRepository.save(film);

        model.addAttribute("genres", Genre.values());
        model.addAttribute("actors", actorRepository.findAll());
        model.addAttribute("directors", directorRepository.findAll());
        model.addAttribute("film",filmRepository.getFilmById(filmid));

        model.addAttribute("message", "Фильм изменён");

        return "edit/film";
    }
    @GetMapping("/actor")
    public String actor(
            @RequestParam Integer id,
            Model model
    ){

        model.addAttribute("actor", actorRepository.getActorById(id));
        model.addAttribute("films",filmRepository.findAll());

        return "edit/actor";
    }
    @PostMapping("/actor")
    public String editActor(
            @RequestParam Integer actid,
            @RequestParam String name,
            @RequestParam Date birth,
            @RequestParam String description,
            @RequestParam String imageURL,
            @RequestParam Map<String, String> form,
            Model model
    ){
        Actor actor = actorRepository.getActorById(actid);
        actor.setName(name);
        actor.setBirth(birth);
        actor.setDescription(description);
        actor.setImageURL(imageURL);

        Iterable<Film> films = filmRepository.findAll();

        Set<Film> actfilms = new HashSet<>();
        for (Film f:films)
            if (form.keySet().contains("f" + f.getId().toString()))
                actfilms.add(f);

        actor.setFilms(actfilms);
        actorRepository.save(actor);
        model.addAttribute("actor", actorRepository.getActorById(actid));
        model.addAttribute("films",filmRepository.findAll());
        model.addAttribute("message", "Актёр изменён");

        return "edit/actor";
    }
    @GetMapping("/director")
    public String director(
            @RequestParam Integer id,
            Model model
    ){

        model.addAttribute("director", directorRepository.getDirectorById(id));
        model.addAttribute("films",filmRepository.findAll());

        return "edit/director";
    }
    @PostMapping("/director")
    public String editDirector(
            @RequestParam Integer actid,
            @RequestParam String name,
            @RequestParam Date birth,
            @RequestParam String description,
            @RequestParam String imageURL,
            @RequestParam Map<String, String> form,
            Model model
    ){
        Director director = directorRepository.getDirectorById(actid);
        director.setName(name);
        director.setBirth(birth);
        director.setDescription(description);
        director.setImageURL(imageURL);

        Iterable<Film> films = filmRepository.findAll();

        Set<Film> actfilms = new HashSet<>();
        for (Film f:films)
            if (form.keySet().contains("f" + f.getId().toString()))
                actfilms.add(f);


        director.setFilms(actfilms);
        directorRepository.save(director);
        model.addAttribute("director", directorRepository.getDirectorById(actid));
        model.addAttribute("films",filmRepository.findAll());
        model.addAttribute("message", "Режиссёр изменён");

        return "edit/director";
    }



}
