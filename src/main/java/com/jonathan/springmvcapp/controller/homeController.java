package com.jonathan.springmvcapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jonathan.springmvcapp.model.*;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping
	public String showMenu(Model model) {
		return "homepage";
	}

	@RequestMapping("login/")
	public String showLogin(Model model) {
		model.addAttribute("user", new User());
		return "login/login";
	}

	@RequestMapping("sign-Up/")
	public String showSignup(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("profile", new Profile());
		model.addAttribute("person", new Person());
		return "signup/signup";
	}

	@RequestMapping("{username}")
    public String getPortifolio(@PathVariable("username") String username, @ModelAttribute("user") User user, Model model){


        return "portfolio";

    }

}
