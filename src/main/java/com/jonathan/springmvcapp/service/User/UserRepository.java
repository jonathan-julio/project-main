package com.jonathan.springmvcapp.service.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.jonathan.springmvcapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM `users` where username = :username and password = :password", nativeQuery = true)
    User login(@Param("username") String username, @Param("password") String password);
}