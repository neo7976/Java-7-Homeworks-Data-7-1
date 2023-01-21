package com.example.java7homeworksdata41.controller;

import com.example.java7homeworksdata41.entity.Person;
import com.example.java7homeworksdata41.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public List<Person> getPersonsByCity(String city) {
        return personService.getPersonsByCity(city);
    }
}
