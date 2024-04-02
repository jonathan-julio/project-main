package com.jonathan.springmvcapp.service.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jonathan.springmvcapp.model.Person;

@Component
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @SuppressWarnings("null")
    @Override
    public Person createrPerson(Person person) {
        try {
            return personRepository.saveAndFlush(person);

        } catch (Exception e) {
            System.out.println(e);
            return new Person();
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
