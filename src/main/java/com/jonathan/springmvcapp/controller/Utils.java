package com.jonathan.springmvcapp.controller;



import com.jonathan.springmvcapp.model.User;
import com.jonathan.springmvcapp.service.User.UserService;

import jakarta.servlet.http.HttpSession;

public class Utils {

    
    private UserService userService;
    
    public Utils(UserService userService) {
        this.userService = userService;
    }
    public UserService getUserService() {
        return userService;
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUser(User user,HttpSession session){
        User user2 = (User) session.getAttribute("user");
        User userSession = new User();
        if (user != null) {
            userSession = user;
        }

        if (user2 != null) {
            userSession = user2;
        }
        return userService.login(userSession);

    }
    public boolean isAuthenticated(User userSession){

        try {
            User response = userService.login(userSession);
            if (response != null ) {
                return true;
            }else{
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }

    
    
}
