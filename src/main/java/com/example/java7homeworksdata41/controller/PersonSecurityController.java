package com.example.java7homeworksdata41.controller;

import com.example.java7homeworksdata41.entity.Person;
import com.example.java7homeworksdata41.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("security/persons")
public class PersonSecurityController {

    private final PersonService personService;

    public PersonSecurityController(PersonService personService) {
        this.personService = personService;
    }

    @Secured("ROLE_READ")
    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        return personService.getPersonsByCity(city);
    }

    @RolesAllowed("ROLE_WRITE")
    @GetMapping("/by-age")
    public List<Person> getPersonsByAge(@RequestParam("age") int age) {
        return personService.getPersonsByAge(age);
    }

    @PreAuthorize("hasAnyRole('WRITE', 'DELETE')")
    @GetMapping("/by-name&surname")
    public Optional<Person> getPersonsByNameAndSurname(@RequestParam("name") String name,
                                                       @RequestParam("surname") String surname) {
        return personService.findByNameAndSurname(name, surname);
    }

    @PreAuthorize("#username == authentication.principal.username")
    @GetMapping("/hello")
    public String hello(@RequestParam String username) {
//        var auth = SecurityContextHolder.getContext().getAuthentication();
        return "Hello " + username;
    }

    @GetMapping("/")
    public String homePage() {
        return "Авторизуйся!";
    }
}
