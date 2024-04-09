package com.jonathan.springmvcapp.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jonathan.springmvcapp.model.Log;
import com.jonathan.springmvcapp.model.Post;
import com.jonathan.springmvcapp.model.Profile;
import com.jonathan.springmvcapp.model.User;
import com.jonathan.springmvcapp.service.Log.LogService;
import com.jonathan.springmvcapp.service.Profile.ProfileService;
import com.jonathan.springmvcapp.service.User.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/personalizar/")
public class ProfileController {

    @Autowired
    ProfileService profileService;
    @Autowired
    UserService userService;
    @Autowired
    LogService logService;

    @RequestMapping("setProfile/")
    public String setProfile(@ModelAttribute("profile") Profile profile, @ModelAttribute("user") User user, Model model,
            HttpSession session) {

        String msg = "Login ou senha invalido.";
        String link = "/login/";

        Utils utils = new Utils(userService);
        User userSession = utils.getUser(user, session);

        if (utils.isAuthenticated(userSession)) {
            session.setAttribute("user", userSession);
            model.addAttribute("user", userSession);
            model.addAttribute("profile", profile);
            try {
                profileService.setProfile(profile, userSession.getProfile());
                Log log = new Log(userSession.getId(), "setProfile", "Alteração realizada de: " + profile.toString(),
                        LocalDate.now().toString());
                logService.newLog(log);
                return "home/home";
            } catch (Exception e) {
                return "home/home";
            }
        } else {
            msg = "Algo inesperado aconteceu...";
            link = "/login/";
            model.addAttribute("msg", msg);
            model.addAttribute("link", link);
            return "msg";
        }

    }

}
