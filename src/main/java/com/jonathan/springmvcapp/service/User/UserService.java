package com.jonathan.springmvcapp.service.User;

import com.jonathan.springmvcapp.model.User;

public interface UserService {

   public User createrUser(User person);

   public boolean login(User user);

}
