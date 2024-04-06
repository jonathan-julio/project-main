package com.jonathan.springmvcapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jonathan.springmvcapp.model.*;
import com.jonathan.springmvcapp.service.Person.PersonService;
import com.jonathan.springmvcapp.service.Post.PostRepository;
import com.jonathan.springmvcapp.service.Post.PostService;
import com.jonathan.springmvcapp.service.Profile.ProfileRepository;
import com.jonathan.springmvcapp.service.Profile.ProfileService;
import com.jonathan.springmvcapp.service.User.UserRepository;
import com.jonathan.springmvcapp.service.User.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	UserService userService;

	@Autowired
	ProfileService profileService;

	@Autowired
	PostService postService;

	@Autowired
	PersonService personService;

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
    public String getPortifolio(@PathVariable("username") String username, Model model) {
        
        User user = userService.getUserByName(username);
		System.out.println(user.getId());
		List<Post> posts = postService.getMyPosts(user.getId());
		Profile profile = profileService.getProfile(user.getProfile());
		Person person = personService.getPerson(user.getPerson());

		model.addAttribute("profile", profile);
		model.addAttribute("person", person);
		model.addAttribute("posts",posts);

        return "template";

    }

}
