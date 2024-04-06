package com.jonathan.springmvcapp.service.Person;

import com.jonathan.springmvcapp.model.Person;
import com.jonathan.springmvcapp.model.Profile;

public interface PersonService {

   public Person createrPerson(Person person);

   public Person getPerson(Integer id); 

}
