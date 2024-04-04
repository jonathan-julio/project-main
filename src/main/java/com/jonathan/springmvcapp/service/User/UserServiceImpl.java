package com.jonathan.springmvcapp.service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.ArrayList;

import com.jonathan.springmvcapp.model.User;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @SuppressWarnings("null")
    @Override
    public User createrUser(User user) {
        try {
            return userRepository.saveAndFlush(user);

        } catch (Exception e) {
            System.out.println(e);
            return new User();
        }
    }

    @Override
    public User login(User user) {

            User user2 = userRepository.login(user.getUsername(), user.getPassword());
            return user2;
    }

    public List<User> findAll(){
        List<User> users =  userRepository.findAll();
        List<User> usersOut = new ArrayList<>();

        for (User user : users) {
            User userAux = new User();
            userAux.setId(user.getId());
            userAux.setUsername(user.getUsername());
            usersOut.add(userAux);
        }

        return usersOut;

    }

    /*
     * public boolean init = false;
     * 
     * @Autowired
     * public void initCurso() {
     * Pessoa p1 = new Pessoa("João", "Silva","joao@email.com");
     * Pessoa p2 = new Pessoa("Maria", "Santos","maria@email.com");
     * Pessoa p3 = new Pessoa("pedro", "Oliveira","pedro@email.com");
     * 
     * if (init == false) {
     * pessoaRepository.save(p1);
     * pessoaRepository.save(p2);
     * pessoaRepository.save(p3);
     * init = true;
     * }
     * }
     * 
     * @Override
     * public List<Pessoa> getPessoas(){
     * return pessoaRepository.findAll();
     * }
     */

}
