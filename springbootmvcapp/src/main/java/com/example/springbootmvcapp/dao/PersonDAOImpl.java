package com.example.springbootmvcapp.dao;

import com.example.springbootmvcapp.model.Person;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("personDAO")
public class PersonDAOImpl implements PersonDAO{

    private List<Person> personList = new ArrayList<Person>();

    @Override
    public int insertPerson(UUID id, Person person) {
        personList.add(new Person(id, person.getPerson_name()));
        return 1;
    }

    @Override
    public List<Person> getAllPersons() {
        return personList;
    }

    @Override
    public int updatePersonById(UUID id, Person update) {
        return getPersonById(id)
                .map(person -> {
                    int personToUpdate = personList.indexOf(person);
                    if(personToUpdate >= 0){
                        personList.set(personToUpdate, new Person(id, update.getPerson_name()));
                        return 1;
                    }
                    return 0;
                }).orElse(0);

    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = getPersonById(id);
        if(!(personMaybe.isPresent())){
            return 0;
        }
        personList.remove(personMaybe.get());
        return 1;
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        return personList.stream()
                .filter(person -> person.getPerson_id().equals(id))
                .findFirst();
    }
}
