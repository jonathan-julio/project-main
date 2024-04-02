package com.jonathan.springmvcapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jonathan.springmvcapp.model.*;
import com.jonathan.springmvcapp.service.Person.PersonService;
import com.jonathan.springmvcapp.service.Profile.ProfileService;
import com.jonathan.springmvcapp.service.User.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PersonService personService;

    @Autowired
    ProfileService profileService;

    @RequestMapping("creater-user/")
    public String getSignup(@ModelAttribute("user") User user, @ModelAttribute("profile") Profile profile,
            @ModelAttribute("person") Person person, Model model) {

        Profile profileAux = profileService.createrProfile(profile);
        Person personAux = personService.createrPerson(person);

        String msg = "Cadastro realizado com sucesso.";
        String link = "/login/";

        if (profileAux.getId() != null && personAux.getId() != null) {
            user.setPerson(personAux.getId());
            user.setProfile(profileAux.getId());
            try {
                userService.createrUser(user);
            } catch (Exception e) {
                msg = "Erro ao criar o usuario";
                link = "creater-user/";
            }
        }

        model.addAttribute("msg", msg);
        model.addAttribute("link", link);
        return "msg";
    }

    @RequestMapping("login/")
    public String getLogin(@ModelAttribute("user") User user, Model model) {

        String msg = "Login ou senha invalido.";
        String link = "/login/";

        try {
            boolean response = userService.login(user);
            if (response) {
                msg = "Autenticação realizada com sucesso.";
                link = "/";
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        model.addAttribute("msg", msg);
        model.addAttribute("link", link);
        return "msg";
    }

}
