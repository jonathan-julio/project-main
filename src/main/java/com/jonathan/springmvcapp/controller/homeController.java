package com.jonathan.springmvcapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class homeController {

	@GetMapping
	public String showMenu(Model model) {
		return "homepage";
	}

	@RequestMapping("login/")
	public String showLogin(Model model) {
		return "login/login";
	}
	@RequestMapping("sign-Up/")
	public String showSignup(Model model) {
		return "signup/signup";
	}

	

}
