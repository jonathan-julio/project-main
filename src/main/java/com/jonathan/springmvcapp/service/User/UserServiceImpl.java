package com.jonathan.springmvcapp.service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public boolean login(User user) {
        try {
            System.out.println("getUsername " + user.getUsername());
            System.out.println("getPassword " + user.getPassword());
            User user2 = userRepository.login(user.getUsername(), user.getPassword());
            if (user2 != null) {
                return true;

            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
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