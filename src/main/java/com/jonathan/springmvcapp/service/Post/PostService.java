package com.jonathan.springmvcapp.service.Post;

import com.jonathan.springmvcapp.model.Post;
import java.util.List;

public interface PostService {

    public Post createrPost(Post person);

    public List<Post> getPosts();

    public List<Post> getMyPosts(Integer id); 

}
