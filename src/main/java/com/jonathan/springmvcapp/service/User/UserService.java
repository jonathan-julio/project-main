package com.jonathan.springmvcapp.service.User;

import com.jonathan.springmvcapp.model.User;
import java.util.List;

public interface UserService {

   public User createrUser(User person);

   public User login(User user);

   public User getUserByName(String name);

   public List<User> findAll();

}
