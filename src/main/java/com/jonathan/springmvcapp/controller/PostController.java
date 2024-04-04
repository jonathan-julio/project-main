package com.jonathan.springmvcapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jonathan.springmvcapp.model.*;
import com.jonathan.springmvcapp.service.Post.PostService;
import com.jonathan.springmvcapp.service.User.UserService;

import jakarta.servlet.http.HttpSession;

import java.util.*;

@Controller
@RequestMapping("/post/")
public class PostController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;


    @RequestMapping("creater/")
    public String creater(@ModelAttribute("post") Post post, HttpSession session, Model model) {
        List<User> usuarios = userService.findAll();
        User user = (User) session.getAttribute("user");
        System.out.println(user.toString());
        
        model.addAttribute("post", new Post());
        model.addAttribute("usuarios",  usuarios);
        model.addAttribute("user",  user);
        session.setAttribute("user", user);
        return "post/post";
    }

    @RequestMapping("setPost/")
    public String setPost(@ModelAttribute("post") Post post, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        Post myPost = post;
        List<Integer> ids = new ArrayList<>();
        ids.add(user.getId());
        myPost.setUsuarios(ids);
        String msg = "Projeto postado com sucesso..";
        String link = "/user/login/";
        if (postService.createrPost(myPost)) {

            model.addAttribute("user", user);
            model.addAttribute("msg", msg);
            model.addAttribute("link", link);
            session.setAttribute("user", user);
            return "msg";
        }else{
            msg = "Erro inesperado...";
            model.addAttribute("msg", msg);
            model.addAttribute("link", link);
            return "msg";
        }
    }

    @RequestMapping("getPost/")
    public String getPost(@ModelAttribute("post") Post post, HttpSession session, Model model) {
        
        User user = (User) session.getAttribute("user");
        List<Post> posts = postService.getPosts();
        List<Post> myPosts = new ArrayList<>();
        for (Post _post : posts) {
            if (_post.getUsuarios().contains(user.getId())) {
                myPosts.add(_post);
            }
            
        }
        
        model.addAttribute("post", new Post());
        model.addAttribute("posts",  myPosts);
        model.addAttribute("user",  user);
        session.setAttribute("user", user);
        return "post/postList";
    }


    
}
