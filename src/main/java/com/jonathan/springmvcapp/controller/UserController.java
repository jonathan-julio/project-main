package com.jonathan.springmvcapp.controller;

import java.util.ArrayList;
import java.util.List;

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

import jakarta.servlet.http.HttpSession;

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

    @RequestMapping("personalizar/")
    public String getLogin(@ModelAttribute("user") User user, Model model, HttpSession session) {
        
        
        Utils utils = new Utils(userService);
        User userSession = utils.getUser(user, session);
        System.out.println(userSession);
    
        String msg = "Algo inesperado aconteceu...";
        String link = "/login/";
    
        try {
            Profile profile = profileService.getProfile(userSession.getId());
    
            if (utils.isAuthenticated(userSession)) {
                session.setAttribute("user", userSession);
                model.addAttribute("user", userSession);
                model.addAttribute("profile", profile);
                return "home/home";
            }else{
                 msg = "Usuario não autenticado.";
            }
    
        } catch (Exception e) {
            System.err.println(e);
        }
    
        model.addAttribute("msg", msg);
        model.addAttribute("link", link);
        return "msg";
    }

    @RequestMapping("login/")
    public String getPerfil(@ModelAttribute("user") User user, Model model, HttpSession session) {
        
        Utils utils = new Utils(userService);
        User userSession = utils.getUser(user, session);
    
        String msg = "Algo inesperado aconteceu...";
        String link = "/login/";
    
        try {
            Person person = personService.getPerson(userSession.getId());
    
            if (utils.isAuthenticated(userSession)) {
                session.setAttribute("user", userSession);
                model.addAttribute("user", userSession);
                model.addAttribute("person", person);
                return "home/perfil";
            }else{
                 msg = "Usuario não autenticado.";
            }
    
        } catch (Exception e) {
            System.err.println(e);
        }
    
        model.addAttribute("msg", msg);
        model.addAttribute("link", link);
        return "msg";
    }
    


    @RequestMapping("logout/")
    public String logout( Model model, HttpSession session) {

        String msg = "Logout realizado com sucesso..";
        String link = "/login/";

        session.setAttribute("user", null);
        model.addAttribute("msg", msg);
        model.addAttribute("link", link);
        return "msg";
    }

   

    

}
