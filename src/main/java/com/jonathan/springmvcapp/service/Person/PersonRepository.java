package com.jonathan.springmvcapp.service.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jonathan.springmvcapp.model.Person;
import com.jonathan.springmvcapp.model.User;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}