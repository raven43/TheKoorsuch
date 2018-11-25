package app.controller;

import app.entities.Actor;
import app.entities.Director;
import app.entities.Film;
import app.repository.ActorRepository;
import app.repository.DirectorRepository;
import app.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ViewController {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @GetMapping("/film")
    public String film(
            @RequestParam(name = "id") Integer id,
            Model model
    ) {
        Film film = filmRepository.getFilmById(id);
        model.addAttribute("film", film);
        return "view/film";
    }

    @GetMapping("/films")
    public String films(
            @RequestParam(required = false) Short yearFrom,
            @RequestParam(required = false) Short yearTo,
            Model model
    ) {
        Iterable<Film> films = null;
        if(yearFrom != null||yearTo!=null){
            if (yearFrom==null) films = filmRepository.getByProdYearBetween((short) 1960,yearTo);
            if (yearTo==null) films = filmRepository.getByProdYearBetween(yearFrom,(short) 2020);
            if (yearFrom!=null && yearTo!=null) films = filmRepository.getByProdYearBetween(yearFrom,yearTo);
        }else
            films = filmRepository.findAll();

        model.addAttribute("films", films);
        return "view/films";
    }

    @PostMapping("/films")
    public String del(
            @RequestParam Integer delete,
            Model model
    ){
        filmRepository.deleteById(delete);
        model.addAttribute("films", filmRepository.findAll());
        return "view/films";
    }

    @GetMapping("/actors")
    String actorsAdd(
            Map<String,Object> map
    ){
        Iterable<Actor> actors = actorRepository.findAll();
        map.put("actors",actors);

        return "view/actors";
    }
    @PostMapping("/actors")
    String actors(
            @RequestParam Integer delete,
            Map<String,Object> map
    ){
        actorRepository.deleteById(delete);

        Iterable<Actor> actors = actorRepository.findAll();
        map.put("actors",actors);

        return "view/actors";
    }

    @GetMapping("/actor")
    String actor(
            @RequestParam Integer id,
            Map<String,Object> map
    ){
        Iterable<Film> films = filmRepository.findAll();
        map.put("films", films);

        Actor actor = actorRepository.getActorById(id);
        map.put("actor",actor);
        return "view/actor";
    }

    @PostMapping("/actor")
    String actor(
            @RequestParam Integer actorid,
            @RequestParam Integer filmid,
            Map<String,Object> map
    ){
        Iterable<Film> films = filmRepository.findAll();
        map.put("films", films);

        Actor actor = actorRepository.getActorById(actorid);
        Film film = filmRepository.getFilmById(filmid);

        actor.getFilms().add(film);
        film.getActors().add(actor);

        actorRepository.save(actor);
        filmRepository.save(film);

        map.put("actor",actor);
        return "view/actor";
    }

    @GetMapping("/directors")
    String add(Map<String, Object> map){

        Iterable<Director> directors = directorRepository.findAll();
        map.put("directors", directors);
        return "view/directors";
    }

    @PostMapping("/directors")
    String dir(
            @RequestParam Integer delete,
            Map<String, Object> map
    ){
        if(delete!=null){
            directorRepository.deleteById(delete);
        }
        Iterable<Director> directors = directorRepository.findAll();
        map.put("directors", directors);
        return "view/directors";
    }

    @GetMapping("/director")
    String director(
            @RequestParam Integer id,
            Map<String,Object> map
    ){
        Iterable<Film> films = filmRepository.findAll();
        map.put("films", films);

        Director director = directorRepository.getDirectorById(id);
        map.put("director",director);
        return "view/director";
    }
    @PostMapping("/director")
    String directorAdd(
            @RequestParam Integer dirid,
            @RequestParam Integer filmid,
            Map<String,Object> map
    ){
        Iterable<Film> films = filmRepository.findAll();
        map.put("films", films);

        Director director = directorRepository.getDirectorById(dirid);
        Film film = filmRepository.getFilmById(filmid);

        director.getFilms().add(film);
        film.setDirector(director);

        directorRepository.save(director);
        filmRepository.save(film);

        map.put("director",director);
        return "view/director";
    }
}
