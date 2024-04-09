package com.jonathan.springmvcapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.jonathan.springmvcapp.model.*;
import com.jonathan.springmvcapp.service.Log.LogService;
import com.jonathan.springmvcapp.service.Post.PostService;
import com.jonathan.springmvcapp.service.User.UserService;

import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

@Controller
@RequestMapping("/post/")
public class PostController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @Autowired
    LogService logService;

    @RequestMapping("creater/")
    public String creater(@ModelAttribute("post") Post post, HttpSession session, Model model) {
        List<User> usuarios = userService.findAll();
        User user = (User) session.getAttribute("user");
        System.out.println(user.toString());

        model.addAttribute("post", new Post());
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("user", user);
        /* model.addAttribute("file", file); */
        session.setAttribute("user", user);

        return "post/post";
    }

    @RequestMapping("setPost/")
    public String setPost(@ModelAttribute("post") Post post, @ModelAttribute("file") MultipartFile file,
            HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        Post myPost = post;
        List<Integer> ids = new ArrayList<>();
        ids.add(user.getId());
        if (post.getUsuarios() != null) {
            ids.addAll(post.getUsuarios());
        }
        myPost.setUsuarios(ids);
        String msg = "Projeto postado com sucesso..";
        String link = "/user/login/";

        @SuppressWarnings("null")
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("Arquivo nao valido");
        }
        try {

            myPost.setImg(fileName);
            postService.createrPost(myPost);
            saveImage(file, postService.createrPost(myPost).getId().toString());

        } catch (Exception e) {
            System.out.println("Arquivo nao valido");
            msg = "Erro inesperado...";
        }
        model.addAttribute("user", user);
        model.addAttribute("msg", msg);
        model.addAttribute("link", link);
        session.setAttribute("user", user);
        Log log = new Log(user.getId(), "setPost", "creater post: " + post.toString(),
                LocalDate.now().toString());
        logService.newLog(log);
        return "msg";
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

        model.addAttribute("posts", myPosts);
        model.addAttribute("user", user);
        session.setAttribute("user", user);
        return "post/postList";
    }

    public boolean saveImage(MultipartFile file, String postagem) throws IOException {
        String dir = "C:/Users/natan/Documents/2024-1/project-main/src/main/resources/static/postagens/";
        if (!file.isEmpty()) {
            try {
                File directory = new File(dir + postagem);
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                File newFile = new File(directory.getAbsolutePath() + File.separator + file.getOriginalFilename());
                file.transferTo(newFile);
                return true;
            } catch (IOException e) {
                throw new IOException("Erro ao salvar o arquivo", e);

            }
        } else {
            throw new IOException("O arquivo está vazio");
        }
    }

}
