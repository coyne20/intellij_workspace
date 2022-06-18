package com.example.springbootmvcapp.dao;

import com.example.springbootmvcapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import static java.util.List.*;

@Repository("postgres")
public class PersonDataAccessService implements PersonDAO{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> getAllPersons() {
        final String sql = "SELECT id, name FROM person";
        List<Person> people = jdbcTemplate.query(sql, (resultSet, i)->{
            return new Person(UUID.fromString(resultSet.getString("id")),
                            resultSet.getString("name"));
        });
        return people;
        //return Arrays.asList( Person(UUID.randomUUID(),"FROM POSTGRES DB"));
        //return Arrays.asList(new Person(UUID.randomUUID(), name));
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        final String sql = "SELECT id, name FROM person WHERE id = ?";
        Person person = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i)->{
            UUID personId = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Person(personId, name);
        });
        return Optional.ofNullable(person);
    }
}
