package com.example.springbootmvcapp.service;

import com.example.springbootmvcapp.dao.PersonDAO;
import com.example.springbootmvcapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDAO personDAO;

    @Autowired //used for injecting another class instance as a parameter
    //public PersonService(@Qualifier("personDAO") PersonDAO personDAO) {this.personDAO = personDAO;}
    public PersonService(@Qualifier("postgres") PersonDAO personDAO) {this.personDAO = personDAO;}

    public int addPerson(Person person){
        return personDAO.insertPerson(person);
    }

    public List<Person> getAllPersons(){
        return personDAO.getAllPersons();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDAO.getPersonById(id);
    }

    public int deletePersonById(UUID id){
        return personDAO.deletePersonById(id);
    }

    public int updatePersonById(UUID id, Person person){
        return personDAO.updatePersonById(id,person);
    }
}
