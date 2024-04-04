package com.jonathan.springmvcapp.service.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jonathan.springmvcapp.model.Person;
import com.jonathan.springmvcapp.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {


}