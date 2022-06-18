package com.example.springbootmvcapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Component
public class Person {
    //class member properties
    private UUID person_id;
    @NotBlank
    private String person_name;

    //Getters and Setters
    public UUID getPerson_id() {
        return person_id;
    }

    public void setPerson_id(UUID person_id) {
        this.person_id = person_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    //Constructor(s)

    //default constructor
    public Person() {
    }

    //parameterised constructor
    public Person(@JsonProperty("id") UUID person_id,
                  @JsonProperty("name") String person_name) {
        this.person_id = person_id;
        this.person_name = person_name;
    }
}
