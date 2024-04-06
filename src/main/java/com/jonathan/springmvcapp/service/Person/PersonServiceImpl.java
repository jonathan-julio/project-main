package com.jonathan.springmvcapp.service.Person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jonathan.springmvcapp.model.Person;
import com.jonathan.springmvcapp.model.Profile;

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

    
    @Override
    public Person getPerson(Integer id) {
        List<Person> persons =  personRepository.findAll();
        Person person = new Person();
        for (Person _person : persons) {
            if (_person.getId().equals(id)) {
                person = _person;
            }
        }
        return person;
    }
    

}
