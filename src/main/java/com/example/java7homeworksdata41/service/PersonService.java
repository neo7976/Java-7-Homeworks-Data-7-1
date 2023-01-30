package com.example.java7homeworksdata41.service;

import com.example.java7homeworksdata41.entity.Person;
import com.example.java7homeworksdata41.repository.PersonRepositoryImp;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepositoryImp personRepositoryImp;

    public PersonService(PersonRepositoryImp personRepositoryImp) {
        this.personRepositoryImp = personRepositoryImp;
    }

    public List<Person> getPersonsByCity(String city) {
        return personRepositoryImp.findAllByCityOrderBySurname(city);
    }

    public List<Person> getPersonsByAge(int age) {
        return personRepositoryImp.findByAgeLessThanOrderByAge(age);
    }


    public Optional<Person> findByNameAndSurname(String name, String surname) {
        return personRepositoryImp.findByNameAndSurname(name, surname);
    }
}