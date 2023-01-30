package com.example.java7homeworksdata41.controller;

import com.example.java7homeworksdata41.entity.Person;
import com.example.java7homeworksdata41.service.PersonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("user-city/by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        return personService.getPersonsByCity(city);
    }

    @RequestMapping("user-age/by-age")
    public List<Person> getPersonsByAge(@RequestParam("age") int age) {
        return personService.getPersonsByAge(age);
    }

    @RequestMapping("admin/by-name&surname")
    public Optional<Person> getPersonsByNameAndSurname(@RequestParam("name") String name,
                                                       @RequestParam("surname") String surname) {
        return personService.findByNameAndSurname(name, surname);
    }


}