package app.controller;


import app.entities.Role;
import app.entities.User;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    String register (Map<String, Object> map){
        return "register";
    }
    @PostMapping("/register")
    String addNewUser (
            User user,
            Model model

    ){

        if (userRepository.findByUsername(user.getUsername())!=null) {
            model.addAttribute("message", "user exist!");
            return "register";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        model.addAttribute("message", "Пользователь зарегистрирован");
        return "redirect:/login";
    }
}
