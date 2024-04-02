package com.jonathan.springmvcapp.service.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jonathan.springmvcapp.model.Profile;

@Component
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    @SuppressWarnings("null")
    @Override
    public Profile createrProfile(Profile profile) {
        try {
            return profileRepository.saveAndFlush(profile);

        } catch (Exception e) {
            System.out.println(e);
            return new Profile();
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
