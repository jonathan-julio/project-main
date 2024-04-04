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

    @RequestMapping("login/")
    public String getLogin(@ModelAttribute("user") User user, Model model, HttpSession session) {

        String msg = "Login ou senha invalido.";
        String link = "/login/";
        User user2 = (User) session.getAttribute("user");
        User userSession = new User();

        if (user != null) {
            userSession = user;
        }

        if (user2 != null) {
            userSession = user2;
        }
        
        try {
            User response = userService.login(userSession);

            if (response != null ) {
                List<Post> posts = new ArrayList<>();
                System.out.println(response.toString());
                session.setAttribute("user", response);
                model.addAttribute("posts", posts);
                model.addAttribute("user", response);
                return "home/home";
            }else{
                model.addAttribute("msg", msg);
                model.addAttribute("link", link);
                return "msg";
            }

        } catch (Exception e) {
            msg = "Algo inesperado aconteceu...";
            link = "/login/";
            model.addAttribute("msg", msg);
            model.addAttribute("link", link);
            return "msg";
        }
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
