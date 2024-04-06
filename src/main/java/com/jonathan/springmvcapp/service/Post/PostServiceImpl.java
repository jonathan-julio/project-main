package com.jonathan.springmvcapp.service.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jonathan.springmvcapp.model.Post;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @SuppressWarnings("null")
    @Override
    public Post createrPost(Post post) {
        try {
            postRepository.saveAndFlush(post);
            return postRepository.saveAndFlush(post);

        } catch (Exception e) {
            System.out.println(e);
            Post post2 = new Post();
            return post2;
        }
    }


    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }


    @Override
    public List<Post> getMyPosts(Integer id) {
        List<Post> posts = postRepository.findAll();
        List<Post> posts2 = new ArrayList<>();

        for (Post post : posts) {
            if (post.getUsuarios().contains(id) ) {
                posts2.add(post);
            }
        }
        return posts2;
    }


    
}
