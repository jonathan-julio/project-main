package com.jonathan.springmvcapp.service.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jonathan.springmvcapp.model.Post;
import java.util.List;

@Component
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @SuppressWarnings("null")
    @Override
    public boolean createrPost(Post post) {
        try {
            postRepository.saveAndFlush(post);
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    
}
