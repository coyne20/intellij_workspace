package com.example.springbootmvcapp.dao;

import com.example.springbootmvcapp.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDAO {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person)
    {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> getAllPersons();

    int updatePersonById(UUID id, Person person);

    int deletePersonById(UUID id);

    Optional<Person> getPersonById(UUID id);

}
