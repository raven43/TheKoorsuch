package app.controller;

import app.repository.ActorRepository;
import app.repository.DirectorRepository;
import app.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    FilmRepository filmRepository;
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    DirectorRepository directorRepository;

    @GetMapping
    public String index(
            @RequestParam(name = "name", required = false, defaultValue = "World")
                    String name,
            Map<String, Object> model) {

        model.put("name", name);
        return "index";
    }

    @GetMapping("/login")
    String login (Map<String, Object> map){
        return "login";
    }

    @GetMapping("/search")
    String search(
            @RequestParam String s,
            Model model
    ){
        model.addAttribute("films",filmRepository.findByNameIsContaining(s));
        model.addAttribute("actors",actorRepository.findByNameContains(s));
        model.addAttribute("directors",directorRepository.findByNameContains(s));
        return "search";
    }

}